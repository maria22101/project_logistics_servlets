package ua.train.project_logistics_servlets.web.command;

import ua.train.project_logistics_servlets.enums.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

import static ua.train.project_logistics_servlets.constant.WebConstants.*;

public class CommandUtility {

    static void setUserInSession(HttpServletRequest request,
                                 Role role, String email) {
        HttpSession session = request.getSession();
        session.setAttribute(ROLE_ATTRIBUTE, role);
        session.setAttribute(EMAIL_ATTRIBUTE, email);
    }

    static void setUserInContext(HttpServletRequest request,
                                 String email) {
        HashSet<String> loggedUsers = getLoggedUsers(request);
        loggedUsers.add(email);
        request.getServletContext().setAttribute(LOGGED_USERS_ATTRIBUTE, loggedUsers);
    }

    static void discardUserFromSessionAndContext(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = session.getAttribute(EMAIL).toString();

        HashSet<String> loggedUsers = getLoggedUsers(request);
        loggedUsers.remove(email);
        request.getServletContext().setAttribute(LOGGED_USERS_ATTRIBUTE, loggedUsers);

        session.removeAttribute(ROLE_ATTRIBUTE);
        session.removeAttribute(EMAIL_ATTRIBUTE);
    }

    static HashSet<String> getLoggedUsers(HttpServletRequest request) {
        return (HashSet<String>) request
                .getServletContext()
                .getAttribute(LOGGED_USERS_ATTRIBUTE);
    }
}
