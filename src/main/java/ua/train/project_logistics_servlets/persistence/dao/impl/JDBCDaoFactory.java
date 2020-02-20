package ua.train.project_logistics_servlets.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.persistence.dao.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao();
    }

    @Override
    public RouteDao createRouteDao() {
        return new JDBCRouteDao();
    }

    @Override
    public OrderDao createOrderDao() {
        return new JDBCOrderDao();
    }

    @Override
    public InvoiceDao createInvoiceDao() {
        return new JDBCInvoiceDao();
    }

    @Override
    public AddressDao createAddressDao() {
        return new JDBCAddressDao();
    }
}
