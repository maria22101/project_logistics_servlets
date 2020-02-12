package ua.train.project_logistics_servlets.web.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.enums.Role;
import ua.train.project_logistics_servlets.service.SimpleUserService;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger(LoginCommand.class);
    private SimpleUserService simpleUserService = new SimpleUserService();

    @Override
    public String execute(HttpServletRequest request) {

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        if (name == null || name.equals("") || pass == null || pass.equals("")) {
            return "/login.jsp";
        }

        if (simpleUserService.userExists(name, pass) &&
                simpleUserService.getRoleByLoginAndPassword(name, pass).equals(Role.USER)) {

            CommandUtility.setUserInSessionAndInContext(request, Role.USER, name);
            logger.info("User " + name + " logged successfully. Servlet_Context: "
                    + request.getServletContext().getAttribute("loggedUsers") + ", Session_Role "
                    + request.getSession().getAttribute("role"));
            return "redirect:user/user_main";

        } else if (simpleUserService.userExists(name, pass) &&
                simpleUserService.getRoleByLoginAndPassword(name, pass).equals(Role.ADMIN)) {

            CommandUtility.setUserInSessionAndInContext(request, Role.ADMIN, name);
            logger.info("Admin " + name + " logged successfully. Servlet_Context: "
                    + request.getServletContext().getAttribute("loggedUsers") + ", Session_Role "
                    + request.getSession().getAttribute("role"));
            return "redirect:admin/admin_main";

        } else {

//            CommandUtility.setUserInSessionAndInContext(request, Role.UNKNOWN, name);
            logger.info("Guest " + name + " is not recognized");
            return "/login.jsp";
        }
    }

}