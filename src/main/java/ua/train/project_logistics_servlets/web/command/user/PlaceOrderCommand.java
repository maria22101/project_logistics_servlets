package ua.train.project_logistics_servlets.web.command.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.enums.CargoType;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.exception.UserExistsException;
import ua.train.project_logistics_servlets.persistence.domain.Route;
import ua.train.project_logistics_servlets.service.RouteService;
import ua.train.project_logistics_servlets.service.order.OrderCreationService;
import ua.train.project_logistics_servlets.service.order.OrderFormValidationService;
import ua.train.project_logistics_servlets.web.command.Command;
import ua.train.project_logistics_servlets.web.command.RegistrationCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import static ua.train.project_logistics_servlets.constant.EntityFieldConstant.*;
import static ua.train.project_logistics_servlets.constant.EntityFieldConstant.ORDER_DISPATCH_APARTMENT;
import static ua.train.project_logistics_servlets.constant.RegexConstant.REGEX_BUNDLE;
import static ua.train.project_logistics_servlets.constant.WebConstant.*;
import static ua.train.project_logistics_servlets.constant.WebConstant.DB_FETCH_ERROR_PAGE;

public class PlaceOrderCommand implements Command {
    private OrderCreationService orderCreationService = new OrderCreationService();
    private OrderFormValidationService orderFormValidationService = new OrderFormValidationService();
    RouteService routeService = new RouteService();
    private static final String DATE_FORMAT = "dd.MM.yyyy";

    private static final Logger LOGGER = LogManager.getLogger(PlaceOrderCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        try {
            if (request.getSession().getAttribute(LANGUAGE_ATTRIBUTE) == null ||
                    request.getSession().getAttribute(LANGUAGE_ATTRIBUTE).equals(EN_LANGUAGE)) {

                List<String> allRoutesEn = routeService.getCitiesOptionsEng();
                request.setAttribute("routes", allRoutesEn);

            } else {

                List<String> allRoutesUa = routeService.getCitiesOptionsUa();
                request.setAttribute("routes", allRoutesUa);
            }
        } catch (DataBaseFetchException e) {
            return DB_FETCH_ERROR_PAGE;
        }

        request.setAttribute("cargoTypes", CargoType.values());

        Optional<String> pageIfValidationFailed = orderFormValidationService.getPageIfValidationFailed(request);

        LOGGER.info("pageIfValidationFailed={}", pageIfValidationFailed);

        if (pageIfValidationFailed.isPresent()) {
            return pageIfValidationFailed.get();
        }

        LOGGER.info("Submitting form...");

        String email = (String) request.getSession().getAttribute(EMAIL_ATTRIBUTE);

        String dispatchCity = request.getParameter(ORDER_DISPATCH_CITY);
        String dispatchStreet = request.getParameter(ORDER_DISPATCH_STREET);
        String dispatchHouse = request.getParameter(ORDER_DISPATCH_HOUSE);
        String dispatchApartment = request.getParameter(ORDER_DISPATCH_APARTMENT);

        String deliveryCity = request.getParameter(ORDER_DELIVERY_CITY);
        String deliveryStreet = request.getParameter(ORDER_DELIVERY_STREET);
        String deliveryHouse = request.getParameter(ORDER_DELIVERY_HOUSE);
        String deliveryApartment = request.getParameter(ORDER_DELIVERY_APARTMENT);

        LocalDate deliveryDate = LocalDate.parse(
                request.getParameter(ORDER_DELIVERY_DATE),
                DateTimeFormatter.ofPattern(DATE_FORMAT));
        LOGGER.info("deliveryDate={}", deliveryDate);
        LOGGER.info("dataType={}", deliveryDate.getClass());

        BigDecimal weight = new BigDecimal(request.getParameter(ORDER_WEIGHT))
                .setScale(2, RoundingMode.HALF_UP);
        LOGGER.info("weight={}", weight);
        LOGGER.info("dataType={}", weight.getClass());

        CargoType cargoType = CargoType.valueOf(request.getParameter(ORDER_CARGO_TYPE));
        LOGGER.info("cargoType={}", cargoType);
        LOGGER.info("dataType={}", cargoType.getClass());

        try {
            orderCreationService.addOrder(email,
                    dispatchCity, dispatchStreet, dispatchHouse, dispatchApartment,
                    deliveryCity, deliveryStreet, deliveryHouse, deliveryApartment,
                    deliveryDate, weight, cargoType);
        } catch (DataBaseSaveException e) {
            return DB_SAVE_ERROR_PAGE;
        } catch (DataBaseFetchException e) {
            return DB_FETCH_ERROR_PAGE;
        }

        return USER_CABINET_PAGE;
    }
}
