package ua.train.project_logistics_servlets.persistence.dao;

import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.persistence.domain.Address;

import java.util.Optional;

public interface AddressDao extends GenericDao<Address> {
    Optional<Address> findAddress(String city,
                                  String street,
                                  String house,
                                  String apartment)
            throws DataBaseFetchException;

    Optional<Address> getAddress(Address address) throws DataBaseFetchException;
}
