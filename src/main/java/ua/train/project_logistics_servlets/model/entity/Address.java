package ua.train.project_logistics_servlets.model.entity;

public class Address {
    private int id;
    private String street;
    private String house;
    private String apartment;

    private Route route;

    public Address(int id, String street, String house, String apartment, Route route) {
        this.id = id;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.route = route;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Route getRoute() {
        return route;
    }

    public Address() {
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
