package ua.train.project_logistics_servlets.web.command.admin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.domain.Order;
import ua.train.project_logistics_servlets.persistence.domain.Route;
import ua.train.project_logistics_servlets.service.InvoiceService;
import ua.train.project_logistics_servlets.service.RouteService;
import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class AdminRoutesCommand implements Command {
    RouteService routeService = new RouteService();

    @Override
    public String execute(HttpServletRequest request) {

        try {
            List<Route> routes = routeService.getAllRoutes();
            request.setAttribute(ROUTES_ATTRIBUTE, routes);
        } catch (DataBaseFetchException e) {
            return DB_FETCH_ERROR_PAGE;
        }

        return ADMIN_ROUTES_PAGE;
    }
}
