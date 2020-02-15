package ua.train.project_logistics_servlets.web.command;

import javax.servlet.http.HttpServletRequest;

import static ua.train.project_logistics_servlets.constant.WebConstants.REGISTRATION_PAGE;

public class RegistrationCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return REGISTRATION_PAGE;
    }
}
