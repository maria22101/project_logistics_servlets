package ua.train.project_logistics_servlets.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.persistence.domain.Route;
import ua.train.project_logistics_servlets.service.RouteService;
import ua.train.project_logistics_servlets.web.command.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ServletWelcome extends HttpServlet {
    private RouteService routeService = new RouteService();
    private static final Logger LOGGER = LogManager.getLogger(ServletWelcome.class);

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        LOGGER.info("Inside WelcomeServlet");

        List<Route> allRoutes = routeService.getAllRoutes();
        request.setAttribute("routes", allRoutes);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
