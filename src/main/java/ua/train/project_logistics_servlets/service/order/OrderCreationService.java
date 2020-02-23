package ua.train.project_logistics_servlets.service.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.enums.CargoType;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.persistence.dao.DaoFactory;
import ua.train.project_logistics_servlets.persistence.dao.OrderDao;
import ua.train.project_logistics_servlets.persistence.domain.Route;
import ua.train.project_logistics_servlets.service.RouteService;
import ua.train.project_logistics_servlets.service.UserService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderCreationService {
    private UserService userService = new UserService();
    private RouteService routeService = new RouteService();
    private SumCalculationService sumCalculationService = new SumCalculationService();

    private OrderDao orderDao = DaoFactory.getInstance().createOrderDao();

    private static final Logger LOGGER = LogManager.getLogger(OrderCreationService.class);

    public void createOrder (String email, String dispatchCity, String dispatchStreet,
                             String dispatchHouse, String dispatchApartment, String deliveryCity,
                             String deliveryStreet, String deliveryHouse, String deliveryApartment,
                             LocalDate deliveryDate, BigDecimal weight, CargoType cargoType)
            throws DataBaseFetchException,
            DataBaseSaveException {

        Route route = routeService.getRouteByTwoPoints(dispatchCity, deliveryCity);
        BigDecimal sum = sumCalculationService.calculateSum(weight, route);
        int routeId = route.getId();
        int userId = userService.getUserIdByEmail(email);

        orderDao.createOrder(userId,
                dispatchCity, dispatchStreet, dispatchHouse, dispatchApartment,
                deliveryCity, deliveryStreet, deliveryHouse, deliveryApartment,
                deliveryDate, weight, cargoType, sum, routeId);
    }
}
