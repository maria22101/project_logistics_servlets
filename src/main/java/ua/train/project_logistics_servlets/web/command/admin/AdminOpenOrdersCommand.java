package ua.train.project_logistics_servlets.web.command.admin;

import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;

public class AdminOpenOrdersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/admin/adminOpenOrders.jsp";
    }
}
