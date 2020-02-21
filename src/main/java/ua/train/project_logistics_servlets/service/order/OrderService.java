package ua.train.project_logistics_servlets.service.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.enums.OrderStatus;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.dao.DaoFactory;
import ua.train.project_logistics_servlets.persistence.dao.OrderDao;
import ua.train.project_logistics_servlets.persistence.domain.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    private OrderDao orderDao = DaoFactory.getInstance().createOrderDao();

    private static final Logger LOGGER = LogManager.getLogger(OrderService.class);

    public List<Order> getAllOrdersWithUserAndAddresses()
            throws DataBaseFetchException {

            return orderDao.getAllOrdersWithUserAndAddresses();
    }

    public List<Order> getAllOrdersWithUserAndAddressesByEmail(String email)
            throws DataBaseFetchException {

        return orderDao.getAllOrdersWithUserAndAddresses()
                .stream()
                .filter((o) -> o.getUser().getEmail().equals(email))
                .collect(Collectors.toList());
    }

    public List<Order> getOpenOrders()
            throws DataBaseFetchException {

            return orderDao
                    .getAllOrdersWithUserAndAddresses()
                    .stream()
                    .filter((o) -> o.getOrderStatus().equals(OrderStatus.OPEN))
                    .collect(Collectors.toList());
    }

    public List<Order> getIvoicedOrdersByUserEmail(String email)
            throws DataBaseFetchException {

            return orderDao
                    .getAllOrdersWithUserAndAddresses()
                    .stream()
                    .filter((o) -> o.getUser().getEmail().equals(email) &&
                                    o.getOrderStatus().equals(OrderStatus.INVOICED))
                    .collect(Collectors.toList());
    }

    public Order getOrderById(int id) throws DataBaseFetchException {
        return orderDao.findById(id)
                .orElseThrow(DataBaseFetchException::new);
    }
}
