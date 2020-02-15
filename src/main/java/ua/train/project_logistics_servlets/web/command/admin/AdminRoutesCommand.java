package ua.train.project_logistics_servlets.web.command.admin;

import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;

import static ua.train.project_logistics_servlets.constant.WebConstant.ADMIN_ROUTES_PAGE;

public class AdminRoutesCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return ADMIN_ROUTES_PAGE;
    }
}
