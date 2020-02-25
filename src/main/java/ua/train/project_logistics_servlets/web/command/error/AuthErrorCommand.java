package ua.train.project_logistics_servlets.web.command.error;

import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;

import static ua.train.project_logistics_servlets.constant.WebConstant.AUTH_ERROR_PAGE;

public class AuthErrorCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return AUTH_ERROR_PAGE;
    }
}
