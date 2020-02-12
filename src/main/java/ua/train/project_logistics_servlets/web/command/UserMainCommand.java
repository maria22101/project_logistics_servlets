package ua.train.project_logistics_servlets.web.command;

import javax.servlet.http.HttpServletRequest;

public class UserMainCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/user/userMain.jsp";
    }
}