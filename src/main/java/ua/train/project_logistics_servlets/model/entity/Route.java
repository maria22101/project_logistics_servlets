package ua.train.project_logistics_servlets.model.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Route {
    private Long id;
    private String source;
    private String destination;
    private BigDecimal basicRate;

    private List<Order> orders = new ArrayList<>();

    private List<Address> addresses = new ArrayList<>();

    public Route(Long id, String source, String destination, BigDecimal basicRate,
                 List<Order> orders, List<Address> addresses) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.basicRate = basicRate;
        this.orders = orders;
        this.addresses = addresses;
    }

    public Route() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public BigDecimal getBasicRate() {
        return basicRate;
    }

    public void setBasicRate(BigDecimal basicRate) {
        this.basicRate = basicRate;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
