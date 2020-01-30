package ua.train.project_logistics_servlets.model.entity;

import ua.train.project_logistics_servlets.model.entity.enums.CargoType;
import ua.train.project_logistics_servlets.model.entity.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order {
    private int orderNumber;
    private LocalDate deliveryDate;
    private BigDecimal weight;
    private CargoType cargoType;
    private OrderStatus orderStatus;
    private BigDecimal sum;

    private User user;
    private Route route;
    private Invoice invoice;

    public Order(int orderNumber,
                 LocalDate deliveryDate,
                 Route route,
                 BigDecimal weight,
                 CargoType cargoType,
                 User user,
                 OrderStatus orderStatus,
                 BigDecimal sum,
                 Invoice invoice) {
        this.orderNumber = orderNumber;
        this.deliveryDate = deliveryDate;
        this.route = route;
        this.weight = weight;
        this.cargoType = cargoType;
        this.user = user;
        this.orderStatus = orderStatus;
        this.sum = sum;
        this.invoice = invoice;
    }

    public Order() {
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
