package ua.train.project_logistics_servlets.service.calculator;

import ua.train.project_logistics_servlets.service.utility.CalculatorValidationUtility;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class CalculatorFormValidationService {
    CalculatorValidationUtility utility = new CalculatorValidationUtility();

    public Optional<String> getPageIfValidationFailed(HttpServletRequest request) {

        boolean isCalculatorFormEmpty = utility.isCalculatorFormEmpty(request);

        if (isCalculatorFormEmpty) {
            return Optional.of(CONTEXT_PATH);
        }

        request.setAttribute(INVALID_WEIGHT_INPUT_ATTRIBUTE, false);

        boolean isCalculatorFormValid = utility.isCalculatorFormValid(request);

        if (isCalculatorFormValid) {
            return Optional.empty();

        } else {
            request.setAttribute(INVALID_WEIGHT_INPUT_ATTRIBUTE, true);
        }

        return Optional.of(CONTEXT_PATH);
    }
}
