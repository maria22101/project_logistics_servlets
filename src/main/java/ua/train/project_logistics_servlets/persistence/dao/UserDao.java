package ua.train.project_logistics_servlets.persistence.dao;

import ua.train.project_logistics_servlets.persistence.domain.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User> {
    Optional<User> findUserByEmail(String email);
}
