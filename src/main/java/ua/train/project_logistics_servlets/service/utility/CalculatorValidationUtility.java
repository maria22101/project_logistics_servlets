package ua.train.project_logistics_servlets.service.utility;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static ua.train.project_logistics_servlets.constant.BusinessInputConstant.WEIGHT_HEAVY_UPPER_BOUND;
import static ua.train.project_logistics_servlets.constant.BusinessInputConstant.WEIGHT_LIGHT_LOWER_BOUND;
import static ua.train.project_logistics_servlets.constant.EntityFieldConstant.*;
import static ua.train.project_logistics_servlets.constant.RegexConstant.REGEX_WEIGHT;

public class CalculatorValidationUtility {

    private GetRegexBundleUtility regexUtility = new GetRegexBundleUtility();

    public boolean isCalculatorFormEmpty(HttpServletRequest request) {
        String weightStr = request.getParameter(ORDER_WEIGHT);
        return weightStr == null || weightStr.isEmpty();
    }

    public boolean isCalculatorFormValid(HttpServletRequest request) {
        return isWeightInputValid(request);
    }

    private boolean isWeightInputValid(HttpServletRequest request) {
        String weightStr = request.getParameter(ORDER_WEIGHT);
        String regexWeight = regexUtility.getBundle(request).getString(REGEX_WEIGHT);

        boolean isWeightMatchRegex = weightStr.matches(regexWeight);

        if (!isWeightMatchRegex) {
            return false;

        } else {
            BigDecimal inputWeight = new BigDecimal(weightStr)
                    .setScale(2, RoundingMode.HALF_UP);

            BigDecimal loweBoundWeight = new BigDecimal(WEIGHT_LIGHT_LOWER_BOUND)
                    .setScale(2, RoundingMode.HALF_UP);

            BigDecimal upperBoundWeight = new BigDecimal(WEIGHT_HEAVY_UPPER_BOUND)
                    .setScale(2, RoundingMode.HALF_UP);

            return inputWeight.compareTo(loweBoundWeight) >= 0 &&
                    inputWeight.compareTo(upperBoundWeight) <= 0;
        }
    }
}
