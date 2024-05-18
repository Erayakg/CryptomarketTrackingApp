package com.crypto.base.constant;

import com.crypto.base.exceptions.BaseErrorMessage;

public enum UserErrorMessage implements BaseErrorMessage {

    NOT_FOUND("User not found!"),
    REQUEST_FAILED("User request is not null !!"),
    USER_SAVE_FAILED("User save failed!"),
    USER_UPDATE_FAILED("User update failed!");
    private String message;

    UserErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "UserErrorMessage{" +
                "message='" + message + '\'' +
                '}';
    }

}
