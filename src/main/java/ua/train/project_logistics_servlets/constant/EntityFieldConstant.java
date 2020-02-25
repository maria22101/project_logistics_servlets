package ua.train.project_logistics_servlets.constant;

public interface EntityFieldConstant {
    //General
    String ID = "id";

    //User
    String NAME = "name";
    String SURNAME = "surname";
    String PASSWORD = "password";
    String EMAIL = "email";
    String ROLE = "role";

    //OrderDTO
    String ORDER_DISPATCH_CITY = "dispatchCity";
    String ORDER_DISPATCH_STREET = "dispatchStreet";
    String ORDER_DISPATCH_HOUSE = "dispatchHouse";
    String ORDER_DISPATCH_APARTMENT = "dispatchApartment";
    String ORDER_DELIVERY_CITY = "deliveryCity";
    String ORDER_DELIVERY_STREET = "deliveryStreet";
    String ORDER_DELIVERY_HOUSE = "deliveryHouse";
    String ORDER_DELIVERY_APARTMENT = "deliveryApartment";
    String ORDER_DELIVERY_DATE = "deliveryDate";
    String ORDER_WEIGHT = "weight";
    String ORDER_CARGO_TYPE = "cargoType";

    //Address
    String ADDRESS_CITY = "city";
    String ADDRESS_STREET = "street";
    String ADDRESS_HOUSE = "house";
    String ADDRESS_APARTMENT = "apartment";
}
