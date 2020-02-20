package ua.train.project_logistics_servlets.persistence.dao.mapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.persistence.dao.impl.JDBCOrderDao;
import ua.train.project_logistics_servlets.persistence.domain.Invoice;
import ua.train.project_logistics_servlets.persistence.domain.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InvoiceMapper implements ObjectMapper<Invoice>{

    private static final Logger LOGGER = LogManager.getLogger(JDBCOrderDao.class);

    private static final String INVOICE_NUMBER_COLUMN = "invoice_number";
    private static final String IS_PAID = "is_paid";

    @Override
    public Invoice extractFromResultSet(ResultSet rs) throws SQLException {
        OrderMapper orderMapper = new OrderMapper();

        Invoice invoice = new Invoice();

//        Order order = orderMapper.extractFromResultSet(rs);
//        LOGGER.info("Order={}", order);

        invoice.setInvoiceNumber(rs.getInt(INVOICE_NUMBER_COLUMN));
        invoice.setPaid(rs.getBoolean(IS_PAID));
//        invoice.setOrder(order);

        return invoice;
    }
}
