package ua.train.project_logistics_servlets.web.command.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.domain.Invoice;
import ua.train.project_logistics_servlets.persistence.domain.Order;
import ua.train.project_logistics_servlets.service.InvoiceService;
import ua.train.project_logistics_servlets.service.order.OrderService;
import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class UserOrderDetailsCommand implements Command {
    InvoiceService invoiceService = new InvoiceService();

    @Override
    public String execute(HttpServletRequest request) {
        int orderNumber = Integer.parseInt(request.getParameter("orderNumber"));

        try {
            Invoice invoice = invoiceService.getInvoiceByOrderNumber(orderNumber);
            request.setAttribute(INVOICE_ATTRIBUTE, invoice);
        } catch (DataBaseFetchException e) {
            return DB_FETCH_ERROR_PAGE;
        }

        return USER_INVOICED_ORDER_DETAILS_PAGE;
    }
}
