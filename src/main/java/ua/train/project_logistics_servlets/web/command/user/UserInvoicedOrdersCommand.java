package ua.train.project_logistics_servlets.web.command.user;

import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;

import static ua.train.project_logistics_servlets.constant.WebConstant.USER_INVOICED_ORDERS_PAGE;

public class UserInvoicedOrdersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return USER_INVOICED_ORDERS_PAGE;
    }
}
