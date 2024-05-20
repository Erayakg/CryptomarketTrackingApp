package com.crypto.base.constant;

import com.crypto.base.exceptions.BaseErrorMessage;

public enum UserErrorMessage implements BaseErrorMessage {

    NOT_FOUND("User not found!"),
    REQUEST_FAILED("User request is not null !!"),
    USER_SAVE_FAILED("User save failed!"),
    USER_UPDATE_FAILED("User update failed!"),
    USER_NOT_ADMIN("You do not have permission to register as an admin "), USER_DELETE_FAILED("User delete failed!"),;


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
