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
    private InvoiceService invoiceService = new InvoiceService();

    @Override
    public String execute(HttpServletRequest request) {

        try {
            List<Order> orders = orderService.getAllOrdersWithMainUserAndAddressInfo();
            request.setAttribute(ORDERS_ATTRIBUTE, orders);
            LOGGER.info("Attribute invoices sent to front");
        } catch (DataBaseFetchException e) {
            return DB_FETCH_ERROR_PAGE;
        }


//        try {
////            if (request.getSession().getAttribute(LANGUAGE_ATTRIBUTE) == null ||
////                    request.getSession().getAttribute(LANGUAGE_ATTRIBUTE).equals(EN_LANGUAGE)) {
////
////                List<Order> allOrdersEn = orderService.getAllOrdersEn();
////                request.setAttribute(ORDERS_ATTRIBUTE, allOrdersEn);
////
////            } else {
////
////                List<Order> allOrdersUa = orderService.getAllOrdersUa();
////                request.setAttribute(ORDERS_ATTRIBUTE, allOrdersUa);
////            }
////        } catch (DataBaseFetchException e) {
////            return DB_FETCH_ERROR_PAGE;
////        }

        return ADMIN_ORDERS_PAGE;
    }
}
