package ua.train.project_logistics_servlets.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import ua.train.project_logistics_servlets.enums.Role;
import ua.train.project_logistics_servlets.exception.UserNotFoundException;
import ua.train.project_logistics_servlets.persistence.dao.DaoFactory;
import ua.train.project_logistics_servlets.persistence.dao.UserDao;
import ua.train.project_logistics_servlets.persistence.domain.User;

import java.util.Optional;

public class LoginService {
    private static final Logger LOGGER = LogManager.getLogger(LoginService.class);
    private UserDao userDao = DaoFactory.getInstance().createUserDao();

    public boolean isUserAuthorized (String email, String password)
            throws UserNotFoundException{

        boolean isAuthorized;

        if (findUserByEmail(email).isPresent()) {
            isAuthorized = BCrypt.checkpw(
                    password,
                    findUserByEmail(email).get().getPassword());
        }else {
            throw new UserNotFoundException();
        }

        return isAuthorized;
    }

    public Role getRoleByEmail(String email) throws UserNotFoundException {
        User user = findUserByEmail(email).orElseThrow(UserNotFoundException::new);

        return user.getRole();
    }

    private Optional<User> findUserByEmail (String email) {

        Optional<User> user = Optional.empty();
        try  {
            user = userDao.findUserByEmail(email);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
