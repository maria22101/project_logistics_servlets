package ua.train.project_logistics_servlets.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.persistence.dao.AddressDao;
import ua.train.project_logistics_servlets.persistence.dao.mapper.AddressMapper;
import ua.train.project_logistics_servlets.persistence.dao.mapper.RouteMapper;
import ua.train.project_logistics_servlets.persistence.domain.Address;
import ua.train.project_logistics_servlets.persistence.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JDBCAddressDao implements AddressDao {
    private AddressMapper addressMapper = new AddressMapper();
    private static final Logger LOGGER = LogManager.getLogger(JDBCAddressDao.class);

    private static final String GET_ADDRESS = "SELECT * FROM addresses WHERE " +
            "city=? AND street=? AND house=? AND apartment=?";

    private static final String SAVE_ADDRESS = "INSERT INTO addresses " +
            "(city, street, house, apartment)" + " VALUES(?, ?, ?, ?)";

    @Override
    public Optional<Address> findAddress(String city,
                                         String street,
                                         String house,
                                         String apartment)
            throws DataBaseFetchException {

        Optional<Address> address = Optional.empty();

        try (Connection connection = ConnectionPoolHolder.getConnection();
                PreparedStatement prepStatement = connection.prepareStatement(GET_ADDRESS)) {

            prepStatement.setString(1, city);
            prepStatement.setString(2, street);
            prepStatement.setString(3, house);
            prepStatement.setString(4, apartment);
            ResultSet rs = prepStatement.executeQuery();
            if (rs.next()){
                address = Optional.of(addressMapper.extractFromResultSet(rs));
            }

        }catch (Exception e) {
            throw new DataBaseFetchException();
        }
        return address;
    }

    @Override
    public Optional<Address> getAddress(Address address)
            throws DataBaseFetchException {

        Optional<Address> addressFromDb = Optional.empty();

        try (Connection connection = ConnectionPoolHolder.getConnection();
                PreparedStatement prepStatement = connection.prepareStatement(GET_ADDRESS)) {

            prepStatement.setString(1, address.getCity());
            prepStatement.setString(2, address.getStreet());
            prepStatement.setString(3, address.getHouse());
            prepStatement.setString(4, address.getApartment());
            ResultSet rs = prepStatement.executeQuery();
            if (rs.next()){
                addressFromDb = Optional.of(addressMapper.extractFromResultSet(rs));
            }

        }catch (Exception e) {
            throw new DataBaseFetchException();
        }
        return addressFromDb;
    }

    @Override
    public void create(Address entity)
            throws DataBaseSaveException {

            try (Connection connection = ConnectionPoolHolder.getConnection();
                    PreparedStatement prepStatement = connection.prepareStatement(SAVE_ADDRESS)) {

                prepStatement.setString(1, entity.getCity());
                prepStatement.setString(2, entity.getStreet());
                prepStatement.setString(3, entity.getHouse());
                prepStatement.setString(4, entity.getApartment());
                prepStatement.execute();

            }catch (Exception e) {
                throw new DataBaseSaveException();
            }
    }

    @Override
    public Optional<Address> findById(int id) throws DataBaseFetchException {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public List<Address> findAll() {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void update(Address entity) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
