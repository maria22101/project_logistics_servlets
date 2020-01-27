package ua.train.project_logistics_servlets.model.dao.impl;

import ua.train.project_logistics_servlets.model.dao.RouteDao;
import ua.train.project_logistics_servlets.model.entity.Route;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCRouteDao implements RouteDao {
    private Connection connection;

    public JDBCRouteDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Route entity) {

    }

    @Override
    public Route findById(int id) {
        return null;
    }

    @Override
    public List<Route> findAll() {
        return null;
    }

    @Override
    public void update(Route entity) {

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
