package ua.train.project_logistics_servlets.service.order;

import ua.train.project_logistics_servlets.service.utility.OrderValidationUtility;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class OrderFormValidationService {
    OrderValidationUtility utility = new OrderValidationUtility();

    public Optional<String> getPageIfValidationFailed(HttpServletRequest request) {

        boolean isOrderFormEmpty = utility.isOrderFormEmpty(request);

        if (isOrderFormEmpty) {
            return Optional.of(USER_PLACE_ORDER_PAGE);
        }

        request.setAttribute(INVALID_DISPATCH_STREET_INPUT_ATTRIBUTE, false);
        request.setAttribute(INVALID_DISPATCH_HOUSE_INPUT_ATTRIBUTE, false);
        request.setAttribute(INVALID_DISPATCH_APARTMENT_INPUT_ATTRIBUTE, false);

        request.setAttribute(INVALID_DELIVERY_STREET_INPUT_ATTRIBUTE, false);
        request.setAttribute(INVALID_DELIVERY_HOUSE_INPUT_ATTRIBUTE, false);
        request.setAttribute(INVALID_DELIVERY_APARTMENT_ATTRIBUTE, false);

        request.setAttribute(INVALID_DELIVERY_DATE_INPUT_ATTRIBUTE, false);
        request.setAttribute(INVALID_WEIGHT_INPUT_ATTRIBUTE, false);

        boolean isOrderFormValid = utility.isOrderFormValid(request);

        if (isOrderFormValid) {
            return Optional.empty();

        } else {
            boolean isDispatchStreetInputValid = utility.isDispatchStreetInputValid(request);
            boolean isDispatchHouseInputValid = utility.isDispatchHouseInputValid(request);
            boolean isDispatchApartmentInputValid = utility.isDispatchApartmentInputValid(request);

            boolean isDeliveryStreetInputValid = utility.isDeliveryStreetInputValid(request);
            boolean isDeliveryHouseInputValid = utility.isDeliveryHouseInputValid(request);
            boolean isDeliveryApartmentValid = utility.isDeliveryApartmentInputValid(request);

            boolean isDeliveryDateInputValid = utility.isDeliveryDateInputValid(request);
            boolean isWeightInputValid = utility.isWeightInputValid(request);

            if (!isDispatchStreetInputValid) {
                request.setAttribute(INVALID_DISPATCH_STREET_INPUT_ATTRIBUTE, true);
            }

            if (!isDispatchHouseInputValid) {
                request.setAttribute(INVALID_DISPATCH_HOUSE_INPUT_ATTRIBUTE, true);
            }

            if (!isDispatchApartmentInputValid) {
                request.setAttribute(INVALID_DISPATCH_APARTMENT_INPUT_ATTRIBUTE, true);
            }

            if (!isDeliveryStreetInputValid) {
                request.setAttribute(INVALID_DELIVERY_STREET_INPUT_ATTRIBUTE, true);
            }

            if (!isDeliveryHouseInputValid) {
                request.setAttribute(INVALID_DELIVERY_HOUSE_INPUT_ATTRIBUTE, true);
            }

            if (!isDeliveryApartmentValid) {
                request.setAttribute(INVALID_DELIVERY_APARTMENT_ATTRIBUTE, true);
            }

            if (!isDeliveryDateInputValid) {
                request.setAttribute(INVALID_DELIVERY_DATE_INPUT_ATTRIBUTE, true);
            }

            if (!isWeightInputValid) {
                request.setAttribute(INVALID_WEIGHT_INPUT_ATTRIBUTE, true);
            }

            return Optional.of(USER_PLACE_ORDER_PAGE);
        }
    }
}
