package ua.train.project_logistics_servlets.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.persistence.domain.Address;
import ua.train.project_logistics_servlets.persistence.domain.Route;
import ua.train.project_logistics_servlets.web.dto.OrderDTO;

import java.math.BigDecimal;
import java.util.Optional;

public class OrderCreationService {
    private static final Logger LOGGER = LogManager.getLogger(OrderCreationService.class);

    // 1 - get the relevant Route
    private Route getRoutefromDb(OrderDTO orderDTO) {
        //findByPointOneAndPointTwoOrPointTwoAndPointOne(String 1, String 2, String 3, String 4) - implement in Dao
        return null;
    }

    // 2 - check Addresses presence in DB and create those if absent
    private Optional<Address> getAddressFromDbByDispatchDetails(OrderDTO orderDTO) {
        //findAddressesByCityAndStreetAndHouseAndApartment(String dCity, dStreet, dHouse, dAppartment) - implement in Dao
        return null;
    }

    private Optional<Address> getAddressFromDbByDeliveryDetails(OrderDTO orderDTO) {
        //the same method as above
        return null;
    }

    private Address defineDispatchAddress(OrderDTO orderDTO) {
        //#2 method usage
        return null;
    }

    private Address defineDeliveryAddress(OrderDTO orderDTO) {
        //#2 method usage
        return null;
    }

    // 3 - calculate weight rate coefficient based on weight and business input
    private BigDecimal getWeightRateCoefficient(OrderDTO orderDTO) {
        return null;
    }

    // getting basic rate from the Route
    private BigDecimal calculateSum(OrderDTO orderDTO) {
        //#1 method usage
        return null;
    }
}
