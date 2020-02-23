package ua.train.project_logistics_servlets.web.command.user;

import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.domain.Order;
import ua.train.project_logistics_servlets.service.UserService;
import ua.train.project_logistics_servlets.service.order.OrderService;
import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class UserOrdersCommand implements Command {
    private OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request) {
        String email = (String) request.getSession().getAttribute(EMAIL_ATTRIBUTE);

        try {
            List<Order> orders = orderService.getAllOrdersByEmail(email);
            request.setAttribute(ORDERS_ATTRIBUTE, orders);
        } catch (DataBaseFetchException e) {
            return DB_FETCH_ERROR_PAGE;
        }

        return USER_ORDERS_PAGE;
    }
}