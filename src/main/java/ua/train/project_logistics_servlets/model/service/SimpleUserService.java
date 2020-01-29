package ua.train.project_logistics_servlets.model.service;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

import ua.train.project_logistics_servlets.model.entity.User;
import ua.train.project_logistics_servlets.model.entity.enums.Role;

public class SimpleUserService {
    private List<User> users = Arrays.asList(
            new User("ivan", "rio", Role.USER),
            new User("rosa", "tigra", Role.USER),
            new User("mari", "pass", Role.ADMIN)
    );

    public boolean userExists(String login, String password) {
        return users.stream()
                .anyMatch(u -> u.getUsername().equals(login) && u.getPassword().equals(password));
    }

    public Role getRoleByLoginAndPassword(String login, String password) {
        return users.stream()
                .filter(u -> u.getUsername().equals(login) && u.getPassword().equals(password))
                .findFirst()
                .get()
                .getRole();
    }
}
