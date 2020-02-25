package ua.train.project_logistics_servlets.persistence.domain;

import java.util.Objects;

public class Invoice {
    private int invoiceNumber;
    private boolean isPaid;

    private Order order;

    public Invoice(int invoiceNumber, boolean isPaid, Order order) {
        this.invoiceNumber = invoiceNumber;
        this.isPaid = isPaid;
        this.order = order;
    }

    public Invoice(Order order) {
        this.order = order;
    }

    public Invoice() {
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return invoiceNumber == invoice.invoiceNumber &&
                isPaid == invoice.isPaid &&
                order.equals(invoice.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceNumber, isPaid, order);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNumber=" + invoiceNumber +
                ", isPaid=" + isPaid +
                ", order=" + order +
                '}';
    }
}
