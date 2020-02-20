package ua.train.project_logistics_servlets.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.exception.UserExistsException;
import ua.train.project_logistics_servlets.persistence.dao.UserDao;
import ua.train.project_logistics_servlets.persistence.dao.mapper.RouteMapper;
import ua.train.project_logistics_servlets.persistence.dao.mapper.UserMapper;
import ua.train.project_logistics_servlets.persistence.domain.Route;
import ua.train.project_logistics_servlets.persistence.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCUserDao implements UserDao {
    private UserMapper userMapper = new UserMapper();
    private static final Logger LOGGER = LogManager.getLogger(JDBCUserDao.class);

    private static final String GET_USER_BY_EMAIL = "SELECT * FROM users WHERE email=?";

    private static final String ADD_NEW_USER = "INSERT INTO users " +
            "(email, name, password, role, surname)" + " VALUES(?, ?, ?, ?, ?)";

    private static final String GET_ALL_USERS = "SELECT * FROM users";

    @Override
    public void create(User entity) {

    }

    @Override
    public Optional<User> findById(int id) throws DataBaseFetchException {
        return Optional.empty();
    }

    @Override
    public List<User> findAll()
            throws DataBaseFetchException {

        List<User> usersList = new ArrayList<>();
        try (Connection connection = ConnectionPoolHolder.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(GET_ALL_USERS);

            while (rs.next()) {
                User result = userMapper.extractFromResultSet(rs);
                usersList.add(result);
            }

        } catch (SQLException e) {
            throw new DataBaseFetchException();
        }
        return usersList;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void addUser(User user)
            throws DataBaseSaveException {

        try (Connection connection = ConnectionPoolHolder.getConnection();
                PreparedStatement prepStatement = connection.prepareStatement(ADD_NEW_USER)) {

            prepStatement.setString(1, user.getEmail());
            prepStatement.setString(2, user.getName());
            prepStatement.setString(3, user.getPassword());
            prepStatement.setString(4, user.getRole().toString());
            prepStatement.setString(5, user.getSurname());
            prepStatement.execute();

        }catch (Exception e) {
            throw new DataBaseSaveException();
        }
    }

    @Override
    public Optional<User> findUserByEmail(String email)
            throws DataBaseFetchException {

        Optional<User> user = Optional.empty();
        try (Connection connection = ConnectionPoolHolder.getConnection();
                PreparedStatement prepStatement = connection.prepareStatement(GET_USER_BY_EMAIL)) {

            prepStatement.setString(1, email);
            ResultSet rs = prepStatement.executeQuery();
            if (rs.next()){
                user = Optional.of(userMapper.extractFromResultSet(rs));
            }

        }catch (Exception e) {
            throw new DataBaseFetchException();
        }
        return user;
    }
}
