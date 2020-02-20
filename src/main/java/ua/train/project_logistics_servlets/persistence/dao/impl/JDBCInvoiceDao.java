package ua.train.project_logistics_servlets.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.enums.OrderStatus;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.persistence.dao.InvoiceDao;
import ua.train.project_logistics_servlets.persistence.dao.mapper.InvoiceMapper;
import ua.train.project_logistics_servlets.persistence.domain.Invoice;

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

    @Override
    public void create(Invoice entity)
            throws DataBaseSaveException {

//        try (Connection connection = ConnectionPoolHolder.getConnection();
//                PreparedStatement prepStatement = connection.prepareStatement(CREATE_INVOICE)) {
//
//            prepStatement.setInt(1, entity.getOrder().getOrderNumber());
//            prepStatement.execute();
//
//        } catch (Exception e) {
//            throw new DataBaseSaveException();
//        }
    }

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
        public Optional<Invoice> findById ( int id) throws DataBaseFetchException {
            return Optional.empty();
        }

        @Override
        public List<Invoice> findAll ()
            throws DataBaseFetchException {

            List<Invoice> invoicesList = new ArrayList<>();

            try (Connection connection = ConnectionPoolHolder.getConnection();
                 Statement statement = connection.createStatement()) {

                LOGGER.info("Before executing query");

                ResultSet rs = statement.executeQuery(GET_ALL_INVOICES);

                while (rs.next()) {
                    LOGGER.info("Inside Resultset iteration");
                    Invoice result = invoiceMapper.extractFromResultSet(rs);
                    invoicesList.add(result);
                }

            } catch (SQLException e) {
                throw new DataBaseFetchException();
            }
            return invoicesList;
        }

        @Override
        public void update (Invoice entity){

        }

        @Override
        public void delete ( int id){

        }

    }
