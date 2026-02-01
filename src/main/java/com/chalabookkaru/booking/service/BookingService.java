package com.chalabookkaru.booking.service;

import com.chalabookkaru.booking.dto.BookingRequest;
import com.chalabookkaru.booking.dto.BookingResponse;

public interface BookingService {

    BookingResponse bookTicket(BookingRequest bookingRequest);

}
