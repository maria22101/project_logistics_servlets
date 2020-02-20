package ua.train.project_logistics_servlets.web.command.admin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.domain.User;
import ua.train.project_logistics_servlets.service.UserService;
import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class AdminUsersCommand implements Command {
    private UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request) {
        try {
            List<User> routes = userService.getAllUsers();
            request.setAttribute(USERS_ATTRIBUTE, routes);
        } catch (DataBaseFetchException e) {
            return DB_FETCH_ERROR_PAGE;
        }

        return ADMIN_USERS_PAGE;
    }
}
