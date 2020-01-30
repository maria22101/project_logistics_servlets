package ua.train.project_logistics_servlets.controller.command;

import ua.train.project_logistics_servlets.model.entity.User;
import ua.train.project_logistics_servlets.model.entity.enums.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogOutCommand implements Command{

    @Override
    public String execute(HttpServletRequest request) {

        // ToDo delete current user (context & session)
        CommandUtility.discardUserFromSessionAndContext(request);

        return "redirect:/index.jsp";
    }
}
