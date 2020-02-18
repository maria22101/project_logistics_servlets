package ua.train.project_logistics_servlets.web.dto;

import ua.train.project_logistics_servlets.enums.CargoType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderDTO {
    private String dispatchCity;
    private String dispatchStreet;
    private String dispatchHouse;
    private String dispatchApartment;
    private String deliveryCity;
    private String deliveryStreet;
    private String deliveryHouse;
    private String deliveryApartment;
    private LocalDate deliveryDate;
    private BigDecimal weight;
    private CargoType cargoType;

    public OrderDTO(String dispatchCity,
                    String dispatchStreet,
                    String dispatchHouse,
                    String dispatchApartment,
                    String deliveryCity,
                    String deliveryStreet,
                    String deliveryHouse,
                    String deliveryApartment,
                    LocalDate deliveryDate,
                    BigDecimal weight,
                    CargoType cargoType) {
        this.dispatchCity = dispatchCity;
        this.dispatchStreet = dispatchStreet;
        this.dispatchHouse = dispatchHouse;
        this.dispatchApartment = dispatchApartment;
        this.deliveryCity = deliveryCity;
        this.deliveryStreet = deliveryStreet;
        this.deliveryHouse = deliveryHouse;
        this.deliveryApartment = deliveryApartment;
        this.deliveryDate = deliveryDate;
        this.weight = weight;
        this.cargoType = cargoType;
    }

    public String getDispatchCity() {
        return dispatchCity;
    }

    public void setDispatchCity(String dispatchCity) {
        this.dispatchCity = dispatchCity;
    }

    public String getDispatchStreet() {
        return dispatchStreet;
    }

    public void setDispatchStreet(String dispatchStreet) {
        this.dispatchStreet = dispatchStreet;
    }

    public String getDispatchHouse() {
        return dispatchHouse;
    }

    public void setDispatchHouse(String dispatchHouse) {
        this.dispatchHouse = dispatchHouse;
    }

    public String getDispatchApartment() {
        return dispatchApartment;
    }

    public void setDispatchApartment(String dispatchApartment) {
        this.dispatchApartment = dispatchApartment;
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }

    public String getDeliveryStreet() {
        return deliveryStreet;
    }

    public void setDeliveryStreet(String deliveryStreet) {
        this.deliveryStreet = deliveryStreet;
    }

    public String getDeliveryHouse() {
        return deliveryHouse;
    }

    public void setDeliveryHouse(String deliveryHouse) {
        this.deliveryHouse = deliveryHouse;
    }

    public String getDeliveryApartment() {
        return deliveryApartment;
    }

    public void setDeliveryApartment(String deliveryApartment) {
        this.deliveryApartment = deliveryApartment;
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
}
