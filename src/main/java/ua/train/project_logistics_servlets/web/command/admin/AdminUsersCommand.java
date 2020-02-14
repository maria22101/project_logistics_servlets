package ua.train.project_logistics_servlets.web.command.admin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;

public class AdminUsersCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(AdminUsersCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        return "/WEB-INF/admin/adminUsers.jsp";
    }
}
