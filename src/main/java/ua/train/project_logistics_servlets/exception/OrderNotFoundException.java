package ua.train.project_logistics_servlets.exception;

import static ua.train.project_logistics_servlets.constant.ErrorConstant.ORDER_NOT_FOUND;

public class OrderNotFoundException extends Exception {
    private static final String message = ORDER_NOT_FOUND;

    public OrderNotFoundException() {
    }

    @Override
    public String toString() {
        return message;
    }
}
