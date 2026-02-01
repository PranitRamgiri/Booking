package com.chalabookkaru.booking.service;

import com.chalabookkaru.booking.client.MovieServiceClient;
import com.chalabookkaru.booking.client.ShowServiceClient;
import com.chalabookkaru.booking.dto.BookingRequest;
import com.chalabookkaru.booking.dto.BookingResponse;
import com.chalabookkaru.booking.dto.MovieResponse;
import com.chalabookkaru.booking.dto.ShowResponse;
import com.chalabookkaru.booking.entity.Booking;
import com.chalabookkaru.booking.entity.Status;
import com.chalabookkaru.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private MovieServiceClient movieServiceClient;

    @Autowired
    private ShowServiceClient showServiceClient;

    @Override
    public BookingResponse bookTicket(BookingRequest bookingRequest) {

        MovieResponse movieResponse = movieServiceClient.validateMovie(bookingRequest.getMovieId());
        ShowResponse showResponse = showServiceClient.validateShow(bookingRequest.getShowId());

        Booking booking = new Booking();
        booking.setMovieId(movieResponse.getMovieId());
        booking.setShowId(showResponse.getShowId());
        booking.setSeatCount(bookingRequest.getSeatCount());
        booking.setUserId(bookingRequest.getUserId());
        booking.setBookedAt(LocalDateTime.now());
        booking.setStatus(Status.CONFIRMED);

        Booking booked = bookingRepository.save(booking);

        return new BookingResponse(booked.getBookingId(),
                booked.getStatus().toString(), "Ticket Booked Successfully");
    }
}
