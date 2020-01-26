package ua.train.project_logistics_servlets.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DeliveryOder {
    private Long orderNumber;
    private LocalDate deliveryDate;
    private Route route;
    private BigDecimal weight;
    private CargoType cargoType;
    private User user;
    private OrderStatus orderStatus;
    private BigDecimal sum;

    public enum CargoType {
        REGULAR, FRAGILE
    }

    public enum OrderStatus {
        OPEN, INVOICED, READY_FOR_DISPATCH
    }

    public DeliveryOder(Long orderNumber,
                        LocalDate deliveryDate,
                        Route route,
                        BigDecimal weight,
                        CargoType cargoType,
                        User user,
                        OrderStatus orderStatus,
                        BigDecimal sum) {
        this.orderNumber = orderNumber;
        this.deliveryDate = deliveryDate;
        this.route = route;
        this.weight = weight;
        this.cargoType = cargoType;
        this.user = user;
        this.orderStatus = orderStatus;
        this.sum = sum;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
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
}
