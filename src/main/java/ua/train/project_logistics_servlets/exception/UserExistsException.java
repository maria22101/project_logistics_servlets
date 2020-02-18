package ua.train.project_logistics_servlets.exception;

import static ua.train.project_logistics_servlets.constant.ErrorConstant.EXCEPTION_USER_EXISTS;

public class UserExistsException extends Exception {
    private static final String MESSAGE = EXCEPTION_USER_EXISTS;

    public UserExistsException() {
    }

    @Override
    public String toString() {
        return MESSAGE;
    }
}
