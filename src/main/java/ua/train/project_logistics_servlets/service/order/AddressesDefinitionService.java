package ua.train.project_logistics_servlets.service.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.dao.AddressDao;
import ua.train.project_logistics_servlets.persistence.dao.DaoFactory;
import ua.train.project_logistics_servlets.persistence.domain.Address;

import java.util.Optional;

public class AddressesDefinitionService {
    private AddressDao dao = DaoFactory.getInstance().createAddressDao();

    private static final Logger LOGGER = LogManager.getLogger(AddressesDefinitionService.class);

    // create new Address if not exists in db yet
    public Address defineDispatchAddress(
                String dispatchCity,
                String dispatchStreet,
                String dispatchHouse,
                String dispatchApartment)
            throws DataBaseFetchException {

        return getAddressFromDbByDispatchDetails(
                dispatchCity,
                dispatchStreet,
                dispatchHouse,
                dispatchApartment)
                    .orElse(new Address(
                            dispatchCity,
                            dispatchStreet,
                            dispatchHouse,
                            dispatchApartment));
    }

    // create new Address if not exists in db yet
    public Address defineDeliveryAddress(
                String deliveryCity,
                String deliveryStreet,
                String deliveryHouse,
                String deliveryApartment)
            throws DataBaseFetchException {

        return getAddressFromDbByDeliveryDetails(
                deliveryCity,
                deliveryStreet,
                deliveryHouse,
                deliveryApartment)
                    .orElse(new Address(
                            deliveryCity,
                            deliveryStreet,
                            deliveryHouse,
                            deliveryApartment));
    }

    // check Address presence in DB by entered dispatch details
    private Optional<Address> getAddressFromDbByDispatchDetails(
                String dispatchCity,
                String dispatchStreet,
                String dispatchHouse,
                String dispatchApartment)
            throws DataBaseFetchException {

        return dao.findAddress(
                dispatchCity,
                dispatchStreet,
                dispatchHouse,
                dispatchApartment);
    }

    // check Address presence in DB by entered delivery details
    private Optional<Address> getAddressFromDbByDeliveryDetails(
                String deliveryCity,
                String deliveryStreet,
                String deliveryHouse,
                String deliveryApartment)
            throws DataBaseFetchException {

        return dao.findAddress(
                deliveryCity,
                deliveryStreet,
                deliveryHouse,
                deliveryApartment);
    }
}
