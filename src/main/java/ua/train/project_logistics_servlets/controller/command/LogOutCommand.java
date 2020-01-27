package ua.train.project_logistics_servlets.controller.command;

import ua.train.project_logistics_servlets.model.entity.User;

import javax.servlet.http.HttpServletRequest;

public class LogOutCommand implements Command{

    @Override
    public String execute(HttpServletRequest request) {

        // ToDo delete current user (context & session)
        CommandUtility.setUserRole(request, User.Role.UNKNOWN, "Guest");
        return "redirect:/index.jsp";
    }
}
