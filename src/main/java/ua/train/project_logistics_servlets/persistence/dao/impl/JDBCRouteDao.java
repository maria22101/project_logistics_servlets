package ua.train.project_logistics_servlets.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.persistence.dao.RouteDao;
import ua.train.project_logistics_servlets.persistence.dao.mapper.RouteMapper;
import ua.train.project_logistics_servlets.persistence.domain.Route;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCRouteDao implements RouteDao {
    private Connection connection;
    private RouteMapper routeMapper = new RouteMapper();
    private static final Logger logger = LogManager.getLogger(JDBCRouteDao.class);

    private static final String GET_ALL_ROUTES = "SELECT * FROM routes";

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

    @Override
    public List<Route> findAll() {
        List<Route> routesList = new ArrayList<>();
        try (PreparedStatement prepStatement = connection.prepareStatement(GET_ALL_ROUTES)) {
            ResultSet rs = prepStatement.executeQuery();

            logger.info("Statement created, Result set received. Exctracting from Result set:");

            while (rs.next()){
                Route result = routeMapper.extractFromResultSet(rs);
                routesList.add(result);
            }
            logger.info("ResultSet for delivery_route processed");

        } catch (SQLException e) {
            logger.warn("Data extraction from result set failed");
            new RuntimeException(e);
        }
        return routesList;
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
