package ua.train.project_logistics_servlets.model.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.controller.command.LoginCommand;
import ua.train.project_logistics_servlets.model.dao.RouteDao;
import ua.train.project_logistics_servlets.model.entity.Route;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCRouteDao implements RouteDao {
    private static final Logger logger = LogManager.getLogger(JDBCRouteDao.class);
    private Connection connection;

    public JDBCRouteDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Route entity) {

    }

    @Override
    public Route findById(int id) {
        return null;
    }

    private Route extractFromResultSet(ResultSet rs)
            throws SQLException {
        Route route = new Route();
        route.setId(rs.getLong("id") );
        route.setBasicRate(rs.getBigDecimal("basic_rate"));
        route.setDestination( rs.getString("destination"));
        route.setSource( rs.getString("source") );
        return route;
    }

    @Override
    public List<Route> findAll() {
        List<Route> resultList = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM delivery_route");

            logger.info("Statement created, Result set received. Exctracting from Result set:");

            while ( rs.next() ){
                Route result = extractFromResultSet(rs);
                resultList.add(result);
            }
            logger.info("ResultSet for delivery_route processed");

        } catch (SQLException e) {
            logger.warn("Data extraction from result set failed");
            new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public void update(Route entity) {

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
