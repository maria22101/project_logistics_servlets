package ua.train.project_logistics_servlets.persistence.dao;

import ua.train.project_logistics_servlets.enums.CargoType;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.persistence.domain.Order;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface OrderDao extends GenericDao<Order> {
    List<Order> getOpenOrders()
            throws DataBaseFetchException;

    List<Order> getAllOrdersByEmail(String email)
            throws DataBaseFetchException;

    List<Order> getInvoicedOrdersByEmail(String email)
            throws DataBaseFetchException;

    void createOrder (int userId,
                      String dispatchCity, String dispatchStreet, String dispatchHouse, String dispatchApartment,
                      String deliveryCity, String deliveryStreet, String deliveryHouse, String deliveryApartment,
                      LocalDate deliveryDate, BigDecimal weight, CargoType cargoType,
                      BigDecimal sum, int routeId)
            throws DataBaseSaveException;
}
