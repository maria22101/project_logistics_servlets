package ua.train.project_logistics_servlets.web.command;

import javax.servlet.http.HttpServletRequest;

import static ua.train.project_logistics_servlets.constant.WebConstants.AUTH_ERROR_PAGE;

public class AuthErrorCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return AUTH_ERROR_PAGE;
    }
}
