package com.chalabookkaru.booking.controller;

import com.chalabookkaru.booking.dto.BookingRequest;
import com.chalabookkaru.booking.dto.BookingResponse;
import com.chalabookkaru.booking.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/request")
    public ResponseEntity<BookingResponse> createBooking(@Valid @RequestBody BookingRequest bookingRequest) {

        BookingResponse response = bookingService.bookTicket(bookingRequest);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
