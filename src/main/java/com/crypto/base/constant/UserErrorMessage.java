package com.crypto.base.constant;

import com.crypto.base.exceptions.BaseErrorMessage;

public enum UserErrorMessage implements BaseErrorMessage {

    NOT_FOUND("User not found!"),;
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
