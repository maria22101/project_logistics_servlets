package ua.train.project_logistics_servlets.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import ua.train.project_logistics_servlets.enums.Role;
import ua.train.project_logistics_servlets.persistence.domain.User;

import javax.servlet.http.HttpServletRequest;

import static ua.train.project_logistics_servlets.constant.EntityFieldConstant.*;

public class UserCreationService {
    private static final Logger LOGGER = LogManager.getLogger(UserCreationService.class);

    public User constructUserFromRequest(HttpServletRequest request) {
        String name = request.getParameter(NAME);
        String surname = request.getParameter(SURNAME);
        String password = request.getParameter(PASSWORD);
        String email = request.getParameter(EMAIL);

        String encodedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setPassword(encodedPassword);
        user.setEmail(email);
        user.setRole(Role.USER);
        LOGGER.info("User constructed = {}", user);

        return user;
    }
}
