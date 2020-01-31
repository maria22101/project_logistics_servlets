package ua.train.project_logistics_servlets.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.model.entity.Route;
import ua.train.project_logistics_servlets.model.service.RouteService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AdminUsersCommand implements Command {
    private static final Logger logger = LogManager.getLogger(AdminUsersCommand.class);

    private RouteService routeService;

    public AdminUsersCommand(RouteService routeService) {
        this.routeService = routeService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        logger.info("Aproaching the database");
        List<Route> routes = routeService.getAllRoutes();
        logger.info("Routes retreived");

        request.setAttribute("routes", routes);
        logger.info("Routes set up for view");

        return "/WEB-INF/admin/adminUsers.jsp";
    }
}
