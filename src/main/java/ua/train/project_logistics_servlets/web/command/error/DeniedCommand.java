package ua.train.project_logistics_servlets.web.command.error;

import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;

import static ua.train.project_logistics_servlets.constant.WebConstant.ACCESS_DENIED_PAGE;

public class DeniedCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return ACCESS_DENIED_PAGE;
    }
}
