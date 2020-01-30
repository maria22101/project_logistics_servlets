package ua.train.project_logistics_servlets.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.model.entity.User;
import ua.train.project_logistics_servlets.model.entity.enums.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogOutCommand implements Command{
    private static final Logger logger = LogManager.getLogger(LogOutCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        // ToDo - check deleting current user (context & session)
        CommandUtility.discardUserFromSessionAndContext(request);

        logger.info("User logged out. Servlet_Context: "
                + request.getServletContext().getAttribute("loggedUsers") + "Session_Role "
                + request.getSession().getAttribute("role"));

        return "redirect:/";
    }
}
