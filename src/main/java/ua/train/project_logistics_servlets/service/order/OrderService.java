package ua.train.project_logistics_servlets.service.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.OrderNotFoundException;
import ua.train.project_logistics_servlets.persistence.dao.DaoFactory;
import ua.train.project_logistics_servlets.persistence.dao.OrderDao;
import ua.train.project_logistics_servlets.persistence.domain.Order;

import java.util.List;

public class OrderService {
    private OrderDao orderDao = DaoFactory.getInstance().createOrderDao();

    private static final Logger LOGGER = LogManager.getLogger(OrderService.class);

    public List<Order> getAllOrdersWithMainUserAndAddressInfo()
            throws DataBaseFetchException {

            return orderDao.getAllOrdersWithMainUserAndAddressInfo();
    }

    public List<Order> getOpenOrders()
            throws DataBaseFetchException {

            return orderDao.getOpenOrders();
    }

    public List<Order> getIvoicedOrdersByUserEmail(String email)
            throws DataBaseFetchException {

            return orderDao.getIvoicedOrdersByUserEmail(email);
    }
}
