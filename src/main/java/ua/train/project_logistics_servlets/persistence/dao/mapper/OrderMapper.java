package ua.train.project_logistics_servlets.persistence.dao.mapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.enums.CargoType;
import ua.train.project_logistics_servlets.enums.OrderStatus;
import ua.train.project_logistics_servlets.persistence.dao.impl.JDBCOrderDao;
import ua.train.project_logistics_servlets.persistence.domain.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class OrderMapper implements ObjectMapper<Order> {
    private static final String DELIVERY_DATE = "delivery_date";
    private static final String ORDER_NUMBER = "order_number";
    private static final String CARGO_TYPE = "cargo_type";
    private static final String ORDER_STATUS = "order_status";
    private static final String SUM = "sum";
    private static final String WEIGHT = "weight";

    private static final Logger LOGGER = LogManager.getLogger(JDBCOrderDao.class);

    @Override
    public Order extractFromResultSet(ResultSet rs) throws SQLException {

        Order order = new Order();

        java.sql.Date dbSqlDate = rs.getDate(DELIVERY_DATE);
        java.util.Date dbSqlDateConverted = new java.util.Date(dbSqlDate.getTime());
        LocalDate date = new java.sql.Date(dbSqlDateConverted.getTime())
                .toLocalDate();

        order.setDeliveryDate(date);
        order.setOrderNumber(rs.getInt(ORDER_NUMBER));
        order.setCargoType(CargoType.valueOf(rs.getString(CARGO_TYPE)));
        order.setOrderStatus(OrderStatus.valueOf(rs.getString(ORDER_STATUS)));
        order.setSum(rs.getBigDecimal(SUM));
        order.setWeight(rs.getBigDecimal(WEIGHT));

        return order;
    }
}
