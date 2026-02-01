package com.chalabookkaru.booking.exception;

import org.springframework.http.HttpStatus;

public class BookingException extends RuntimeException{

    private HttpStatus httpStatus;

    public BookingException(String message, HttpStatus status) {
        super(message);
        this.httpStatus = status;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
