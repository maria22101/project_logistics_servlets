package ua.train.project_logistics_servlets.web.command.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.service.InvoiceService;
import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;

import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class UserPayingCommand implements Command {
    private InvoiceService invoiceService = new InvoiceService();

    @Override
    public String execute(HttpServletRequest request) {
        int payingOrder = Integer.parseInt(request.getParameter(ORDER_NUMBER_PARAMETER));

        try {
            invoiceService.payInvoice(payingOrder);
        } catch (DataBaseSaveException e) {
            return DB_SAVE_ERROR_PAGE;
        }

        return REDIRECT + SERVLET_MAIN_PATH + USER_INVOICED_ORDERS_PATH;
    }
}
