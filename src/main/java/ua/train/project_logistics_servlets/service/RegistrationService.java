package ua.train.project_logistics_servlets.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.exception.UserExistsException;
import ua.train.project_logistics_servlets.persistence.dao.DaoFactory;
import ua.train.project_logistics_servlets.persistence.dao.UserDao;
import ua.train.project_logistics_servlets.persistence.domain.User;

public class RegistrationService {
    private static final Logger LOGGER = LogManager.getLogger(RegistrationService.class);

    DaoFactory daoFactory = DaoFactory.getInstance();

    public void addUser(User user)
            throws UserExistsException,
                    DataBaseFetchException,
                    DataBaseSaveException {

        try(UserDao dao = daoFactory.createUserDao()) {
            checkIfEmailPresent(user);
            dao.addUser(user);
        }
    }

    private void checkIfEmailPresent (User user)
            throws DataBaseFetchException,
                    UserExistsException {

        try(UserDao dao = daoFactory.createUserDao()) {
            if(dao.findUserByEmail(user.getEmail()).isPresent()) {
                throw new UserExistsException();
            }
        }
    }
}
