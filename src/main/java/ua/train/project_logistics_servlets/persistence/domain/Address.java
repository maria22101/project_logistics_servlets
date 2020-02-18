package ua.train.project_logistics_servlets.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class Address {
    private int id;
    private String city;
    private String street;
    private String house;
    private String apartment;

    private List<Order> dispatchingOrders = new ArrayList<>();

    private List<Order> deliveringOrders = new ArrayList<>();

    public Address(int id, String city, String street, String house, String apartment) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    public Address(String city, String street, String house, String apartment) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public List<Order> getDispatchingOrders() {
        return dispatchingOrders;
    }

    public void setDispatchingOrders(List<Order> dispatchingOrders) {
        this.dispatchingOrders = dispatchingOrders;
    }

    public List<Order> getDeliveringOrders() {
        return deliveringOrders;
    }

    public void setDeliveringOrders(List<Order> deliveringOrders) {
        this.deliveringOrders = deliveringOrders;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }
}
