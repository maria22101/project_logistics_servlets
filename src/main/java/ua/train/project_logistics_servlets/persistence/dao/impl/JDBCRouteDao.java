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
    private RouteMapper routeMapper = new RouteMapper();
    private static final Logger LOGGER = LogManager.getLogger(JDBCRouteDao.class);

    private static final String GET_ALL_ROUTES = "SELECT * FROM routes";

    private static final String GET_ROUTE_BY_TWO_POINTS = "SELECT * FROM routes WHERE " +
            "(point_one=? AND point_two=?) OR (point_one=? AND point_two=?) " +
            "OR (point_one_ua=? AND point_two_ua=?) OR (point_one_ua=? AND point_two_ua=?)";

    private static final String GET_ROUTE_ID_BY_TWO_POINTS = "SELECT id FROM routes WHERE " +
            "(point_one=? AND point_two=?) OR (point_one=? AND point_two=?) " +
            "OR (point_one_ua=? AND point_two_ua=?) OR (point_one_ua=? AND point_two_ua=?) ";

    public int getRouteIdByTwoPoints(String pointOne, String pointTwo)
            throws DataBaseFetchException {
//
//        int routeId = 0;
//
//        try (Connection connection = ConnectionPoolHolder.getConnection();
//             PreparedStatement prepStatement = connection.prepareStatement(GET_ROUTE_ID_BY_TWO_POINTS)) {
//
//            prepStatement.setString(1, pointOne);
//            prepStatement.setString(2, pointTwo);
//            prepStatement.setString(3, pointTwo);
//            prepStatement.setString(4, pointOne);
//            prepStatement.setString(5, pointOne);
//            prepStatement.setString(6, pointTwo);
//            prepStatement.setString(7, pointTwo);
//            prepStatement.setString(8, pointOne);
//            ResultSet rs = prepStatement.executeQuery();
//
//            LOGGER.info(("inside getRouteByIdByTwoPoints"));
//
//            if (rs.next()) {
//                routeId = rs.getInt(1);
//            }
//
//            LOGGER.info("routeId={}", routeId);
//
//        } catch (Exception e) {
//            throw new DataBaseFetchException();
//        }

        return 0;
    }

    @Override
    public Optional<Route> findRouteByTwoPoints(String pointOne, String pointTwo)
            throws DataBaseFetchException {

        LOGGER.info("inside RouteDao, came into findRouteByTwoPoints...");

        Optional<Route> route = Optional.empty();

        try (Connection connection = ConnectionPoolHolder.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(GET_ROUTE_BY_TWO_POINTS)) {

            prepStatement.setString(1, pointOne);
            prepStatement.setString(2, pointTwo);
            prepStatement.setString(3, pointTwo);
            prepStatement.setString(4, pointOne);
            prepStatement.setString(5, pointOne);
            prepStatement.setString(6, pointTwo);
            prepStatement.setString(7, pointTwo);
            prepStatement.setString(8, pointOne);
            ResultSet rs = prepStatement.executeQuery();

            LOGGER.info("before iterating rs, rs={}", rs);

            if (rs.next()) {
                route = Optional.of(routeMapper.extractFromResultSet(rs));
            }

            LOGGER.info("after iterating rs, route={}", route);

        } catch (Exception e) {
            throw new DataBaseFetchException();
        }
        return route;
    }

    @Override
    public List<Route> findAll()
            throws DataBaseFetchException {

        List<Route> routesList = new ArrayList<>();
        try (Connection connection = ConnectionPoolHolder.getConnection();
                Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(GET_ALL_ROUTES);

            while (rs.next()) {
                Route result = routeMapper.extractFromResultSet(rs);
                routesList.add(result);
            }

        } catch (SQLException e) {
            throw new DataBaseFetchException();
        }
        return routesList;
    }

    @Override
    public void create(Route entity) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public Optional<Route> findById(int id) throws DataBaseFetchException {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void update(Route entity) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
