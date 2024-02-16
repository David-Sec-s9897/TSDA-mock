package com.secdavid.base_template.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(
        value = HttpStatus.BAD_REQUEST,
        reason = "DateTime format is not valid")
public class InvalidDateFormatException extends RuntimeException {
    public InvalidDateFormatException(Throwable t) {
        super(t);
    }

    public InvalidDateFormatException(String message, Throwable t) {
        super(message, t);


    }
}
