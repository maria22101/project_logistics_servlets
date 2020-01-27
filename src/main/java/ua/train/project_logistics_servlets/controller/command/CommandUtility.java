package ua.train.project_logistics_servlets.controller.command;

import ua.train.project_logistics_servlets.model.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

public class CommandUtility {

    static void setUserRole(HttpServletRequest request,
                            User.Role role,
                            String name) {
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        context.setAttribute("userName", name);
        session.setAttribute("role", role);
    }

    // something wrong with the code?
    static boolean checkUserIsLogged(HttpServletRequest request,
                                     String userName) {
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers"); // String instead of Set?

        if(loggedUsers.stream().anyMatch(userName::equals)){
            return true;
        }

        loggedUsers.add(userName);

        request.getSession().getServletContext()
                .setAttribute("loggedUsers", loggedUsers);
        return false;
    }

}
