package ua.train.project_logistics_servlets.persistence.dao;

import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.persistence.domain.Invoice;
import ua.train.project_logistics_servlets.persistence.domain.Order;

import java.util.List;
import java.util.Optional;

public interface InvoiceDao extends GenericDao<Invoice> {
    void issueInvoice(int orderId)
            throws DataBaseSaveException;

    void payInvoice(int orderId)
            throws DataBaseSaveException;

    List<Invoice> getAllInvoicesWithOrdersAndUserAndAddresses()
            throws DataBaseFetchException;

    Optional<Invoice> getInvoiceByOrderNumber(int orderNumber)
            throws DataBaseFetchException;
}
