package ua.train.project_logistics_servlets.service;

import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.dao.DaoFactory;
import ua.train.project_logistics_servlets.persistence.dao.UserDao;
import ua.train.project_logistics_servlets.persistence.domain.User;

import java.util.List;


public class UserService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<User> getAllUsers() {
        try(UserDao dao = daoFactory.createUserDao()) {
            return dao.findAll();
        }
    }

    public User getUserFromDb (String email)
            throws DataBaseFetchException {

        User user;

        try(UserDao dao = daoFactory.createUserDao()) {
            user = dao.findUserByEmail(email)
                    .orElseThrow(DataBaseFetchException::new);
        }

        return user;
    }
}
