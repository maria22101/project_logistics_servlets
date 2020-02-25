package ua.train.project_logistics_servlets.web.command.admin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.domain.Invoice;
import ua.train.project_logistics_servlets.service.InvoiceService;
import ua.train.project_logistics_servlets.service.order.OrderService;
import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class AdminOrdersCommand implements Command {
    private OrderService orderService = new OrderService();
    private InvoiceService invoiceService = new InvoiceService();

    private static final Logger LOGGER = LogManager.getLogger(AdminOpenOrdersCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        try {
            List<Invoice> invoices = invoiceService.getAllInvoices();
            request.setAttribute(INVOICES_ATTRIBUTE, invoices);
        } catch (DataBaseFetchException e) {
            return DB_FETCH_ERROR_PAGE;
        }

        return ADMIN_ORDERS_PAGE;
    }
}
