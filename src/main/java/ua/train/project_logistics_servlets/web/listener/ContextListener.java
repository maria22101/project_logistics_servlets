package ua.train.project_logistics_servlets.web.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.enums.Role;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;

import static ua.train.project_logistics_servlets.constant.WebConstants.*;

public class ContextListener implements ServletContextListener {
    private static final Logger LOGGER = LogManager.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOGGER.info("Inside ContextListener, contextInitialized()...");

        Properties properties = new Properties();
        try {
            InputStream inStream = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("business_input.properties");
            properties.load(inStream);
            if (inStream != null) {
                inStream.close();
            }
        } catch (IOException ex) {
            LOGGER.info("properties file loading failed");
            ex.printStackTrace();
        }
        sce.getServletContext().setAttribute("properties", properties);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        HashSet<String> loggedUsers = (HashSet<String>) context.getAttribute(LOGGED_USERS_ATTRIBUTE);
        LOGGER.info("Context destroyed. LoggedUsers: " + loggedUsers);
    }
}
