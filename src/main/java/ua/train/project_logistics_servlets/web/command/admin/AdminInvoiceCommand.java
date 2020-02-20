package ua.train.project_logistics_servlets.web.command.admin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.service.InvoiceService;
import ua.train.project_logistics_servlets.web.command.Command;

import javax.servlet.http.HttpServletRequest;

import static ua.train.project_logistics_servlets.constant.WebConstant.*;

public class AdminInvoiceCommand implements Command {
    private InvoiceService invoiceService = new InvoiceService();

    private static final Logger LOGGER = LogManager.getLogger(AdminInvoiceCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        int invoicingOrderNumber = Integer.parseInt(request.getParameter("orderNumber"));
        LOGGER.info("orderNumber from param:{}", invoicingOrderNumber);

        try {
            invoiceService.issueInvoice(invoicingOrderNumber);
        } catch (DataBaseSaveException e) {
            return DB_SAVE_ERROR_PAGE;
        }

        return ADMIN_CABINET_PAGE;
    }
}
