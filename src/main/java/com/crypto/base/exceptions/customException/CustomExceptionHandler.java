package com.crypto.base.exceptions.customException;

import com.crypto.base.dto.RestResponse;
import com.crypto.base.exceptions.AdminSaveError;
import com.crypto.base.exceptions.BusinessException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public final ResponseEntity<Object> handleNotFoundException(ChangeSetPersister.NotFoundException ex, WebRequest request) {
        RestResponse<GenericErrorMessage> response = new RestResponse<>();
        response=getGenericErrorMessageRestResponse(ex,request);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);

    }


    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request){

        RestResponse<GenericErrorMessage>
                genericErrorMessageRestResponse = getGenericErrorMessageRestResponse(e, request);
        return new ResponseEntity<>(genericErrorMessageRestResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleBusinessExceptions(BusinessException e, WebRequest request){
        RestResponse<GenericErrorMessage>
                genericErrorMessageRestResponse = getGenericErrorMessageRestResponse(e, request);
        return new ResponseEntity<>(genericErrorMessageRestResponse, HttpStatus.NOT_FOUND);
    }

    private static RestResponse<GenericErrorMessage> getGenericErrorMessageRestResponse(BusinessException e,
                                                                                        WebRequest request) {
        String message = e.getErrorMessage().getMessage();
        String description = request.getDescription(false);

        GenericErrorMessage genericErrorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);
        RestResponse<GenericErrorMessage> genericErrorMessageRestResponse = RestResponse.error(genericErrorMessage);
        return genericErrorMessageRestResponse;
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleNoSuchElementExceptions(NoSuchElementException e, WebRequest request){
        RestResponse<GenericErrorMessage> genericErrorMessageRestResponse = getGenericErrorMessageRestResponse(e, request);
        return new ResponseEntity<>(genericErrorMessageRestResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAdminSaveError(AdminSaveError e, WebRequest request){
        RestResponse<GenericErrorMessage> genericErrorMessageRestResponse = getGenericErrorMessageRestResponse(e, request);
        return new ResponseEntity<>(genericErrorMessageRestResponse, HttpStatus.FORBIDDEN);
    }


    private RestResponse<GenericErrorMessage> getGenericErrorMessageRestResponse(Exception e, WebRequest request) {
        String message = e.getMessage();
        String description = request.getDescription(false);

        GenericErrorMessage genericErrorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);
        RestResponse<GenericErrorMessage> genericErrorMessageRestResponse = RestResponse.error(genericErrorMessage);
        return genericErrorMessageRestResponse;
    }
}