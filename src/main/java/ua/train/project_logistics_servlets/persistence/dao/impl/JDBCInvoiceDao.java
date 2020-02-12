package ua.train.project_logistics_servlets.persistence.dao.impl;

import ua.train.project_logistics_servlets.persistence.dao.InvoiceDao;
import ua.train.project_logistics_servlets.persistence.domain.Invoice;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCInvoiceDao implements InvoiceDao {
    private Connection connection;

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
