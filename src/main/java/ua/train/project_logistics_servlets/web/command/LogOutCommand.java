package ua.train.project_logistics_servlets.web.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class LogOutCommand implements Command{
    private static final Logger logger = LogManager.getLogger(LogOutCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        CommandUtility.discardUserFromSessionAndContext(request);

        logger.info("User logged out. Servlet_Context: "
                + request.getServletContext().getAttribute("loggedUsers") + ", Session_Role "
                + request.getSession().getAttribute("role"));

        return "redirect:/";
    }
}
