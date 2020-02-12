package ua.train.project_logistics_servlets.model.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Route {
    private int id;
    private String pointOne;
    private String pointOneUA;
    private String pointTwo;
    private String pointTwoUA;
    private BigDecimal basicRate;

    private List<Order> orders = new ArrayList<>();

    public Route(int id,
                 String pointOne,
                 String pointOneUA,
                 String pointTwo,
                 String pointTwoUA,
                 BigDecimal basicRate) {
        this.id = id;
        this.pointOne = pointOne;
        this.pointOneUA = pointOneUA;
        this.pointTwo = pointTwo;
        this.pointTwoUA = pointTwoUA;
        this.basicRate = basicRate;
    }

    public Route() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPointOne() {
        return pointOne;
    }

    public void setPointOne(String pointOne) {
        this.pointOne = pointOne;
    }

    public String getPointOneUA() {
        return pointOneUA;
    }

    public void setPointOneUA(String pointOneUA) {
        this.pointOneUA = pointOneUA;
    }

    public String getPointTwo() {
        return pointTwo;
    }

    public void setPointTwo(String pointTwo) {
        this.pointTwo = pointTwo;
    }

    public String getPointTwoUA() {
        return pointTwoUA;
    }

    public void setPointTwoUA(String pointTwoUA) {
        this.pointTwoUA = pointTwoUA;
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
}
