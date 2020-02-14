package ua.train.project_logistics_servlets.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.persistence.dao.UserDao;
import ua.train.project_logistics_servlets.persistence.dao.mapper.RouteMapper;
import ua.train.project_logistics_servlets.persistence.dao.mapper.UserMapper;
import ua.train.project_logistics_servlets.persistence.domain.Route;
import ua.train.project_logistics_servlets.persistence.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JDBCUserDao implements UserDao {
    private Connection connection;
    private UserMapper userMapper = new UserMapper();
    private static final Logger LOGGER = LogManager.getLogger(JDBCUserDao.class);

    private static final String GET_USER_BY_EMAIL = "SELECT * FROM users WHERE email=?";

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User entity) {

    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        Optional<User> user = Optional.empty();

        LOGGER.info("inside findUserByEmail");

        try (PreparedStatement prepStatement = connection.prepareStatement(GET_USER_BY_EMAIL)) {
            prepStatement.setString(1, email);
            ResultSet rs = prepStatement.executeQuery();

            if (rs.next()){
                user = Optional.of(userMapper.extractFromResultSet(rs));
            }
            LOGGER.info("ResultSet for user processed: " + user.toString());

        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return user;
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
