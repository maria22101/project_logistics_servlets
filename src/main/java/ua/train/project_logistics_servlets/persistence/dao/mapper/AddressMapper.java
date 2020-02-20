package ua.train.project_logistics_servlets.persistence.dao.mapper;

import ua.train.project_logistics_servlets.persistence.domain.Address;

import java.sql.ResultSet;
import java.sql.SQLException;

import static ua.train.project_logistics_servlets.constant.EntityFieldConstant.*;

public class AddressMapper implements ObjectMapper<Address>{
    @Override
    public Address extractFromResultSet(ResultSet rs) throws SQLException {

        Address address = new Address();

        address.setId(rs.getInt(ID));
        address.setCity(rs.getString(ADDRESS_CITY));
        address.setStreet(rs.getString(ADDRESS_STREET));
        address.setHouse(rs.getString(ADDRESS_HOUSE));
        address.setApartment(rs.getString(ADDRESS_APARTMENT));

        return address;
    }
}
