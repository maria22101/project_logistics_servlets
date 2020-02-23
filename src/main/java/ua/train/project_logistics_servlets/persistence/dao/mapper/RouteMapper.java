package ua.train.project_logistics_servlets.persistence.dao.mapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.persistence.dao.impl.JDBCOrderDao;
import ua.train.project_logistics_servlets.persistence.domain.Route;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class RouteMapper implements ObjectMapper<Route> {
    private static final Logger LOGGER = LogManager.getLogger(JDBCOrderDao.class);

    @Override
    public Route extractFromResultSet(ResultSet rs) throws SQLException {

        Route route = new Route();

        route.setId(rs.getInt("id"));
        route.setBasicRate(rs.getBigDecimal("basic_rate"));
        route.setPointOne(rs.getString("point_one"));
        route.setPointOneUA(rs.getString("point_one_ua"));
        route.setPointTwo(rs.getString("point_two"));
        route.setPointTwoUA(rs.getString("point_two_ua"));

        return route;
    }
}
