package ua.train.project_logistics_servlets.web.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.persistence.domain.Route;
import ua.train.project_logistics_servlets.service.RouteService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.train.project_logistics_servlets.constant.WebConstants.MAIN_PAGE;

public class MainPageCommand implements Command{
    private RouteService routeService = new RouteService();
    private static final Logger LOGGER = LogManager.getLogger(MainPageCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        List<Route> allRoutes = routeService.getAllRoutes();
        request.setAttribute("routes", allRoutes);

        return MAIN_PAGE;
    }
}
