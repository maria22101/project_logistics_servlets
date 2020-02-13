package ua.train.project_logistics_servlets.web.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.enums.Role;
import ua.train.project_logistics_servlets.exception.UserNotFoundException;
import ua.train.project_logistics_servlets.service.LoginService;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(LoginCommand.class);
    private LoginService loginService = new LoginService();

    @Override
    public String execute(HttpServletRequest request) {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || email.equals("") || password == null || password.equals("")) {
            return "/login.jsp";
        }

        try {


            if (loginService.isUserAuthorized(email, password) &&
                    loginService.getRoleByEmail(email).equals(Role.USER)) {

                CommandUtility.setUserInSessionAndInContext(request, Role.USER, email);
                LOGGER.info("User " + email + " logged successfully. Servlet_Context: "
                        + request.getServletContext().getAttribute("loggedUsers") + ", Session_Role "
                        + request.getSession().getAttribute("role"));
                return "redirect:user/user_main";

            } else if (loginService.isUserAuthorized(email, password) &&
                    loginService.getRoleByEmail(email).equals(Role.ADMIN)) {

                CommandUtility.setUserInSessionAndInContext(request, Role.ADMIN, email);
                LOGGER.info("Admin " + email + " logged successfully. Servlet_Context: "
                        + request.getServletContext().getAttribute("loggedUsers") + ", Session_Role "
                        + request.getSession().getAttribute("role"));
                return "redirect:admin/admin_main";

            } else {

//            CommandUtility.setUserInSessionAndInContext(request, Role.UNKNOWN, email);
                LOGGER.info("Guest " + email + " is not recognized");
                return "/login.jsp";
            }
        } catch (UserNotFoundException e) {
            return "/error.jsp";
        }
    }
}
