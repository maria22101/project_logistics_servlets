package ua.train.project_logistics_servlets.persistence.dao.mapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.persistence.dao.impl.JDBCOrderDao;
import ua.train.project_logistics_servlets.persistence.domain.Route;

import java.sql.ResultSet;
import java.sql.SQLException;

import static ua.train.project_logistics_servlets.constant.EntityFieldConstant.ID;

public class RouteMapper implements ObjectMapper<Route> {
    private static final String BASIC_RATE = "basic_rate";
    private static final String POINT_ONE = "point_one";
    private static final String POINT_ONE_UA = "point_one_ua";
    private static final String POINT_TWO = "point_two";
    private static final String POINT_TWO_UA = "point_two_ua";

    private static final Logger LOGGER = LogManager.getLogger(JDBCOrderDao.class);

    @Override
    public Route extractFromResultSet(ResultSet rs) throws SQLException {

        Route route = new Route();

        route.setId(rs.getInt(ID));
        route.setBasicRate(rs.getBigDecimal(BASIC_RATE));
        route.setPointOne(rs.getString(POINT_ONE));
        route.setPointOneUA(rs.getString(POINT_ONE_UA));
        route.setPointTwo(rs.getString(POINT_TWO));
        route.setPointTwoUA(rs.getString(POINT_TWO_UA));

        return route;
    }
}
