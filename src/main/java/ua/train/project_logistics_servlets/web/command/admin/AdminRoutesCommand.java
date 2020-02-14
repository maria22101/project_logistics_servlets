package ua.train.project_logistics_servlets.web.command.admin;

import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;

public class AdminRoutesCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/admin/adminRoutes.jsp";
    }
}