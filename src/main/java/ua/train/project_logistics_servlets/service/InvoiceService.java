package ua.train.project_logistics_servlets.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.enums.OrderStatus;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.exception.OrderNotFoundException;
import ua.train.project_logistics_servlets.persistence.dao.DaoFactory;
import ua.train.project_logistics_servlets.persistence.dao.InvoiceDao;
import ua.train.project_logistics_servlets.persistence.dao.OrderDao;
import ua.train.project_logistics_servlets.persistence.domain.Invoice;
import ua.train.project_logistics_servlets.persistence.domain.Order;
import ua.train.project_logistics_servlets.service.order.OrderService;

import java.util.List;

public class InvoiceService {
    private InvoiceDao invoiceDao = DaoFactory.getInstance().createInvoiceDao();

    private static final Logger LOGGER = LogManager.getLogger(InvoiceService.class);

    public void issueInvoice(int orderNumber)
            throws DataBaseSaveException {

        invoiceDao.issueInvoice(orderNumber);
    }

    public void payInvoice(int orderNumber)
            throws DataBaseSaveException {

        invoiceDao.payInvoice(orderNumber);
    }
}
