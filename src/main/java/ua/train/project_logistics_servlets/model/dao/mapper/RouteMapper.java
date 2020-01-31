package ua.train.project_logistics_servlets.model.dao.mapper;

import ua.train.project_logistics_servlets.model.entity.Address;
import ua.train.project_logistics_servlets.model.entity.Order;
import ua.train.project_logistics_servlets.model.entity.Route;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
