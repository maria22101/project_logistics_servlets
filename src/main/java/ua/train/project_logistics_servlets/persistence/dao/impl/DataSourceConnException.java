package ua.train.project_logistics_servlets.persistence.dao.impl;

public class DataSourceConnException extends Exception {
    public DataSourceConnException(Throwable cause) {
        super(cause);
    }
    public DataSourceConnException(String message, Throwable cause) {
        super(message, cause);
    }
}
