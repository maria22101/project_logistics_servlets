package ua.train.project_logistics_servlets.web.command.user;

import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;

public class UserInvoicedOrdersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/user/userInvoicedOrders.jsp";
    }
}
