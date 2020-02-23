package ua.train.project_logistics_servlets.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.enums.OrderStatus;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.persistence.dao.InvoiceDao;
import ua.train.project_logistics_servlets.persistence.dao.mapper.*;
import ua.train.project_logistics_servlets.persistence.domain.Address;
import ua.train.project_logistics_servlets.persistence.domain.Invoice;
import ua.train.project_logistics_servlets.persistence.domain.Order;
import ua.train.project_logistics_servlets.persistence.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCInvoiceDao implements InvoiceDao {
    private InvoiceMapper invoiceMapper = new InvoiceMapper();
    private static final Logger LOGGER = LogManager.getLogger(JDBCInvoiceDao.class);

    private static final String GET_ALL_INVOICES = "SELECT * FROM invoices";

    private static final String CREATE_INVOICE =
            "INSERT INTO invoices (is_paid, order_number) VALUES(?, ?)";

    private static final String PAY_INVOICE =
            "UPDATE invoices SET is_paid=? WHERE order_number=?";

    private static final String UPDATE_ORDER_STATUS =
            "UPDATE orders SET order_status=? WHERE order_number=?";

    private static final String GET_ALL_INVOICES_WITH_ORDERS_AND_USERS_AND_ADDRESSES =
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

    private static final String DISPATCH_ADDRESS_ID_IN_ORDERS = "dispatch_address_id";
    private static final String DELIVERY_ADDRESS_ID_IN_ORDERS = "delivery_address_id";

    @Override
    public void issueInvoice(int orderId)
            throws DataBaseSaveException {

        try (Connection connection = ConnectionPoolHolder.getConnection()) {

            connection.setAutoCommit(false);
            try (PreparedStatement issueInvoiceStatement = connection.prepareStatement(CREATE_INVOICE);
                 PreparedStatement updateOrderStatement = connection.prepareStatement(UPDATE_ORDER_STATUS)) {

                issueInvoiceStatement.setBoolean(1, false);
                issueInvoiceStatement.setInt(2, orderId);

                updateOrderStatement.setString(1, OrderStatus.INVOICED.toString());
                updateOrderStatement.setInt(2, orderId);

                issueInvoiceStatement.executeUpdate();
                updateOrderStatement.executeUpdate();

                connection.commit();
                connection.setAutoCommit(true);

            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                throw new DataBaseSaveException();
            }

        } catch (SQLException e) {
            throw new DataBaseSaveException();
        }
    }

    @Override
    public void payInvoice(int orderId)
            throws DataBaseSaveException {

        try (Connection connection = ConnectionPoolHolder.getConnection()) {

            connection.setAutoCommit(false);
            try (PreparedStatement invoiceStatement = connection.prepareStatement(PAY_INVOICE);
                 PreparedStatement orderStatement = connection.prepareStatement(UPDATE_ORDER_STATUS)) {

                invoiceStatement.setBoolean(1, true);
                invoiceStatement.setInt(2, orderId);

                orderStatement.setString(1, OrderStatus.READY_FOR_DISPATCH.toString());
                orderStatement.setInt(2, orderId);

                invoiceStatement.executeUpdate();
                orderStatement.executeUpdate();

                connection.commit();
                connection.setAutoCommit(true);

            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                throw new DataBaseSaveException();
            }

        } catch (SQLException e) {
            throw new DataBaseSaveException();
        }

    }

    @Override
    public List<Invoice> getAllInvoicesWithOrdersAndUserAndAddresses()
            throws DataBaseFetchException {

        List<Invoice> invoicesList = new ArrayList<>();
        try (Connection connection = ConnectionPoolHolder.getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement prepAddressStatement = connection.prepareStatement(GET_ADDRESS_BY_ID)) {

            OrderMapper orderMapper = new OrderMapper();
            UserMapper userMapper = new UserMapper();
            AddressMapper addressMapper = new AddressMapper();
            AddressMapperByIntId dispatchAddressMapper =
                    new AddressMapperByIntId(prepAddressStatement, DISPATCH_ADDRESS_ID_IN_ORDERS);
            AddressMapperByIntId deliveryAddressMapper =
                    new AddressMapperByIntId(prepAddressStatement, DELIVERY_ADDRESS_ID_IN_ORDERS);

            ResultSet rs = statement.executeQuery(GET_ALL_INVOICES_WITH_ORDERS_AND_USERS_AND_ADDRESSES);

            while (rs.next()) {
                Invoice result = invoiceMapper.extractFromResultSet(rs);

                Order order = orderMapper.extractFromResultSet(rs);

                User user = userMapper.extractFromResultSet(rs);

                Address dispatchAddress = dispatchAddressMapper
                        .extractFromResultSet(rs, addressMapper)
                        .orElseThrow(DataBaseFetchException::new);

                Address deliveryAddress = deliveryAddressMapper
                        .extractFromResultSet(rs, addressMapper)
                        .orElseThrow(DataBaseFetchException::new);

                order.setUser(user);
                order.setDispatchAddress(dispatchAddress);
                order.setDeliveryAddress(deliveryAddress);

                result.setOrder(order);

                invoicesList.add(result);
            }

        } catch (SQLException e) {
            throw new DataBaseFetchException();
        }
        return invoicesList;
    }

    @Override
    public List<Invoice> findAll()
            throws DataBaseFetchException {

//        List<Invoice> invoicesList = new ArrayList<>();
//
//        try (Connection connection = ConnectionPoolHolder.getConnection();
//             Statement statement = connection.createStatement()) {
//
//            ResultSet rs = statement.executeQuery(GET_ALL_INVOICES);
//
//            while (rs.next()) {
//                Invoice result = invoiceMapper.extractFromResultSet(rs);
//                invoicesList.add(result);
//            }
//
//        } catch (SQLException e) {
//            throw new DataBaseFetchException();
//        }
//        return invoicesList;

        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void update(Invoice entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void create(Invoice entity)
            throws DataBaseSaveException {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public Optional<Invoice> getInvoiceByOrderNumber(int orderNumber)
            throws DataBaseFetchException {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public Optional<Invoice> findById(int id) throws DataBaseFetchException {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
