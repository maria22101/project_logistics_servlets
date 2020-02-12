package ua.train.project_logistics_servlets.persistence.dao.mapper;

import ua.train.project_logistics_servlets.persistence.domain.Route;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class RouteMapper implements ObjectMapper<Route> {
    @Override
    public Route extractFromResultSet(ResultSet rs) throws SQLException {
        Route route = new Route();
        route.setId(rs.getLong("route_id"));
        route.setSource(rs.getString("source"));
        route.setBasicRate(rs.getBigDecimal("basicRate") );
        return route;
    }

    //TODO - correct
    @Override
    public Route makeUnique(Map<Integer, Route> cache, Route route) {
//        cache.putIfAbsent(route.getId(), route);
//        return cache.get(route.getId());
        return new Route();
    }
}
