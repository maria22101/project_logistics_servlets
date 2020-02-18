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
    private Connection connection;
    private AddressMapper addressMapper = new AddressMapper();
    private static final Logger LOGGER = LogManager.getLogger(JDBCAddressDao.class);

    private static final String GET_ADDRESS = "SELECT * FROM addresses WHERE " +
            "city=? AND street=? AND house=? AND apartment=?";

    private static final String SAVE_ADDRESS = "INSERT INTO addresses " +
            "(city, street, house, apartment)" + " VALUES(?, ?, ?, ?)";

    public JDBCAddressDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Address> findAddress(String city,
                                         String street,
                                         String house,
                                         String apartment)
            throws DataBaseFetchException {

        Optional<Address> address = Optional.empty();

        try (PreparedStatement prepStatement = connection.prepareStatement(GET_ADDRESS)) {

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
    public void create(Address entity)
            throws DataBaseSaveException {

        LOGGER.info("Inside JDBCAddressDao...");
        LOGGER.info("Inside create()...");

            try (PreparedStatement prepStatement = connection.prepareStatement(SAVE_ADDRESS)) {

                LOGGER.info("Entered inside try block...");
                LOGGER.info("city passing to DB={}", entity.getCity());
                LOGGER.info("street passing to DB={}", entity.getStreet());
                LOGGER.info("house passing to DB={}", entity.getHouse());
                LOGGER.info("apartment passing to DB={}", entity.getApartment());

                prepStatement.setString(1, entity.getCity());
                prepStatement.setString(2, entity.getStreet());
                prepStatement.setString(3, entity.getHouse());
                prepStatement.setString(4, entity.getApartment());
                prepStatement.execute();

                LOGGER.info("after executing prepStatement");

            }catch (Exception e) {
                throw new DataBaseSaveException();
            }
    }

    @Override
    public Address findById(int id) {
        return null;
    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public void update(Address entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
