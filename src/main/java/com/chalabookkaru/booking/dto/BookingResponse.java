package com.chalabookkaru.booking.dto;

public class BookingResponse {

    private final Long bookingId;
    private final String status;
    private final String message;


    public BookingResponse(Long bookingId, String status, String message) {
        this.bookingId = bookingId;
        this.status = status;
        this.message = message;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
