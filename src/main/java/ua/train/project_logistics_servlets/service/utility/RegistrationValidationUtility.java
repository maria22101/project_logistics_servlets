package ua.train.project_logistics_servlets.service.utility;

import javax.servlet.http.HttpServletRequest;

import static ua.train.project_logistics_servlets.constant.EntityFieldConstant.*;
import static ua.train.project_logistics_servlets.constant.RegexConstant.*;

public class RegistrationValidationUtility {

    private GetRegexBundleUtility regexUtility = new GetRegexBundleUtility();

    public boolean isRegistrationFormEmpty(HttpServletRequest request) {
        String name = request.getParameter(NAME);
        String surname = request.getParameter(SURNAME);
        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);

        return (name == null || name.isEmpty()) &&
                (surname == null || surname.isEmpty()) &&
                (email == null || email.isEmpty()) &&
                (password == null || password.isEmpty());
    }

    public boolean isRegistrationFormValid(HttpServletRequest request) {
        return isNameInputValid(request) &&
                isSurnameInputValid(request) &&
                isEmailInputValid(request) &&
                isPasswordInputValid(request);
    }

    public boolean isNameInputValid(HttpServletRequest request) {
        boolean isValid;
        String name = request.getParameter(NAME);
        String regexName = regexUtility.getBundle(request).getString(REGEX_NAME);
        isValid = name.matches(regexName);

        return isValid;
    }

    public boolean isSurnameInputValid(HttpServletRequest request) {
        boolean isValid;
        String surname = request.getParameter(SURNAME);
        String regexSurname = regexUtility.getBundle(request).getString(REGEX_SURNAME);
        isValid = surname.matches(regexSurname);

        return isValid;
    }

    public boolean isEmailInputValid(HttpServletRequest request) {
        boolean isValid;
        String email = request.getParameter(EMAIL);
        String regexEmail = regexUtility.getBundle(request).getString(REGEX_EMAIL);
        isValid = email.matches(regexEmail);

        return isValid;
    }

    public boolean isPasswordInputValid(HttpServletRequest request) {
        boolean isValid;
        String password = request.getParameter(PASSWORD);
        String regexPassword = regexUtility.getBundle(request).getString(REGEX_PASSWORD);
        isValid = password.matches(regexPassword);

        return isValid;
    }
}
