package ua.train.project_logistics_servlets.persistence.dao;

import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.exception.UserExistsException;
import ua.train.project_logistics_servlets.persistence.domain.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User> {
    Optional<User> findUserByEmail(String email)
            throws DataBaseFetchException;

    void addUser(User user)
            throws UserExistsException,
            DataBaseSaveException;
}
