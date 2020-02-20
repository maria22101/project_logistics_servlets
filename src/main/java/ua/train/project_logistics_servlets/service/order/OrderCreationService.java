package ua.train.project_logistics_servlets.service.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.enums.CargoType;
import ua.train.project_logistics_servlets.enums.OrderStatus;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.persistence.dao.AddressDao;
import ua.train.project_logistics_servlets.persistence.dao.DaoFactory;
import ua.train.project_logistics_servlets.persistence.dao.OrderDao;
import ua.train.project_logistics_servlets.persistence.domain.Address;
import ua.train.project_logistics_servlets.persistence.domain.Order;
import ua.train.project_logistics_servlets.persistence.domain.Route;
import ua.train.project_logistics_servlets.persistence.domain.User;
import ua.train.project_logistics_servlets.service.RouteService;
import ua.train.project_logistics_servlets.service.UserService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class OrderCreationService {
    private OrderDao orderDao = DaoFactory.getInstance().createOrderDao();
    private AddressDao addressDao = DaoFactory.getInstance().createAddressDao();

    private UserService userService = new UserService();
    private SumCalculationService sumCalculationService = new SumCalculationService();
    private RouteService routeService = new RouteService();

    private static final Logger LOGGER = LogManager.getLogger(OrderCreationService.class);

    public void addOrder(String email,
                         String dispatchCity, String dispatchStreet, String dispatchHouse, String dispatchApartment,
                         String deliveryCity, String deliveryStreet, String deliveryHouse, String deliveryApartment,
                         LocalDate deliveryDate, BigDecimal weight, CargoType cargoType)
            throws DataBaseFetchException,
            DataBaseSaveException {

        User user = userService.getUserFromDb(email);
        Route route = routeService.getRouteFromDb(dispatchCity, deliveryCity);
        BigDecimal sum = sumCalculationService.calculateSum(weight, route);

        Order order = new Order();
        order.setUser(user);
        order.setDeliveryDate(deliveryDate);
        order.setWeight(weight);
        order.setCargoType(cargoType);
        order.setSum(sum);
        order.setOrderStatus(OrderStatus.OPEN);
        order.setRoute(route);

        Optional<Address> dispatchAddressFromDb = addressDao
                .findAddress(dispatchCity, dispatchStreet, dispatchHouse, dispatchApartment);

        if (dispatchAddressFromDb.isPresent()) {
            Address dispatchAddress = dispatchAddressFromDb.get();
            order.setDispatchAddress(dispatchAddress);
        } else {
            Address newDispatchAddress = new Address(dispatchCity, dispatchStreet, dispatchHouse, dispatchApartment);
            addressDao.create(newDispatchAddress);
            Address savedNewDispatchAddress = addressDao.getAddress(newDispatchAddress)
                    .orElseThrow(DataBaseFetchException::new);
            order.setDispatchAddress(savedNewDispatchAddress);
        }

        Optional<Address> deliveryAddressFromDB = addressDao
                .findAddress(deliveryCity, deliveryStreet, deliveryHouse, deliveryApartment);

        if (deliveryAddressFromDB.isPresent()) {
            Address deliveryAddress = deliveryAddressFromDB.get();
            order.setDeliveryAddress(deliveryAddress);
        } else {
            Address newDeliveryAddress = new Address(deliveryCity, deliveryStreet, deliveryHouse, deliveryApartment);
            addressDao.create(newDeliveryAddress);
            Address savedNewDeliveryAddress = addressDao.getAddress(newDeliveryAddress)
                    .orElseThrow(DataBaseFetchException::new);
            order.setDeliveryAddress(savedNewDeliveryAddress);
        }

        orderDao.create(order);
    }
}
