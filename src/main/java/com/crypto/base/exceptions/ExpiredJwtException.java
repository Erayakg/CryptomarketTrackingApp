package com.crypto.base.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ExpiredJwtException extends BusinessException{
    public ExpiredJwtException(BaseErrorMessage errorMessage) {
        super(errorMessage);
    }
}
