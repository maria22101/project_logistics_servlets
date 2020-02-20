package ua.train.project_logistics_servlets.persistence.dao;

import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.persistence.domain.Invoice;

public interface InvoiceDao extends GenericDao<Invoice> {
    void issueInvoice(int orderId)
            throws DataBaseSaveException;

    void payInvoice(int orderId)
            throws DataBaseSaveException;
}
