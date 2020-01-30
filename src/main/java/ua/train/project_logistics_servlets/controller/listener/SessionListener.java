package ua.train.project_logistics_servlets.controller.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;

public class SessionListener implements HttpSessionListener {
    private static final Logger logger = LogManager.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        logger.info("New session created, session id=: " + session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

//        HashSet<String> loggedUsers = (HashSet<String>) httpSessionEvent
//                .getSession().getServletContext()
//                .getAttribute("loggedUsers");
//
//        String userName = (String) httpSessionEvent.getSession()
//                .getAttribute("userName"); // ???
//
//        loggedUsers.remove(userName);
//
//        httpSessionEvent.getSession().setAttribute("loggedUsers", loggedUsers);

        HttpSession session = httpSessionEvent.getSession();
        logger.info("Session with seession id=: " + session.getId() + " destroyed");

    }
}
