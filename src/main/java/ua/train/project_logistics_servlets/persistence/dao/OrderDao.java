package ua.train.project_logistics_servlets.persistence.dao;

import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.domain.Order;

import java.util.List;

public interface OrderDao extends GenericDao<Order> {
    List<Order> getAllOrdersWithUserAndAddresses()
            throws DataBaseFetchException;

//    List<Order> getOpenOrders()
//            throws DataBaseFetchException;

//    List<Order> getIvoicedOrdersByUserEmail(String email)
//            throws DataBaseFetchException;

//    List<Order> getAllOrdersWithUserAndAddressesByEmail(String email)
//            throws DataBaseFetchException;
}
