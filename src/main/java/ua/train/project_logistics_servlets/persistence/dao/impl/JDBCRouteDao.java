package ua.train.project_logistics_servlets.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.dao.RouteDao;
import ua.train.project_logistics_servlets.persistence.dao.mapper.RouteMapper;
import ua.train.project_logistics_servlets.persistence.domain.Address;
import ua.train.project_logistics_servlets.persistence.domain.Route;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCRouteDao implements RouteDao {
    private Connection connection;
    private RouteMapper routeMapper = new RouteMapper();
    private static final Logger LOGGER = LogManager.getLogger(JDBCRouteDao.class);

    private static final String GET_ALL_ROUTES = "SELECT * FROM routes";
    private static final String GET_ROUTE_BY_TWO_POINTS = "SELECT * FROM routes WHERE " +
            "(point_one=? AND point_two=?) OR (point_one=? AND point_two=?) " +
            "OR (point_one_ua=? AND point_two_ua=?) OR (point_one_ua=? AND point_two_ua=?) ";
//    private static final String GET_ROUTE_BY_TWO_POINTS_SIMPLIFIED = "SELECT * FROM routes WHERE " +
//            "point_one=? AND point_two=?";

    public JDBCRouteDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Route> findRouteByTwoPoints(String pointOne, String pointTwo)
            throws DataBaseFetchException {

        LOGGER.info("Inside JDBCRouteDao...");
        LOGGER.info("Inside findRouteByTwoPoints()...");

        Optional<Route> route = Optional.empty();

        try (PreparedStatement prepStatement = connection.prepareStatement(GET_ROUTE_BY_TWO_POINTS)) {

            LOGGER.info("Entered inside try block...");
            LOGGER.info("prepStatement={}", prepStatement);
            LOGGER.info("pointOne passing to DB={}", pointOne);
            LOGGER.info("pointTwo passing to DB={}", pointTwo);

            prepStatement.setString(1, pointOne);
            prepStatement.setString(2, pointTwo);
            prepStatement.setString(3, pointTwo);
            prepStatement.setString(4, pointOne);
            prepStatement.setString(5, pointOne);
            prepStatement.setString(6, pointTwo);
            prepStatement.setString(7, pointTwo);
            prepStatement.setString(8, pointOne);
            ResultSet rs = prepStatement.executeQuery();

            LOGGER.info("Before extracting from resultSet...");

            if (rs.next()){
                route = Optional.of(routeMapper.extractFromResultSet(rs));
            }

            LOGGER.info("Extraction from resultSet succeeded...");

        }catch (Exception e) {
            LOGGER.info("Extraction from resultSet failed...");
            throw new DataBaseFetchException();
        }
        return route;
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

            while (rs.next()){
                Route result = routeMapper.extractFromResultSet(rs);
                routesList.add(result);
            }

        } catch (SQLException e) {
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
