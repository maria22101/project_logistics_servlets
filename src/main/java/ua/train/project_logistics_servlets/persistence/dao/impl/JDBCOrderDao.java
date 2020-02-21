package ua.train.project_logistics_servlets.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.persistence.dao.OrderDao;
import ua.train.project_logistics_servlets.persistence.dao.mapper.*;
import ua.train.project_logistics_servlets.persistence.domain.Address;
import ua.train.project_logistics_servlets.persistence.domain.Order;
import ua.train.project_logistics_servlets.persistence.domain.User;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class JDBCOrderDao implements OrderDao {
    private OrderMapper orderMapper = new OrderMapper();
    private UserMapper userMapper = new UserMapper();
    private static final Logger LOGGER = LogManager.getLogger(JDBCOrderDao.class);

    private static final String SAVE_ORDER = "INSERT INTO orders " +
            "(user_id, dispatch_address_id, delivery_address_id, delivery_date, " +
            "weight, cargo_type, sum, order_status, route_id) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

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

    private static final String GET_INVOICED_ORDERS_BY_EMAIL =
            "SELECT * FROM orders " +
                    "JOIN users " +
                    "ON orders.user_id=users.id " +
                    "WHERE orders.order_status='INVOICED' AND users.email=?";

    private static final String GET_ALL_ORDERS_WITH_USERS_AND_ADDRESSES_BY_EMAIL =
            "SELECT * FROM orders " +
                    "JOIN users " +
                    "ON orders.user_id=users.id " +
                    "JOIN addresses AS a " +
                    "ON orders.dispatch_address_id=a.id " +
                    "JOIN addresses AS b " +
                    "ON orders.delivery_address_id=b.id " +
                    "WHERE users.email=?";

    private static final String GET_ORDER_BY_ORDER_NUMBER = "SELECT * FROM orders WHERE order_number=?";

    private static final String DISPATCH_ADDRESS_ID_IN_ORDERS = "dispatch_address_id";
    private static final String DELIVERY_ADDRESS_ID_IN_ORDERS = "delivery_address_id";

    @Override
    public void create(Order entity)
            throws DataBaseSaveException {

        try (Connection connection = ConnectionPoolHolder.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(SAVE_ORDER)) {

            prepStatement.setInt(1, entity.getUser().getId());
            prepStatement.setInt(2, entity.getDispatchAddress().getId());
            prepStatement.setInt(3, entity.getDeliveryAddress().getId());
            prepStatement.setDate(4, Date.valueOf(entity.getDeliveryDate()));
            prepStatement.setBigDecimal(5, entity.getWeight());
            prepStatement.setString(6, entity.getCargoType().toString());
            prepStatement.setBigDecimal(7, entity.getSum());
            prepStatement.setString(8, entity.getOrderStatus().toString());
            prepStatement.setInt(9, entity.getRoute().getId());
            prepStatement.execute();

        } catch (Exception e) {
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

//    @Override
//    public List<Order> getIvoicedOrdersByUserEmail(String email)
//            throws DataBaseFetchException {
//
//        List<Order> ordersList = new ArrayList<>();
//        try (Connection connection = ConnectionPoolHolder.getConnection();
//             PreparedStatement prepStatement = connection.prepareStatement(GET_INVOICED_ORDERS_BY_EMAIL)) {
//
////            AddressMapper addressMapper = new AddressMapper();
//            UserMapper userMapper = new UserMapper();
//
//            prepStatement.setString(1, email);
//            ResultSet rs = prepStatement.executeQuery();
//
//            LOGGER.info("Before extracting resultSet");
//
//            while (rs.next()) {
//                Order result = orderMapper.extractFromResultSet(rs);
//                result.setUser(userMapper.extractFromResultSet(rs));
////                result.setDispatchAddress(addressMapper.extractFromResultSet(rs));
////                result.setDeliveryAddress(addressMapper.extractFromResultSet(rs));
//                ordersList.add(result);
//            }
//
//            LOGGER.info("ResultSet extracted");
//
//        } catch (SQLException e) {
//            throw new DataBaseFetchException();
//        }
//        return ordersList;
//    }

//    @Override
//    public List<Order> getAllOrdersWithUserAndAddressesByEmail(String email)
//            throws DataBaseFetchException {
//
//        List<Order> ordersList = new ArrayList<>();
//
//        try (Connection connection = ConnectionPoolHolder.getConnection();
//             PreparedStatement prepStatement = connection
//                     .prepareStatement(GET_ALL_ORDERS_WITH_USERS_AND_ADDRESSES_BY_EMAIL)) {
//
////            AddressMapper addressMapper = new AddressMapper();
//            UserMapper userMapper = new UserMapper();
//
//            prepStatement.setString(1, email);
//            ResultSet rs = prepStatement.executeQuery();
//
//            LOGGER.info("Before extracting resultSet");
//
//            while (rs.next()) {
//                Order result = orderMapper.extractFromResultSet(rs);
//                result.setUser(userMapper.extractFromResultSet(rs));
////                result.setDispatchAddress(addressMapper.extractFromResultSet(rs));
////                result.setDeliveryAddress(addressMapper.extractFromResultSet(rs));
//                ordersList.add(result);
//            }
//
//            LOGGER.info("ResultSet extracted");
//
//        } catch (SQLException e) {
//            throw new DataBaseFetchException();
//        }
//        return ordersList;
//    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public void delete(int id) {

    }
}
