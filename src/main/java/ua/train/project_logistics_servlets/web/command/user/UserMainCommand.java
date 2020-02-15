package ua.train.project_logistics_servlets.web.command.user;

import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;

import static ua.train.project_logistics_servlets.constant.WebConstants.USER_CABINET_PAGE;

public class UserMainCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return USER_CABINET_PAGE;
    }
}