package ua.train.project_logistics_servlets.persistence.dao.impl;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionPoolHolder {
    private static ResourceBundle bundle = ResourceBundle.getBundle("db");
    private static final String URL = bundle.getString("db.url");
    private static final String USERNAME = bundle.getString("db.username");
    private static final String PASSWORD = bundle.getString("db.password");
    private static volatile DataSource dataSource;

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static DataSource getDataSource(){

        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    ds.setUrl(URL);
                    ds.setUsername(USERNAME);
                    ds.setPassword(PASSWORD);
                    ds.setMinIdle(5);
                    ds.setMaxIdle(10);
                    ds.setMaxOpenPreparedStatements(100);
                    dataSource = ds;
                }
            }
        }
        return dataSource;
    }
}
