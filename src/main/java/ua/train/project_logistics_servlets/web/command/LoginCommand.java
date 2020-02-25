package ua.train.project_logistics_servlets.web.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.enums.Role;
import ua.train.project_logistics_servlets.exception.UserNotFoundException;
import ua.train.project_logistics_servlets.service.LoginService;

import javax.servlet.http.HttpServletRequest;

import static ua.train.project_logistics_servlets.constant.EntityFieldConstant.*;
import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class LoginCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(LoginCommand.class);
    private LoginService loginService = new LoginService();

    @Override
    public String execute(HttpServletRequest request) {

        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);
        if (email == null || email.equals("") || password == null || password.equals("")) {
            return LOGIN_PAGE;
        }

        try {
            if (!loginService.isUserAuthorized(email, password)) {
                return REDIRECT + AUTH_ERROR_PATH;

            } else {
                if (loginService.getRoleByEmail(email).equals(Role.USER)) {
                    CommandUtility.setUserInSession(request, Role.USER, email);
                    CommandUtility.setUserInContext(request, email);
                    return REDIRECT + USER_CABINET_PATH;

                } else if (loginService.getRoleByEmail(email).equals(Role.ADMIN)) {
                    CommandUtility.setUserInSession(request, Role.ADMIN, email);
                    CommandUtility.setUserInContext(request, email);
                    return REDIRECT + ADMIN_CABINET_PATH;

                } else {
                    return ACCESS_DENIED_PAGE;
                }
            }
        } catch (UserNotFoundException e) {
            return AUTH_ERROR_PAGE;
        }
    }
}
