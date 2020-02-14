package ua.train.project_logistics_servlets.persistence.dao.mapper;

import ua.train.project_logistics_servlets.persistence.domain.Route;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class RouteMapper implements ObjectMapper<Route> {
    @Override
    public Route extractFromResultSet(ResultSet rs) throws SQLException {
        Route route = new Route();
        route.setId(rs.getInt("id"));
        route.setPointOne(rs.getString("point_one"));
        route.setPointOneUA(rs.getString("point_one_ua"));
        route.setPointTwo(rs.getString("point_two"));
        route.setPointTwoUA(rs.getString("point_two_ua"));
        route.setBasicRate(rs.getBigDecimal("basic_rate"));
        return route;
    }
}
