package ua.train.project_logistics_servlets.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.persistence.dao.OrderDao;
import ua.train.project_logistics_servlets.persistence.dao.mapper.OrderMapper;
import ua.train.project_logistics_servlets.persistence.dao.mapper.RouteMapper;
import ua.train.project_logistics_servlets.persistence.domain.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCOrderDao implements OrderDao {
    private Connection connection;
    private OrderMapper orderMapper = new OrderMapper();
    private static final Logger LOGGER = LogManager.getLogger(JDBCOrderDao.class);

    public JDBCOrderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Order entity) {

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
