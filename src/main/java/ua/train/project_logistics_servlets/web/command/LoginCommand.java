package ua.train.project_logistics_servlets.web.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.enums.Role;
import ua.train.project_logistics_servlets.exception.UserNotFoundException;
import ua.train.project_logistics_servlets.service.LoginService;

import javax.servlet.http.HttpServletRequest;

import static ua.train.project_logistics_servlets.constant.WebConstants.*;

public class LoginCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(LoginCommand.class);
    private LoginService loginService = new LoginService();

    @Override
    public String execute(HttpServletRequest request) {

        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);

        LOGGER.info("Checking if user is logged...");
        LOGGER.info("Parameter email: " + email);

        if (email == null || email.equals("") || password == null || password.equals("")) {
            return LOGIN_PAGE;
        }

        try {

            if (!loginService.isUserAuthorized(email, password)) {
                LOGGER.info("Guest " + email + " is not recognized");

                return REDIRECT + AUTH_ERROR_PATH;

            } else {

                if (loginService.getRoleByEmail(email).equals(Role.USER)) {

                    CommandUtility.setUserInSession(request, Role.USER, email);
                    CommandUtility.setUserInContext(request, email);

                    LOGGER.info("User " + email + " logged successfully.");
                    LOGGER.info("Servlet_Context: " + request.getServletContext().getAttribute(LOGGED_USERS_ATTRIBUTE));
                    LOGGER.info("Role in Session: " + request.getSession().getAttribute(ROLE_ATTRIBUTE));
                    LOGGER.info("Email in Session: " + request.getSession().getAttribute(EMAIL_ATTRIBUTE));
                    LOGGER.info("Redirecting: " + REDIRECT + USER_CABINET_PATH);
                    LOGGER.info("Redirecting path: " + USER_CABINET_PATH);

                    return REDIRECT + USER_CABINET_PATH;

                } else if (loginService.getRoleByEmail(email).equals(Role.ADMIN)) {

                    CommandUtility.setUserInSession(request, Role.ADMIN, email);
                    CommandUtility.setUserInContext(request, email);

                    LOGGER.info("Admin " + email + " logged successfully.");
                    LOGGER.info("Servlet_Context: " + request.getServletContext().getAttribute(LOGGED_USERS_ATTRIBUTE));
                    LOGGER.info("Role in Session: " + request.getSession().getAttribute(ROLE_ATTRIBUTE));
                    LOGGER.info("Email in Session: " + request.getSession().getAttribute(EMAIL_ATTRIBUTE));

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
