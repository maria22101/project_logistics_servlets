package ua.train.project_logistics_servlets.web.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ContextListener implements ServletContextListener {
    private static final String PROPERTIES_FILE="business_input.properties";
    private static final String APPLICATION_SCOPE_PROPERTIES="properties";

    private static final Logger LOGGER = LogManager.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Properties properties = new Properties();
        try {
            InputStream inStream = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream(PROPERTIES_FILE);
            properties.load(inStream);
            if (inStream != null) {
                inStream.close();
            }
        } catch (IOException ex) {
            LOGGER.info("properties loading exception");
        }
        sce.getServletContext().setAttribute(APPLICATION_SCOPE_PROPERTIES, properties);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
