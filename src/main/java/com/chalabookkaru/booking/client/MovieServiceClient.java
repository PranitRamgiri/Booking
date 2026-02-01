package com.chalabookkaru.booking.client;

import com.chalabookkaru.booking.exception.BookingException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieServiceClient {

    private final RestTemplate restTemplate= new RestTemplate();
    private final String moviesURL = "http://localhost:8082/movies";

    public void validateMovie(Long movieId) {
        try {
            restTemplate.getForObject(moviesURL + "/" + movieId, Object.class);
        }catch (Exception e){
            throw new BookingException("Unable to communicate with Movie MS", HttpStatus.NOT_FOUND);
        }
    }
}
