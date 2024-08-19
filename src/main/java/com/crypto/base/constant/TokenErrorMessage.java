package com.crypto.base.constant;

import com.crypto.base.exceptions.BaseErrorMessage;

public enum TokenErrorMessage implements BaseErrorMessage {

    TOKEN_EXPIRED_MESSAGE("Token has expired."),;

    private String message;

    TokenErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "TokenErrorMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
