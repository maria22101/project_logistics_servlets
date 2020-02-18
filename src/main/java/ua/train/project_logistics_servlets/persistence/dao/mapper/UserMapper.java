package ua.train.project_logistics_servlets.persistence.dao.mapper;

import ua.train.project_logistics_servlets.persistence.domain.User;
import ua.train.project_logistics_servlets.enums.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

import static ua.train.project_logistics_servlets.constant.EntityFieldConstant.*;

public class UserMapper implements ObjectMapper<User> {
    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt(ID));
        user.setName(rs.getString(NAME));
        user.setSurname(rs.getString(SURNAME));
        user.setPassword(rs.getString(PASSWORD));
        user.setEmail(rs.getString(EMAIL));
        user.setRole(Role.valueOf(rs.getString(ROLE)));

        return user;
    }
}
