package ua.train.project_logistics_servlets.service.registration;

import ua.train.project_logistics_servlets.service.utility.RegistrationValidationUtility;

import javax.servlet.http.HttpServletRequest;

import java.util.Optional;

import static ua.train.project_logistics_servlets.constant.WebConstant.*;
import static ua.train.project_logistics_servlets.constant.WebConstant.REGISTRATION_PAGE;

public class RegistrationValidationService {
    private RegistrationValidationUtility utility = new RegistrationValidationUtility();

    public Optional<String> pageAfterValidation(HttpServletRequest request) {

        boolean isRegFormEmpty = utility.isRegistrationFormEmpty(request);

        if (isRegFormEmpty) {
            return Optional.of(REGISTRATION_PAGE);
        }

        request.setAttribute(INVALID_NAME_INPUT_ATTRIBUTE, false);
        request.setAttribute(INVALID_SURNAME_INPUT_ATTRIBUTE, false);
        request.setAttribute(INVALID_EMAIL_INPUT_ATTRIBUTE, false);
        request.setAttribute(INVALID_PASSWORD_INPUT_ATTRIBUTE, false);

        boolean isRegistrationFormValid = utility.isRegistrationFormValid(request);

        if (isRegistrationFormValid) {
            return Optional.empty();

        } else {
            boolean isNameInputValid = utility.isNameInputValid(request);
            boolean isSurnameInputValid = utility.isSurnameInputValid(request);
            boolean isEmailInputValid = utility.isEmailInputValid(request);
            boolean isPasswordInputValid = utility.isPasswordInputValid(request);

            if (!isNameInputValid) {
                request.setAttribute(INVALID_NAME_INPUT_ATTRIBUTE, true);
            }
            if (!isSurnameInputValid) {
                request.setAttribute(INVALID_SURNAME_INPUT_ATTRIBUTE, true);
            }
            if (!isEmailInputValid) {
                request.setAttribute(INVALID_EMAIL_INPUT_ATTRIBUTE, true);
            }
            if (!isPasswordInputValid) {
                request.setAttribute(INVALID_PASSWORD_INPUT_ATTRIBUTE, true);
            }

            return Optional.of(REGISTRATION_PAGE);
        }
    }
}
