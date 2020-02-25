package ua.train.project_logistics_servlets.web.command.admin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.domain.Order;
import ua.train.project_logistics_servlets.service.order.OrderService;
import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class AdminOpenOrdersCommand implements Command {
    private OrderService orderService = new OrderService();

    private static final Logger LOGGER = LogManager.getLogger(AdminOpenOrdersCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        try {
            List<Order> allOpenOrders = orderService.getOpenOrders();
            request.setAttribute(ORDERS_ATTRIBUTE, allOpenOrders);
        } catch (DataBaseFetchException e) {
            return DB_FETCH_ERROR_PAGE;
        }

        return ADMIN_OPEN_ORDERS_PAGE;
    }
}
