package ua.train.project_logistics_servlets.service.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static ua.train.project_logistics_servlets.constant.BusinessInputConstant.*;
import static ua.train.project_logistics_servlets.constant.EntityFieldConstant.*;
import static ua.train.project_logistics_servlets.constant.RegexConstant.*;

public class OrderValidationUtility {

    private GetRegexBundleUtility regexUtility = new GetRegexBundleUtility();

    private static final String DATE_FORMAT = "dd.MM.yyyy";

    private static final Logger LOGGER = LogManager.getLogger(OrderValidationUtility.class);

    public boolean isOrderFormEmpty(HttpServletRequest request) {
        String dispatchCity = request.getParameter(ORDER_DISPATCH_CITY);
        String dispatchStreet = request.getParameter(ORDER_DISPATCH_STREET);
        String dispatchHouse = request.getParameter(ORDER_DISPATCH_HOUSE);
        String dispatchApartment = request.getParameter(ORDER_DISPATCH_APARTMENT);

        String deliveryCity = request.getParameter(ORDER_DELIVERY_CITY);
        String deliveryStreet = request.getParameter(ORDER_DELIVERY_STREET);
        String deliveryHouse = request.getParameter(ORDER_DELIVERY_HOUSE);
        String deliveryApartment = request.getParameter(ORDER_DELIVERY_APARTMENT);

        String deliveryDateStr = request.getParameter(ORDER_DELIVERY_DATE);
        String weightStr = request.getParameter(ORDER_WEIGHT);
        String cargoTypeStr = request.getParameter(ORDER_CARGO_TYPE);

        return (dispatchCity == null || dispatchCity.isEmpty()) &&
                (dispatchStreet == null || dispatchStreet.isEmpty()) &&
                (dispatchHouse == null || dispatchHouse.isEmpty()) &&
                (dispatchApartment == null || dispatchApartment.isEmpty()) &&

                (deliveryCity == null || deliveryCity.isEmpty()) &&
                (deliveryStreet == null || deliveryStreet.isEmpty()) &&
                (deliveryHouse == null || deliveryHouse.isEmpty()) &&
                (deliveryApartment == null || deliveryApartment.isEmpty()) &&

                (deliveryDateStr == null || deliveryDateStr.isEmpty()) &&
                (weightStr == null || weightStr.isEmpty()) &&
                (cargoTypeStr == null || cargoTypeStr.isEmpty());
    }

    public boolean isOrderFormValid(HttpServletRequest request) {
        return isDispatchStreetInputValid(request) &&
                isDispatchHouseInputValid(request) &&
                isDispatchApartmentInputValid(request) &&
                isDeliveryStreetInputValid(request) &&
                isDeliveryHouseInputValid(request) &&
                isDeliveryApartmentInputValid(request) &&
                isDeliveryDateInputValid(request) &&
                isWeightInputValid(request);
    }

    public boolean isDispatchStreetInputValid(HttpServletRequest request) {
        String dispatchStreet = request.getParameter(ORDER_DISPATCH_STREET);
        String regexDispatchStreet = regexUtility.getBundle(request).getString(REGEX_STREET);

        return dispatchStreet.matches(regexDispatchStreet);
    }

    public boolean isDispatchHouseInputValid(HttpServletRequest request) {
        String dispatchHouse = request.getParameter(ORDER_DISPATCH_HOUSE);
        String regexDispatchHouse = regexUtility.getBundle(request).getString(REGEX_HOUSE);

        return dispatchHouse.matches(regexDispatchHouse);
    }

    public boolean isDispatchApartmentInputValid(HttpServletRequest request) {
        String dispatchApartment = request.getParameter(ORDER_DISPATCH_APARTMENT);

        if (dispatchApartment.isEmpty()) {
            return true;

        } else {
            String regexApartment = regexUtility.getBundle(request).getString(REGEX_APARTMENT);
            return dispatchApartment.matches(regexApartment);
        }
    }

    public boolean isDeliveryStreetInputValid(HttpServletRequest request) {
        String deliveryStreet = request.getParameter(ORDER_DELIVERY_STREET);
        String regexDeliveryStreet = regexUtility.getBundle(request).getString(REGEX_STREET);

        return deliveryStreet.matches(regexDeliveryStreet);
    }

    public boolean isDeliveryHouseInputValid(HttpServletRequest request) {
        String deliveryHouse = request.getParameter(ORDER_DELIVERY_HOUSE);
        String regexDeliveryHouse = regexUtility.getBundle(request).getString(REGEX_HOUSE);

        return deliveryHouse.matches(regexDeliveryHouse);
    }

    public boolean isDeliveryApartmentInputValid(HttpServletRequest request) {
        String deliveryApartment = request.getParameter(ORDER_DELIVERY_APARTMENT);

        if (deliveryApartment.isEmpty()) {
            return true;

        } else {
            String regexApartment = regexUtility.getBundle(request).getString(REGEX_APARTMENT);
            return deliveryApartment.matches(regexApartment);
        }
    }

    public boolean isDeliveryDateInputValid(HttpServletRequest request) {
        String deliveryDateStr = request.getParameter(ORDER_DELIVERY_DATE);
        String regexDeliveryDate = regexUtility.getBundle(request).getString(REGEX_DATE);

        boolean isDeliveryDateStrMatchRegex = deliveryDateStr.matches(regexDeliveryDate);

        if (!isDeliveryDateStrMatchRegex) {
            return false;

        } else {
            LocalDate deliveryDate = LocalDate.parse(deliveryDateStr,
                    DateTimeFormatter.ofPattern(DATE_FORMAT));
            return LocalDate.now().isBefore(deliveryDate);
        }
    }

    public boolean isWeightInputValid(HttpServletRequest request) {
        String weightStr = request.getParameter(ORDER_WEIGHT);
        String regexWeight = regexUtility.getBundle(request).getString(REGEX_WEIGHT);

        boolean isWeightMatchRegex = weightStr.matches(regexWeight);

        if (!isWeightMatchRegex) {
            return false;

        } else {
            BigDecimal inputWeight = new BigDecimal(weightStr)
                    .setScale(2, RoundingMode.HALF_UP);
            LOGGER.info("inputWeight={}", inputWeight);

            BigDecimal loweBoundWeight = new BigDecimal(WEIGHT_LIGHT_LOWER_BOUND)
                    .setScale(2, RoundingMode.HALF_UP);
            LOGGER.info("loweBoundWeight={}", loweBoundWeight);

            BigDecimal upperBoundWeight = new BigDecimal(WEIGHT_HEAVY_UPPER_BOUND)
                    .setScale(2, RoundingMode.HALF_UP);
            LOGGER.info("upperBoundWeight={}", upperBoundWeight);

            return inputWeight.compareTo(loweBoundWeight) >= 0 &&
                    inputWeight.compareTo(upperBoundWeight) <= 0;
        }
    }
}
