package ua.train.project_logistics_servlets.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.persistence.dao.AddressDao;
import ua.train.project_logistics_servlets.persistence.dao.mapper.AddressMapper;
import ua.train.project_logistics_servlets.persistence.dao.mapper.RouteMapper;
import ua.train.project_logistics_servlets.persistence.domain.Address;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCAddressDao implements AddressDao {
    private Connection connection;
    private AddressMapper addressMapper = new AddressMapper();
    private static final Logger LOGGER = LogManager.getLogger(JDBCAddressDao.class);

    public JDBCAddressDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Address entity) {

    }

    @Override
    public Address findById(int id) {
        return null;
    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public void update(Address entity) {

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
