package com.crypto.base.exceptions;

import com.crypto.base.dto.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotfoundException extends BusinessException{
    public NotfoundException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
