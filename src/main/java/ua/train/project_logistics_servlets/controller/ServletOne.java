package ua.train.project_logistics_servlets.controller;

import ua.train.project_logistics_servlets.controller.command.*;
import ua.train.project_logistics_servlets.model.service.RouteService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ServletOne extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();
    private RouteService routeService = new RouteService();

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
        commands.put("admin/users", new AdminUsersCommand(routeService));
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
        System.out.println(path);

        path = path.replaceAll(".*/app/", "");
        System.out.println(path);

        Command command = commands.getOrDefault(path, (r)->"/index.jsp)");
        System.out.println(command.getClass().getName());

        String page = command.execute(request);

       if(page.contains("redirect:")){
            response.sendRedirect(page.replace("redirect:", ""));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
