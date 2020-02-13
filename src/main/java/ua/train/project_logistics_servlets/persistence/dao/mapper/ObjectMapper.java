package ua.train.project_logistics_servlets.persistence.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

//TODO - does makeUnique() indeed required?
public interface ObjectMapper<T> {

    T extractFromResultSet(ResultSet rs) throws SQLException;

//    T makeUnique(Map<Integer, T> cache, T entity);
}
