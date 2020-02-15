package ua.train.project_logistics_servlets.web.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class SessionListener implements HttpSessionListener {
    private static final Logger LOGGER = LogManager.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        LOGGER.info("New session created, session id=: " + session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();

        LOGGER.info("Session with id=: " + session.getId() + " destroyed");
        LOGGER.info("Session with id=: " + session.getId() + " role attribute: " + session.getAttribute(ROLE_ATTRIBUTE));
        LOGGER.info("Session with id=: " + session.getId() + " email attribute: " + session.getAttribute(EMAIL_ATTRIBUTE));
    }
}
