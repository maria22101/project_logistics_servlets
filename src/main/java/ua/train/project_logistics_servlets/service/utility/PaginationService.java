package ua.train.project_logistics_servlets.service.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.dao.DaoFactory;
import ua.train.project_logistics_servlets.persistence.dao.OrderDao;
import ua.train.project_logistics_servlets.persistence.domain.Order;

import java.util.List;

public class PaginationService {
    private OrderDao orderDao = DaoFactory.getInstance().createOrderDao();

    private static final Logger LOGGER = LogManager.getLogger(PaginationService.class);

    public Page<Order> getOrdersPageByEmail(String email, int currentPage, int pageSize)
            throws DataBaseFetchException {

        int daoCurrentPage = currentPage - 1;
        int numberOfOrders = orderDao.countOrders();
        int offset = pageSize * daoCurrentPage;
        List<Order> elements = getOrdersForPageByEmail(email, offset, pageSize);

        return new Page<>(numberOfOrders, daoCurrentPage, elements, pageSize);
    }

    private List<Order> getOrdersForPageByEmail(String email, int offset, int pageSize)
            throws DataBaseFetchException {

        return orderDao
                .findOrdersForPageByEmail(email, offset, pageSize);
    }
}
