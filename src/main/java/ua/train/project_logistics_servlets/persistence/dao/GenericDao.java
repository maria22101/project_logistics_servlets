package ua.train.project_logistics_servlets.persistence.dao;

import ua.train.project_logistics_servlets.exception.DataBaseFetchException;
import ua.train.project_logistics_servlets.exception.DataBaseSaveException;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {
    void create (T entity) throws DataBaseSaveException;
    Optional<T> findById(int id) throws DataBaseFetchException;
    List<T> findAll() throws DataBaseFetchException;
    void update(T entity);
    void delete(int id);
}
