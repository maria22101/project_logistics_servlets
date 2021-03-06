package ua.train.project_logistics_servlets.persistence.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ObjectMapper<T> {
    T extractFromResultSet(ResultSet rs) throws SQLException;
}
