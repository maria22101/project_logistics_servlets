package ua.train.project_logistics_servlets.exception;

import static ua.train.project_logistics_servlets.constant.TextConstants.EXCEPTION_USER_NOT_FOUND;

public class UserNotFoundException extends Exception{
    private static final String MESSAGE = EXCEPTION_USER_NOT_FOUND;

    public UserNotFoundException() {
    }

    @Override
    public String toString() {
        return MESSAGE;
    }
}
