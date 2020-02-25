package ua.train.project_logistics_servlets.web.command;

import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.domain.Route;
import ua.train.project_logistics_servlets.service.RouteService;
import ua.train.project_logistics_servlets.service.calculator.CalculatorFormValidationService;
import ua.train.project_logistics_servlets.service.order.SumCalculationService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import static ua.train.project_logistics_servlets.constant.EntityFieldConstant.*;
import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class CalculatorCommand implements Command {
    private SumCalculationService sumCalculationService = new SumCalculationService();
    private RouteService routeService = new RouteService();
    private CalculatorFormValidationService calcValidationService = new CalculatorFormValidationService();

    @Override
    public String execute(HttpServletRequest request) {

        Optional<String> pageIfValidationFailed = calcValidationService.getPageIfValidationFailed(request);

        if (pageIfValidationFailed.isPresent()) {
            return pageIfValidationFailed.get();
        }

        String dispatchCity = request.getParameter(ORDER_DISPATCH_CITY);
        String deliveryCity = request.getParameter(ORDER_DELIVERY_CITY);
        BigDecimal weight = new BigDecimal(request.getParameter(ORDER_WEIGHT))
                .setScale(2, RoundingMode.HALF_UP);

        request.setAttribute(WEIGHT_ATTRIBUTE, weight);

        try {
            Route route = routeService.getRouteByTwoPoints(dispatchCity, deliveryCity);
            BigDecimal sum = sumCalculationService.calculateSum(weight, route);
            request.setAttribute(SUM_ATTRIBUTE, sum);
            request.setAttribute(ORDER_DISPATCH_CITY, dispatchCity);
            request.setAttribute(ORDER_DELIVERY_CITY, deliveryCity);

        } catch (DataBaseFetchException e) {
            return DB_FETCH_ERROR_PAGE;
        }

        return CALCULATOR_RESULT_PAGE;
    }
}
