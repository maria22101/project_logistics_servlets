package ua.train.project_logistics_servlets.controller;

import ua.train.project_logistics_servlets.controller.command.*;

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

    public void init(ServletConfig servletConfig){

        servletConfig.getServletContext()
                .setAttribute("loggedUsers", new HashSet<String>());

        commands.put("logout", new LogOutCommand());
        commands.put("login", new LoginCommand());
        commands.put("exception", new ExceptionCommand());
        commands.put("user/userMain.jsp", new UserMainCommand());
        commands.put("admin/adminMain.jsp", new AdminMainCommand());
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

        path = path.replaceAll(".*/delivery/" , "");
        System.out.println(path);

        Command command = commands.getOrDefault(path, (r)->"/index.jsp)");
        System.out.println(command.getClass().getName());

        String page = command.execute(request);

       if(page.contains("redirect:")){
            response.sendRedirect(page.replace("redirect:", "/delivery"));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
