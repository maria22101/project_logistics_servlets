package ua.train.project_logistics_servlets.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.persistence.dao.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {
    private static final Logger logger = LogManager.getLogger(JDBCDaoFactory.class);

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

    private Connection getConnection() {
        try {
            logger.info("Trying to Connect to database via ConnectionPool");
            return dataSource.getConnection();
        } catch (SQLException e) {
            logger.warn("Failed Connection to database via ConnectionPool");
            throw new RuntimeException(e);
        }

//        try {
//            Driver driver = new com.mysql.jdbc.Driver();
//            return DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/delivery1",
//                    "root" ,
//                    "tigra263" );
//        } catch (SQLException e) {
//            logger.info("Unable to set up connection");
//            throw new RuntimeException(e);
//        }
    }
}
