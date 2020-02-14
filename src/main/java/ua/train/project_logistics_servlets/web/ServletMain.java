package ua.train.project_logistics_servlets.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.web.command.*;
import ua.train.project_logistics_servlets.service.RouteService;
import ua.train.project_logistics_servlets.web.command.admin.*;
import ua.train.project_logistics_servlets.web.command.user.PlaceOrderCommand;
import ua.train.project_logistics_servlets.web.command.user.UserInvoicedOrdersCommand;
import ua.train.project_logistics_servlets.web.command.user.UserMainCommand;
import ua.train.project_logistics_servlets.web.command.user.UserOrdersCommand;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ServletMain extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();
    private RouteService routeService = new RouteService();
    private static final Logger LOGGER = LogManager.getLogger(ServletMain.class);

    public void init(ServletConfig servletConfig){

        servletConfig.getServletContext()
                .setAttribute("loggedUsers", new HashSet<String>());

        commands.put("login", new LoginCommand());
        commands.put("logout", new LogOutCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("exception", new ExceptionCommand());
        commands.put("user/user_main", new UserMainCommand());
        commands.put("user/orders", new UserOrdersCommand());
        commands.put("user/invoiced_orders", new UserInvoicedOrdersCommand());
        commands.put("user/place_order", new PlaceOrderCommand());
        commands.put("admin/admin_main", new AdminMainCommand());
        commands.put("admin/orders", new AdminOrdersCommand());
        commands.put("admin/open_orders", new AdminOpenOrdersCommand());
        commands.put("admin/users", new AdminUsersCommand());
        commands.put("admin/routes", new AdminRoutesCommand());
        commands.put("denied", new DeniedCommand());
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        LOGGER.info("Inside MainServlet. Path: " + path);

        path = path.replaceAll(".*/app/", "");
        System.out.println(path);

        Command command = commands.getOrDefault(path, (r)->"/index.jsp");
        LOGGER.info("Command captured : " + command.getClass().getName());

        String page = command.execute(request);

       if(page.contains("redirect:")){
            response.sendRedirect(page.replace("redirect:", ""));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
