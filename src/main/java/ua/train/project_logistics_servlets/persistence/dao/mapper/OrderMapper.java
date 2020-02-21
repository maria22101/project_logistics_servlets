package ua.train.project_logistics_servlets.persistence.dao.mapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.enums.CargoType;
import ua.train.project_logistics_servlets.enums.OrderStatus;
import ua.train.project_logistics_servlets.persistence.dao.impl.JDBCOrderDao;
import ua.train.project_logistics_servlets.persistence.domain.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class OrderMapper implements ObjectMapper<Order> {

    private static final Logger LOGGER = LogManager.getLogger(JDBCOrderDao.class);

    @Override
    public Order extractFromResultSet(ResultSet rs) throws SQLException {

        Order order = new Order();

        java.sql.Date dbSqlDate = rs.getDate("delivery_date");
        java.util.Date dbSqlDateConverted = new java.util.Date(dbSqlDate.getTime());
        LocalDate date = new java.sql.Date(dbSqlDateConverted.getTime())
                .toLocalDate();

        order.setDeliveryDate(date);
        order.setOrderNumber(rs.getInt("order_number"));
        order.setCargoType(CargoType.valueOf(rs.getString("cargo_type")));
        order.setOrderStatus(OrderStatus.valueOf(rs.getString("order_status")));
        order.setSum(rs.getBigDecimal("sum"));
        order.setWeight(rs.getBigDecimal("weight"));

        return order;
    }
}
