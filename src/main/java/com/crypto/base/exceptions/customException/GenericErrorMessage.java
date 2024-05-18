package com.crypto.base.exceptions.customException;


import java.time.LocalDateTime;

public record GenericErrorMessage(LocalDateTime localDateTime, String message, String description) {

}