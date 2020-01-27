package ua.train.project_logistics_servlets.controller.command;

import ua.train.project_logistics_servlets.model.entity.User;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        System.out.println(name + " " + pass);

        if (name == null || name.equals("") || pass == null || pass.equals("")) {
            return "/login.jsp"; // not successful login
        }

        // TODO: go to Service and there check login with DB

        if (CommandUtility.checkUserIsLogged(request, name)) {
            return "/WEB-INF/error.jsp";
        } else if (name.equals("User")) { // role equals to USER???
            CommandUtility.setUserRole(request, User.Role.USER, name);
            return "/WEB-INF/user/userbasis.jsp";
        } else {
            CommandUtility.setUserRole(request, User.Role.UNKNOWN, name);
            return "/login.jsp";
        }
    }
}
