package ua.train.project_logistics_servlets.model.dao.mapper;

import ua.train.project_logistics_servlets.model.entity.User;
import ua.train.project_logistics_servlets.model.entity.enums.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements ObjectMapper<User> {
    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setRole(Role.valueOf(rs.getString("role")));

        return user;
    }

    //TODO - investigate/ refactor/ adjust approach, as User Id is Long
    @Override
    public User makeUnique(Map<Integer, User> cache, User user) {
//        cache.putIfAbsent(user.getId(), user);
//        return cache.get(student.getId());
        return null;
    }
}