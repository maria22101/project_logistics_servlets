package ua.train.project_logistics_servlets.model.entity;

public class Address {
    Long id;
    String street;
    String house;
    String apartment;

    public Address(Long id, String street, String house, String apartment) {
        this.id = id;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
