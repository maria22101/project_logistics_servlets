package ua.train.project_logistics_servlets.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.persistence.dao.InvoiceDao;
import ua.train.project_logistics_servlets.persistence.dao.mapper.InvoiceMapper;
import ua.train.project_logistics_servlets.persistence.dao.mapper.RouteMapper;
import ua.train.project_logistics_servlets.persistence.domain.Invoice;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCInvoiceDao implements InvoiceDao {
    private Connection connection;
    private InvoiceMapper invoiceMapper = new InvoiceMapper();
    private static final Logger LOGGER = LogManager.getLogger(JDBCInvoiceDao.class);

    public JDBCInvoiceDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Invoice entity) {

    }

    @Override
    public Invoice findById(int id) {
        return null;
    }

    @Override
    public List<Invoice> findAll() {
        return null;
    }

    @Override
    public void update(Invoice entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
