package ua.train.project_logistics_servlets.persistence.dao.mapper;

import ua.train.project_logistics_servlets.persistence.domain.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AddressMapperByIntId {
    private PreparedStatement preparedStatement;
    private String idColumnName;

    public AddressMapperByIntId(PreparedStatement preparedStatement,
                                String idColumnName) {
        this.preparedStatement = preparedStatement;
        this.idColumnName = idColumnName;
    }

    public Optional<Address> extractFromResultSet(ResultSet rs, AddressMapper addressMapper)
            throws SQLException {

        Optional<Address> address = Optional.empty();

        preparedStatement.setInt(1, rs.getInt(idColumnName));

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            address = Optional.of(addressMapper.extractFromResultSet(resultSet));
        }

        return address;
    }
}
