package ua.train.project_logistics_servlets.service;

import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.dao.DaoFactory;
import ua.train.project_logistics_servlets.persistence.dao.UserDao;
import ua.train.project_logistics_servlets.persistence.domain.User;

import java.util.List;


public class UserService {
    private UserDao userDao = DaoFactory.getInstance().createUserDao();

    public List<User> getAllUsers()
            throws DataBaseFetchException {

        return userDao.findAll();
    }

    public User getUserFromDb(String email)
            throws DataBaseFetchException {

        return userDao.findUserByEmail(email)
                .orElseThrow(DataBaseFetchException::new);
    }

    public int getUserIdByEmail(String email)
            throws DataBaseFetchException {

        if (userDao.findUserByEmail(email).isPresent()) {
            return userDao.findUserByEmail(email).get().getId();

        } else {
            throw new DataBaseFetchException();
        }
    }
}
