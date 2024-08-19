package com.crypto.base.constant;

import com.crypto.base.exceptions.BaseErrorMessage;

public enum PortfolioErrorMessage implements BaseErrorMessage {

    PORTFOLIO_CREATE_FAILED("Portfolio create  failed!"),
    REQUEST_FAILED("Portfolio request is not null !!"), NOT_FOUND_EXCEPTIONS("Portfolio not found!"),;


    private String message;

    PortfolioErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "PortfolioErrorMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
