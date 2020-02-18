package ua.train.project_logistics_servlets.persistence.dao;

import ua.train.project_logistics_servlets.exception.DataBaseSaveException;

import java.util.List;

public interface GenericDao<T> extends AutoCloseable {
    void create (T entity) throws DataBaseSaveException;
    T findById(int id);
    List<T> findAll();
    void update(T entity);
    void delete(int id);
    void close();
}
