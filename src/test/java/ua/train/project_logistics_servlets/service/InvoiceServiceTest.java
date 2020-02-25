package ua.train.project_logistics_servlets.service;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ua.train.project_logistics_servlets.persistence.dao.InvoiceDao;

import static org.junit.Assert.*;

public class InvoiceServiceTest {

    @InjectMocks
    private InvoiceService instance;

    @Mock
    private InvoiceDao invoiceDao;

    @Test
    public void getAllInvoices() {
    }

    @Test
    public void issueInvoice() {
    }

    @Test
    public void payInvoice() {
    }

    @Test
    public void getInvoiceByOrderNumber() {
    }
}