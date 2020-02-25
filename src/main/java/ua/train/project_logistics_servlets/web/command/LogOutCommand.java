package ua.train.project_logistics_servlets.web.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class LogOutCommand implements Command{
    private static final Logger LOGGER = LogManager.getLogger(LogOutCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        CommandUtility.discardUserFromSessionAndContext(request);
        return REDIRECT + CONTEXT_PATH;
    }
}
