package ua.train.project_logistics_servlets.model.dao.impl;

import ua.train.project_logistics_servlets.model.dao.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    @Override
    public RouteDao createRouteDao() {
        return new JDBCRouteDao(getConnection());
    }

    @Override
    public OrderDao createOrderDao() {
        return new JDBCOrderDao(getConnection());
    }

    @Override
    public InvoiceDao createInvoiceDao() {
        return new JDBCInvoiceDao(getConnection());
    }

    @Override
    public AddressDao createAddressDao() {
        return new JDBCAddressDao(getConnection());
    }

    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
