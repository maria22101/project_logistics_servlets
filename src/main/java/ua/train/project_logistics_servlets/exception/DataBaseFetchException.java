package ua.train.project_logistics_servlets.exception;

import static ua.train.project_logistics_servlets.constant.ErrorConstant.DATABASE_FETCH_ISSUE;

public class DataBaseFetchException extends Exception {
    private static final String message = DATABASE_FETCH_ISSUE;

    public DataBaseFetchException() {
    }

    @Override
    public String toString() {
        return message;
    }
}
