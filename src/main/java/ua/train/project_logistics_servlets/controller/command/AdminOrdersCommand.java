package ua.train.project_logistics_servlets.controller.command;

import javax.servlet.http.HttpServletRequest;

public class AdminOrdersCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/admin/adminOrders.jsp";
    }
}
