package ua.train.project_logistics_servlets.persistence.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;
import ua.train.project_logistics_servlets.persistence.dao.AddressDao;
import ua.train.project_logistics_servlets.persistence.dao.mapper.AddressMapper;
import ua.train.project_logistics_servlets.persistence.domain.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class JDBCAddressDao implements AddressDao {
    private AddressMapper addressMapper = new AddressMapper();
    private static final Logger LOGGER = LogManager.getLogger(JDBCAddressDao.class);

    private static final String SAVE_ADDRESS = "INSERT INTO addresses " +
            "(city, street, house, apartment)" + " VALUES(?, ?, ?, ?)";

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
    public Optional<Address> findById(int id) {
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
