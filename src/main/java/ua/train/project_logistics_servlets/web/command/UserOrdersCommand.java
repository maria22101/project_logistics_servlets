package ua.train.project_logistics_servlets.web.command;

import javax.servlet.http.HttpServletRequest;

public class UserOrdersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/user/userOrders.jsp";
    }
}