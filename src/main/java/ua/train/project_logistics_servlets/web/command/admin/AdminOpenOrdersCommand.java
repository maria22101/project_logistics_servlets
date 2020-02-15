package ua.train.project_logistics_servlets.web.command.admin;

import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;

import static ua.train.project_logistics_servlets.constant.WebConstants.ADMIN_OPEN_ORDERS_PAGE;

public class AdminOpenOrdersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return ADMIN_OPEN_ORDERS_PAGE;
    }
}
