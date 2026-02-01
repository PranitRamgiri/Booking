package com.chalabookkaru.booking.dto;

import jakarta.validation.constraints.NotNull;

public class BookingRequest {

    @NotNull(message = "Please provide userId")
    private Long userId;
    @NotNull(message = "Please provide movieId")
    private Long movieId;
    @NotNull(message = "Please provide showId")
    private Long showId;
    @NotNull(message = "Please provide seatCount")
    private int seatCount;

    public Long getUserId() {
        return userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public Long getShowId() {
        return showId;
    }

    public int getSeatCount() {
        return seatCount;
    }
}
