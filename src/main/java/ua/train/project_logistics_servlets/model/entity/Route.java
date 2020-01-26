package ua.train.project_logistics_servlets.model.entity;

import java.math.BigDecimal;

public class Route {
    private Long id;
    private String source;
    private String destination;
    private BigDecimal basicRate;

    public Route(Long id, String source, String destination, BigDecimal basicRate) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.basicRate = basicRate;
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
}
