package ua.train.project_logistics_servlets.web.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.exception.UserExistsException;
import ua.train.project_logistics_servlets.persistence.domain.User;
import ua.train.project_logistics_servlets.service.RegistrationService;
import ua.train.project_logistics_servlets.service.UserCreationService;

import javax.servlet.http.HttpServletRequest;

import static ua.train.project_logistics_servlets.constant.EntityFieldConstant.*;
import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class RegistrationCommand implements Command {
    private RegistrationService registrationService = new RegistrationService();
    UserCreationService userCreationService = new UserCreationService();

    private static final Logger LOGGER = LogManager.getLogger(RegistrationCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        String name = request.getParameter(NAME);
        String surname = request.getParameter(SURNAME);
        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);

        LOGGER.info("Parameter name: " + name);
        LOGGER.info("Parameter surname: " + surname);
        LOGGER.info("Parameter email: " + email);
        LOGGER.info("Parameter password: " + password);

        if (name == null || name.equals("") || surname == null || surname.equals("")) {
            return REGISTRATION_PAGE;
        }

        User user = userCreationService.constructUserFromRequest(request);

        try {
            registrationService.addUser(user);
        } catch (UserExistsException e) {
            return USER_EXISTS_ERROR_PAGE;
        } catch (DataBaseSaveException e) {
            return DB_SAVE_ERROR_PAGE;
        }catch (DataBaseFetchException e) {
            return DB_FETCH_ERROR_PAGE;
        }

        return REDIRECT + LOGIN_PATH;
    }
}
