package ua.train.project_logistics_servlets.web.command.admin;

import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;

import static ua.train.project_logistics_servlets.constant.WebConstants.ADMIN_CABINET_PAGE;

public class AdminMainCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return ADMIN_CABINET_PAGE;
    }
}
