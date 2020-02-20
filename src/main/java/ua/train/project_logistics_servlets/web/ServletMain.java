package ua.train.project_logistics_servlets.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.web.command.*;
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

import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class ServletMain extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();
    private static final Logger LOGGER = LogManager.getLogger(ServletMain.class);

    public void init(ServletConfig servletConfig){

        servletConfig.getServletContext()
                .setAttribute(LOGGED_USERS_ATTRIBUTE, new HashSet<String>());

        commands.put(CONTEXT_PATH, new MainPageCommand());
        commands.put(LOGIN_PATH, new LoginCommand());
        commands.put(LOGOUT_PATH, new LogOutCommand());
        commands.put(REGISTRATION_PATH, new RegistrationCommand());
        commands.put(EXCEPTION_PATH, new ExceptionCommand());
        commands.put(USER_CABINET_PATH, new UserMainCommand());
        commands.put(USER_ORDERS_PATH, new UserOrdersCommand());
        commands.put(USER_INVOICED_ORDERS_PATH, new UserInvoicedOrdersCommand());
        commands.put(USER_PLACE_ORDER_PATH, new PlaceOrderCommand());
        commands.put(ADMIN_CABINET_PATH, new AdminMainCommand());
        commands.put(ADMIN_ORDERS_PATH, new AdminOrdersCommand());
        commands.put(ADMIN_OPEN_ORDERS_PATH, new AdminOpenOrdersCommand());
        commands.put(ADMIN_ISSUE_INVOICE_PATH, new AdminInvoiceCommand());
        commands.put(ADMIN_USERS_PATH, new AdminUsersCommand());
        commands.put(ADMIN_ROUTES_PATH, new AdminRoutesCommand());
        commands.put(DENIED_PATH, new DeniedCommand());
        commands.put(AUTH_ERROR_PATH, new AuthErrorCommand());
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
        path = path.replaceAll(SERVLET_MAIN_PATH, "");
        Command command = commands.getOrDefault(path, (r) -> CONTEXT_PATH);

        String page = command.execute(request);

       if(page.contains(REDIRECT)){
            response.sendRedirect(page.replace(REDIRECT, ""));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
