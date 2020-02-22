package ua.train.project_logistics_servlets.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.enums.CargoType;
import ua.train.project_logistics_servlets.enums.OrderStatus;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.persistence.dao.OrderDao;
import ua.train.project_logistics_servlets.persistence.dao.mapper.*;
import ua.train.project_logistics_servlets.persistence.domain.Address;
import ua.train.project_logistics_servlets.persistence.domain.Order;
import ua.train.project_logistics_servlets.persistence.domain.User;

import java.math.BigDecimal;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class JDBCOrderDao implements OrderDao {
    private OrderMapper orderMapper = new OrderMapper();

    private static final Logger LOGGER = LogManager.getLogger(JDBCOrderDao.class);

    private static final String CREATE_ORDER = "INSERT INTO orders " +
            "(user_id, dispatch_address_id, delivery_address_id, delivery_date, " +
            "weight, cargo_type, sum, order_status, route_id) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String CREATE_ADDRESS = "INSERT INTO addresses " +
            "(city, street, house, apartment)" + " VALUES(?, ?, ?, ?)";

    private static final String GET_ALL_ORDERS = "SELECT * FROM orders";

    private static final String GET_ALL_ORDERS_WITH_USERS_AND_ADDRESSES =
            "SELECT * FROM orders " +
                    "JOIN users " +
                    "ON orders.user_id=users.id " +
                    "JOIN addresses AS a " +
                    "ON orders.dispatch_address_id=a.id " +
                    "JOIN addresses AS b " +
                    "ON orders.delivery_address_id=b.id " +
                    "LEFT JOIN invoices " +
                    "ON invoices.order_number=orders.order_number";

    private static final String GET_ADDRESS_BY_ID = "SELECT * FROM addresses WHERE id=?";

    private static final String GET_ORDER_BY_ORDER_NUMBER = "SELECT * FROM orders WHERE order_number=?";

    private static final String DISPATCH_ADDRESS_ID_IN_ORDERS = "dispatch_address_id";
    private static final String DELIVERY_ADDRESS_ID_IN_ORDERS = "delivery_address_id";

    @Override
    public void createOrder(int userId,
                            String dispatchCity, String dispatchStreet, String dispatchHouse, String dispatchApartment,
                            String deliveryCity, String deliveryStreet, String deliveryHouse, String deliveryApartment,
                            LocalDate deliveryDate, BigDecimal weight, CargoType cargoType,
                            BigDecimal sum, int routeId)
            throws DataBaseFetchException, DataBaseSaveException {

        try (Connection connection = ConnectionPoolHolder.getConnection()) {

            connection.setAutoCommit(false);
            try (PreparedStatement orderStatement = connection.prepareStatement(CREATE_ORDER);
                 PreparedStatement dispatchAddrStmt = connection
                         .prepareStatement(CREATE_ADDRESS, PreparedStatement.RETURN_GENERATED_KEYS);
                 PreparedStatement deliveryAddrStmt = connection
                         .prepareStatement(CREATE_ADDRESS, PreparedStatement.RETURN_GENERATED_KEYS)) {

                int dispatchAddressId = 0;
                int deliveryAddressId = 0;

                dispatchAddrStmt.setString(1, dispatchCity);
                dispatchAddrStmt.setString(2, dispatchStreet);
                dispatchAddrStmt.setString(3, dispatchHouse);
                dispatchAddrStmt.setString(4, dispatchApartment);
                dispatchAddrStmt.executeUpdate();
                ResultSet rsDispatch = dispatchAddrStmt.getGeneratedKeys();
                if (rsDispatch.next()) {
                    dispatchAddressId = rsDispatch.getInt(1);
                }

                deliveryAddrStmt.setString(1, deliveryCity);
                deliveryAddrStmt.setString(2, deliveryStreet);
                deliveryAddrStmt.setString(3, deliveryHouse);
                deliveryAddrStmt.setString(4, deliveryApartment);
                deliveryAddrStmt.executeUpdate();
                ResultSet rsDelivery = deliveryAddrStmt.getGeneratedKeys();
                if (rsDelivery.next()) {
                    deliveryAddressId = rsDelivery.getInt(1);
                }

                orderStatement.setInt(1, userId);
                orderStatement.setInt(2, dispatchAddressId);
                orderStatement.setInt(3, deliveryAddressId);
                orderStatement.setDate(4, Date.valueOf(deliveryDate));
                orderStatement.setBigDecimal(5, weight);
                orderStatement.setString(6, cargoType.toString());
                orderStatement.setBigDecimal(7, sum);
                orderStatement.setString(8, OrderStatus.OPEN.toString());
                orderStatement.setInt(9, routeId);

                orderStatement.executeUpdate();

                connection.commit();
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                throw new DataBaseSaveException();
            }

        } catch (
                SQLException e) {
            throw new DataBaseSaveException();
        }
    }

    @Override
    public Optional<Order> findById(int id)
            throws DataBaseFetchException {

        Optional<Order> order = Optional.empty();

        try (Connection connection = ConnectionPoolHolder.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(GET_ORDER_BY_ORDER_NUMBER)) {

            prepStatement.setInt(1, id);
            ResultSet rs = prepStatement.executeQuery();
            if (rs.next()) {
                order = Optional.of(orderMapper.extractFromResultSet(rs));
            }

        } catch (Exception e) {
            throw new DataBaseFetchException();
        }
        return order;
    }

    @Override
    public List<Order> findAll()
            throws DataBaseFetchException {

        List<Order> ordersList = new ArrayList<>();

        try (Connection connection = ConnectionPoolHolder.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(GET_ALL_ORDERS)) {

            ResultSet rs = prepStatement.executeQuery();
            while (rs.next()) {
                Order result = orderMapper.extractFromResultSet(rs);
                ordersList.add(result);
            }

        } catch (SQLException e) {
            throw new DataBaseFetchException();
        }
        return ordersList;
    }

    @Override
    public List<Order> getAllOrdersWithUserAndAddresses()
            throws DataBaseFetchException {

        List<Order> ordersList = new ArrayList<>();
        try (Connection connection = ConnectionPoolHolder.getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement prepAddressStatement = connection.prepareStatement(GET_ADDRESS_BY_ID)) {

            AddressMapper addressMapper = new AddressMapper();
            UserMapper userMapper = new UserMapper();
            AddressMapperByIntId dispatchAddressMapper =
                    new AddressMapperByIntId(prepAddressStatement, DISPATCH_ADDRESS_ID_IN_ORDERS);
            AddressMapperByIntId deliveryAddressMapper =
                    new AddressMapperByIntId(prepAddressStatement, DELIVERY_ADDRESS_ID_IN_ORDERS);

            ResultSet rs = statement.executeQuery(GET_ALL_ORDERS_WITH_USERS_AND_ADDRESSES);

            while (rs.next()) {
                Order result = orderMapper.extractFromResultSet(rs);

                User user = userMapper.extractFromResultSet(rs);

                Address dispatchAddress = dispatchAddressMapper
                        .extractFromResultSet(rs, addressMapper)
                        .orElseThrow(DataBaseFetchException::new);

                Address deliveryAddress = deliveryAddressMapper
                        .extractFromResultSet(rs, addressMapper)
                        .orElseThrow(DataBaseFetchException::new);

                result.setUser(user);
                result.setDispatchAddress(dispatchAddress);
                result.setDeliveryAddress(deliveryAddress);

                ordersList.add(result);
            }

        } catch (SQLException e) {
            throw new DataBaseFetchException();
        }
        return ordersList;
    }

    @Override
    public void create(Order entity)
            throws DataBaseSaveException {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void update(Order entity) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
