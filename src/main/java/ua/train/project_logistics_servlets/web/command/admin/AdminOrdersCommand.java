package ua.train.project_logistics_servlets.web.command.admin;

import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.domain.Invoice;
import ua.train.project_logistics_servlets.persistence.domain.Order;
import ua.train.project_logistics_servlets.service.InvoiceService;
import ua.train.project_logistics_servlets.service.order.OrderService;
import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class AdminOrdersCommand implements Command {
    private OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request) {

        try {
            List<Order> orders = orderService.getAllOrdersWithMainUserAndAddressInfo();
            request.setAttribute(ORDERS_ATTRIBUTE, orders);
        } catch (DataBaseFetchException e) {
            return DB_FETCH_ERROR_PAGE;
        }

        return ADMIN_ORDERS_PAGE;
    }
}
