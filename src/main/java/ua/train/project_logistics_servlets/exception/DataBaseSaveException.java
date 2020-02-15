package ua.train.project_logistics_servlets.exception;

import static ua.train.project_logistics_servlets.constant.ErrorConstant.DATABASE_SAVING_ISSUE;

public class DataBaseSaveException extends Exception {
    private static final String message = DATABASE_SAVING_ISSUE;

    public DataBaseSaveException() {
    }

    @Override
    public String toString() {
        return message;
    }
}
