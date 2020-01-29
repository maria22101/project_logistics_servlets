package ua.train.project_logistics_servlets.controller.command;

import ua.train.project_logistics_servlets.model.entity.User;
import ua.train.project_logistics_servlets.model.entity.enums.Role;
import ua.train.project_logistics_servlets.model.service.SimpleUserService;
import ua.train.project_logistics_servlets.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    private SimpleUserService simpleUserService = new SimpleUserService();

    @Override
    public String execute(HttpServletRequest request) {

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        if (name == null || name.equals("") || pass == null || pass.equals("")) {
            //System.out.println("Not");
            return "/login.jsp";
        }

        if (simpleUserService.userExists(name, pass) &&
                simpleUserService.getRoleByLoginAndPassword(name, pass).equals(Role.USER)) {

            CommandUtility.setUserInSessionAndInContext(request, Role.USER, name);
            return "redirect:/user/userMain.jsp";

        } else if (simpleUserService.userExists(name, pass) &&
                simpleUserService.getRoleByLoginAndPassword(name, pass).equals(Role.ADMIN)) {

            CommandUtility.setUserInSessionAndInContext(request, Role.ADMIN, name);
            return "redirect:/admin/adminMain.jsp";

        } else {

            CommandUtility.setUserInSessionAndInContext(request, Role.UNKNOWN, name);
            return "/login.jsp";
        }
    }

}
