package ua.train.project_logistics_servlets.web.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.exception.UserExistsException;
import ua.train.project_logistics_servlets.persistence.domain.User;
import ua.train.project_logistics_servlets.service.registration.RegistrationService;
import ua.train.project_logistics_servlets.service.registration.RegFormValidationService;
import ua.train.project_logistics_servlets.service.registration.UserConstructionService;
//import ua.train.project_logistics_servlets.service.validation.RegFormValidator;

import javax.servlet.http.HttpServletRequest;

import java.util.Optional;

import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class RegistrationCommand implements Command {
    private RegistrationService registrationService = new RegistrationService();
    private UserConstructionService userConstructionService = new UserConstructionService();
    private RegFormValidationService regFormValidationService = new RegFormValidationService();

    private static final Logger LOGGER = LogManager.getLogger(RegistrationCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        Optional<String> validationIncompletePage = regFormValidationService.pageAfterValidation(request);

        if(validationIncompletePage.isPresent()) {
            return validationIncompletePage.get();
        }

        User user = userConstructionService.constructUserFromRequest(request);

        try {
            registrationService.addUser(user);
        } catch (UserExistsException e) {
            return USER_EXISTS_ERROR_PAGE;
        } catch (DataBaseSaveException e) {
            return DB_SAVE_ERROR_PAGE;
        } catch (DataBaseFetchException e) {
            return DB_FETCH_ERROR_PAGE;
        }

        return REDIRECT + LOGIN_PATH;
    }
}
