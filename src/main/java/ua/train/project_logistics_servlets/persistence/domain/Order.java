package ua.train.project_logistics_servlets.persistence.domain;

import ua.train.project_logistics_servlets.enums.CargoType;
import ua.train.project_logistics_servlets.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

// TODO - is Invoice needed here?
public class Order {
    private int orderNumber;
    private LocalDate deliveryDate;
    private BigDecimal weight;
    private CargoType cargoType;
    private BigDecimal sum;
    private OrderStatus orderStatus;

    private User user;
    private Address dispatchAddress;
    private Address deliveryAddress;
    private Route route;
    private Invoice invoice;

    public Order(int orderNumber,
                 LocalDate deliveryDate,
                 BigDecimal weight,
                 CargoType cargoType,
                 BigDecimal sum,
                 OrderStatus orderStatus,
                 User user,
                 Address dispatchAddress,
                 Address deliveryAddress,
                 Route route,
                 Invoice invoice) {
        this.orderNumber = orderNumber;
        this.deliveryDate = deliveryDate;
        this.weight = weight;
        this.cargoType = cargoType;
        this.sum = sum;
        this.orderStatus = orderStatus;
        this.user = user;
        this.dispatchAddress = dispatchAddress;
        this.deliveryAddress = deliveryAddress;
        this.route = route;
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

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getDispatchAddress() {
        return dispatchAddress;
    }

    public void setDispatchAddress(Address dispatchAddress) {
        this.dispatchAddress = dispatchAddress;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return deliveryDate.equals(order.deliveryDate) &&
                weight.equals(order.weight) &&
                cargoType == order.cargoType &&
                sum.equals(order.sum) &&
                orderStatus == order.orderStatus &&
                user.equals(order.user) &&
                dispatchAddress.equals(order.dispatchAddress) &&
                deliveryAddress.equals(order.deliveryAddress) &&
                route.equals(order.route);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryDate, weight, cargoType, sum, orderStatus, user, dispatchAddress, deliveryAddress, route);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", deliveryDate=" + deliveryDate +
                ", weight=" + weight +
                ", cargoType=" + cargoType +
                ", sum=" + sum +
                ", orderStatus=" + orderStatus +
                ", user=" + user +
                ", dispatchAddress=" + dispatchAddress +
                ", deliveryAddress=" + deliveryAddress +
                ", route=" + route +
                ", invoice=" + invoice +
                '}';
    }
}
