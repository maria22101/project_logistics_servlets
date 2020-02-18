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
    private UserService userService = new UserService();
//    private AddressesDefinitionService addressService = new AddressesDefinitionService();
    private SumCalculationService sumCalculationService = new SumCalculationService();
    private RouteService routeService = new RouteService();

    DaoFactory daoFactory = DaoFactory.getInstance();

    private static final Logger LOGGER = LogManager.getLogger(OrderCreationService.class);

    public void addOrder(String email,
                         String dispatchCity, String dispatchStreet, String dispatchHouse, String dispatchApartment,
                         String deliveryCity, String deliveryStreet, String deliveryHouse, String deliveryApartment,
                         LocalDate deliveryDate, BigDecimal weight, CargoType cargoType)
            throws DataBaseFetchException,
            DataBaseSaveException {

        LOGGER.info("Inside OrderCreationService...");

        User user = userService.getUserFromDb(email);
        LOGGER.info("user={}", user);

//        Address dispatchAddress = addressService.defineDispatchAddress(
//                        dispatchCity,
//                        dispatchStreet,
//                        dispatchHouse,
//                        dispatchApartment
//                );
//        LOGGER.info("dispatchAddress={}", dispatchAddress);
//
//        Address deliveryAddress = addressService.defineDeliveryAddress(
//                        deliveryCity,
//                        deliveryStreet,
//                        deliveryHouse,
//                        deliveryApartment
//                );
//        LOGGER.info("deliveryAddress={}", deliveryAddress);

        Route route = routeService.getRouteFromDb(dispatchCity, deliveryCity);
        LOGGER.info("route={}", route);

        BigDecimal sum = sumCalculationService.calculateSum(weight, route);
        LOGGER.info("sum={}", sum);

        Order order = new Order();
        order.setUser(user);
        order.setDeliveryDate(deliveryDate);
        order.setWeight(weight);
        order.setCargoType(cargoType);
        order.setSum(sum);
        order.setOrderStatus(OrderStatus.OPEN);
        order.setRoute(route);
        LOGGER.info("order={}", order);

        try (AddressDao addressDao = daoFactory.createAddressDao();
             OrderDao orderDao = daoFactory.createOrderDao()) {

//            addressDao.create(dispatchAddress);
//            addressDao.create(deliveryAddress);
//
//            Address savedDispatchAddress = addressDao.findAddress(dispatchAddress.getCity(),
//                                    dispatchAddress.getStreet(),
//                                    dispatchAddress.getHouse(),
//                                    dispatchAddress.getApartment())
//                    .orElseThrow(DataBaseFetchException::new);
//
//            Address savedDeliveryAddress = addressDao.findAddress(deliveryAddress.getCity(),
//                    deliveryAddress.getStreet(),
//                    deliveryAddress.getHouse(),
//                    deliveryAddress.getApartment())
//                    .orElseThrow(DataBaseFetchException::new);

            Address dispatchAddress;
            Optional<Address> dispatchAddr = addressDao
                    .findAddress(dispatchCity, dispatchStreet, dispatchHouse, dispatchApartment);
            if (dispatchAddr.isPresent()) {
                dispatchAddress = addressDao
                        .findAddress(dispatchCity, dispatchStreet, dispatchHouse, dispatchApartment).get();
            } else {
                dispatchAddress = new Address(dispatchCity, dispatchStreet, dispatchHouse, dispatchApartment);
                addressDao.create(dispatchAddress);
            }

            Address deliveryAddress;
            Optional<Address> deliveryAddr = addressDao
                    .findAddress(deliveryCity, deliveryStreet, deliveryHouse, deliveryApartment);
            if (deliveryAddr.isPresent()) {
                deliveryAddress = addressDao
                        .findAddress(deliveryCity, deliveryStreet, deliveryHouse, deliveryApartment).get();
            } else {
                deliveryAddress = new Address(deliveryCity, deliveryStreet, deliveryHouse, deliveryApartment);
                addressDao.create(deliveryAddress);
            }

//            order.setDispatchAddress(savedDispatchAddress);
//            order.setDeliveryAddress(savedDeliveryAddress);

            order.setDispatchAddress(dispatchAddress);
            order.setDeliveryAddress(deliveryAddress);

            orderDao.create(order);

        } catch (Exception e) {
            throw new DataBaseSaveException();
        }
    }
}
