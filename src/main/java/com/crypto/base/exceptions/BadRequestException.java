package com.crypto.base.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends BusinessException{

    public BadRequestException(BaseErrorMessage errorMessage) {
        super(errorMessage);
    }
}
