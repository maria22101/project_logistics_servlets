package ua.train.project_logistics_servlets.web.command.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.domain.Order;
import ua.train.project_logistics_servlets.service.order.OrderService;
import ua.train.project_logistics_servlets.web.command.Command;
import ua.train.project_logistics_servlets.web.command.admin.AdminOpenOrdersCommand;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class UserInvoicedOrdersCommand implements Command {
    private OrderService orderService = new OrderService();

    private static final Logger LOGGER = LogManager.getLogger(UserInvoicedOrdersCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        String email = (String) request.getSession().getAttribute(EMAIL_ATTRIBUTE);
        LOGGER.info("User's attribute from session:{}", email);

        try {
            List<Order> invoicedOrders = orderService.getIvoicedOrdersByUserEmail(email);
            request.setAttribute(ORDERS_ATTRIBUTE, invoicedOrders);
        } catch (DataBaseFetchException e) {
            return DB_FETCH_ERROR_PAGE;
        }

        return USER_INVOICED_ORDERS_PAGE;
    }
}
