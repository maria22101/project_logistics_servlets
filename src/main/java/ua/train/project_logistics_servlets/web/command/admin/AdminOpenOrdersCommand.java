package ua.train.project_logistics_servlets.web.command.admin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.persistence.domain.Invoice;
import ua.train.project_logistics_servlets.persistence.domain.Order;
import ua.train.project_logistics_servlets.service.InvoiceService;
import ua.train.project_logistics_servlets.service.order.OrderService;
import ua.train.project_logistics_servlets.web.command.Command;
import ua.train.project_logistics_servlets.web.command.user.PlaceOrderCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static ua.train.project_logistics_servlets.constant.WebConstant.*;
import static ua.train.project_logistics_servlets.constant.WebConstant.DB_FETCH_ERROR_PAGE;

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
