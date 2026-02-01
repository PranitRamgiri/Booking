package com.chalabookkaru.booking.service;

import com.chalabookkaru.booking.client.MovieServiceClient;
import com.chalabookkaru.booking.client.ShowServiceClient;
import com.chalabookkaru.booking.dto.BookingRequest;
import com.chalabookkaru.booking.dto.BookingResponse;
import com.chalabookkaru.booking.entity.BookingEntity;
import com.chalabookkaru.booking.entity.Status;
import com.chalabookkaru.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private MovieServiceClient movieServiceClient;

    @Autowired
    private ShowServiceClient showServiceClient;

    @Override
    public BookingResponse bookTicket(BookingRequest bookingRequest) {

        movieServiceClient.validateMovie(bookingRequest.getMovieId());
        showServiceClient.validateShows(bookingRequest.getShowId());

        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setMovieId(bookingRequest.getMovieId());
        bookingEntity.setShowId(bookingRequest.getShowId());
        bookingEntity.setSeatCount(bookingRequest.getSeatCount());
        bookingEntity.setUserId(bookingRequest.getUserId());
        bookingEntity.setBookedAt(LocalDateTime.now());
        bookingEntity.setStatus(Status.CONFIRMED);
        BookingEntity booked = bookingRepository.save(bookingEntity);

        return new BookingResponse(booked.getBookingId(),
                booked.getStatus().toString(),"Ticket Booked Successfully");
    }


}
