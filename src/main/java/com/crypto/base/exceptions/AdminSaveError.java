package com.crypto.base.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class AdminSaveError extends BusinessException{
    public AdminSaveError(BaseErrorMessage errorMessage) {
        super(errorMessage);
    }
}
