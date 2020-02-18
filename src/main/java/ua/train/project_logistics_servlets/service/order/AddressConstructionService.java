package ua.train.project_logistics_servlets.service.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.persistence.domain.Address;

import javax.servlet.http.HttpServletRequest;

import static ua.train.project_logistics_servlets.constant.EntityFieldConstant.*;

public class AddressConstructionService {
    private static final Logger LOGGER = LogManager.getLogger(AddressConstructionService.class);

    //TODO: - double check the logic, as from HTTP request we get OrderDTO fields
    public Address constructAddressFromRequest(HttpServletRequest request) {
        String city = request.getParameter(ADDRESS_CITY);
        String street = request.getParameter(ADDRESS_STREET);
        String house = request.getParameter(ADDRESS_HOUSE);
        String apartment = request.getParameter(ADDRESS_APARTMENT);

        Address address = new Address();
        address.setCity(city);
        address.setStreet(street);
        address.setHouse(house);
        address.setApartment(apartment);
        LOGGER.info("User constructed = {}", address);

        return address;
    }
}
