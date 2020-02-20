package ua.train.project_logistics_servlets.constant;

import ua.train.project_logistics_servlets.enums.CargoType;
import ua.train.project_logistics_servlets.enums.OrderStatus;
import ua.train.project_logistics_servlets.enums.Role;
import ua.train.project_logistics_servlets.persistence.domain.Address;
import ua.train.project_logistics_servlets.persistence.domain.Invoice;
import ua.train.project_logistics_servlets.persistence.domain.Route;
import ua.train.project_logistics_servlets.persistence.domain.User;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

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

    //Order
    String ORDER_SUM = "";
    String ORDER_STATUS = "";

    //Address
    String ADDRESS_CITY = "city";
    String ADDRESS_STREET = "street";
    String ADDRESS_HOUSE = "house";
    String ADDRESS_APARTMENT = "apartment";

    //Invoice
    String INVOICE_NUMBER = "invoiceNumber";
    String INVOICE_IS_PAID = "isPaid";
}
