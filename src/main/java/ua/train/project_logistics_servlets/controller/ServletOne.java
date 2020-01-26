package ua.train.project_logistics_servlets.controller;

import ua.train.project_logistics_servlets.controller.command.Command;
import ua.train.project_logistics_servlets.controller.command.Exception;
import ua.train.project_logistics_servlets.controller.command.LogOut;
import ua.train.project_logistics_servlets.controller.command.Login;
import ua.train.project_logistics_servlets.controller.command.Registration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ServletOne extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    public void init(){
        commands.put("exception" , new Exception());
        commands.put("login", new Login());
        commands.put("logout", new LogOut());
        commands.put("registration", new Registration());
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
        path = path.replaceAll(".*/app/" , "");
        System.out.println(path);
        Command command = commands.getOrDefault(path, (r)->"/index.jsp)");
        String page = command.execute(request);
        if(page.contains("redirect:")){
            response.sendRedirect(page.replace("redirect:", "/api"));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
