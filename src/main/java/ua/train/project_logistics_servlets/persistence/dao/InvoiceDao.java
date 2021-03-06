package ua.train.project_logistics_servlets.persistence.dao;

import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.persistence.domain.Invoice;

import java.util.Optional;

public interface InvoiceDao extends GenericDao<Invoice> {
    void issueInvoice(int orderId)
            throws DataBaseSaveException;

    void payInvoice(int orderNumber)
            throws DataBaseSaveException;

    Optional<Invoice> getInvoiceByOrderNumber(int orderNumber)
            throws DataBaseFetchException;
}
