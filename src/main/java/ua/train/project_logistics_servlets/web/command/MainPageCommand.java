package ua.train.project_logistics_servlets.web.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.domain.Route;
import ua.train.project_logistics_servlets.service.RouteService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class MainPageCommand implements Command{
    private RouteService routeService = new RouteService();
    private static final Logger LOGGER = LogManager.getLogger(MainPageCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        try {
            List<Route> allRoutes = routeService.getAllRoutes();
            request.setAttribute(ROUTES_ATTRIBUTE, allRoutes);

            if (request.getSession().getAttribute(LANGUAGE_ATTRIBUTE) == null ||
                    request.getSession().getAttribute(LANGUAGE_ATTRIBUTE).equals(EN_LANGUAGE)) {

                List<String> allCitiesEn = routeService.getCitiesOptionsEng();
                request.setAttribute(CITIES_OPTION_ATTRIBUTE, allCitiesEn);

            } else {

                List<String> allCitiesUa = routeService.getCitiesOptionsUa();
                request.setAttribute(CITIES_OPTION_ATTRIBUTE, allCitiesUa);
            }

        } catch (DataBaseFetchException e) {
            e.printStackTrace();
        }

        return MAIN_PAGE;
    }
}
