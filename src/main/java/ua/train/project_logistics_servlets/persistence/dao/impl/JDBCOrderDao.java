package ua.train.project_logistics_servlets.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.persistence.dao.OrderDao;
import ua.train.project_logistics_servlets.persistence.dao.mapper.OrderMapper;
import ua.train.project_logistics_servlets.persistence.dao.mapper.RouteMapper;
import ua.train.project_logistics_servlets.persistence.domain.Order;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JDBCOrderDao implements OrderDao {
    private Connection connection;
    private OrderMapper orderMapper = new OrderMapper();
    private static final Logger LOGGER = LogManager.getLogger(JDBCOrderDao.class);

    private static final String SAVE_ORDER = "INSERT INTO orders " +
            "(user_id, dispatch_address_id, delivery_address_id, delivery_date, " +
            "weight, cargo_type, sum, order_status, route_id) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public JDBCOrderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Order entity)
            throws DataBaseSaveException {

        LOGGER.info("Inside JDBCOrderDao...");
        LOGGER.info("Inside create()...");

        try (PreparedStatement prepStatement = connection.prepareStatement(SAVE_ORDER)) {

            LOGGER.info("Entered inside try block...");

            LOGGER.info("user_id={}", entity.getUser().getId());
            LOGGER.info("dispatch_address_id={}", entity.getDispatchAddress().getId());
            LOGGER.info("delivery_address_id={}", entity.getDeliveryAddress().getId());
            LOGGER.info("delivery_date={}", Date.valueOf(entity.getDeliveryDate()));
            LOGGER.info("weight={}", entity.getWeight());
            LOGGER.info("cargo_type={}", entity.getCargoType().toString());
            LOGGER.info("sum={}", entity.getSum());
            LOGGER.info("order_status={}", entity.getOrderStatus().toString());
            LOGGER.info("route_id={}", entity.getRoute().getId());

            prepStatement.setInt(1, entity.getUser().getId());
            prepStatement.setInt(2, entity.getDispatchAddress().getId());
            prepStatement.setInt(3, entity.getDeliveryAddress().getId());
            prepStatement.setDate(4, Date.valueOf(entity.getDeliveryDate()));
            prepStatement.setBigDecimal(5, entity.getWeight());
            prepStatement.setString(6, entity.getCargoType().toString());
            prepStatement.setBigDecimal(7, entity.getSum());
            prepStatement.setString(8, entity.getOrderStatus().toString());
            prepStatement.setInt(9, entity.getRoute().getId());
            prepStatement.execute();

            LOGGER.info("after executing prepStatement");

        } catch (Exception e) {
            throw new DataBaseSaveException();
        }
    }

    @Override
    public Order findById(int id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public void update(Order entity) {

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
