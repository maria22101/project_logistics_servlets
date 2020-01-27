package ua.train.project_logistics_servlets.model.entity;

public class Invoice {
    private Long invoiceNumber;
    private boolean isPaid;

    private Order order;

    public Invoice(Long invoiceNumber, boolean isPaid, Order order) {
        this.invoiceNumber = invoiceNumber;
        this.isPaid = isPaid;
        this.order = order;
    }

    public Invoice() {
    }

    public Long getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
