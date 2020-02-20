package ua.train.project_logistics_servlets.service.registration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.exception.UserExistsException;
import ua.train.project_logistics_servlets.persistence.dao.DaoFactory;
import ua.train.project_logistics_servlets.persistence.dao.UserDao;
import ua.train.project_logistics_servlets.persistence.domain.User;

public class RegistrationService {
    UserDao userDao = DaoFactory.getInstance().createUserDao();

    private static final Logger LOGGER = LogManager.getLogger(RegistrationService.class);

    public void addUser(User user)
            throws UserExistsException,
            DataBaseFetchException,
            DataBaseSaveException {

        checkIfEmailPresent(user);
        userDao.addUser(user);
    }

    private void checkIfEmailPresent(User user)
            throws DataBaseFetchException,
            UserExistsException {

        if (userDao.findUserByEmail(user.getEmail()).isPresent()) {
            throw new UserExistsException();
        }
    }
}
