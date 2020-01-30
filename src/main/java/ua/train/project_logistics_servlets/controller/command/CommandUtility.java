package ua.train.project_logistics_servlets.controller.command;

import ua.train.project_logistics_servlets.model.entity.enums.Role;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

public class CommandUtility {

    static void setUserInSessionAndInContext(HttpServletRequest request,
                                             Role role, String username) {
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        session.setAttribute("role", role);
        session.setAttribute("name", username);
        setUserNameInContext(request, username);
    }

    static void setUserNameInContext(HttpServletRequest request, String username) {
        HashSet<String> loggedUsers = getLoggedUsers(request);
        loggedUsers.add(username);
        request.getServletContext().setAttribute("loggedUsers", loggedUsers);
    }

    static void discardUserFromSessionAndContext(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("role", Role.UNKNOWN);
        discardUserNameFromContext(request, session.getAttribute("name").toString());
    }

    static HashSet<String> getLoggedUsers(HttpServletRequest request) {
        return (HashSet<String>) request
                .getServletContext()
                .getAttribute("loggedUsers");
    }

    static boolean isUserLogged(HttpServletRequest request, String username){
        return getLoggedUsers(request).
                stream().anyMatch(username::equals);
    }

    static void discardUserNameFromContext(HttpServletRequest request, String username) {
        HashSet<String> loggedUsers = getLoggedUsers(request);
        loggedUsers.remove(username);
        request.getServletContext().setAttribute("loggedUsers", loggedUsers);
    }
}
