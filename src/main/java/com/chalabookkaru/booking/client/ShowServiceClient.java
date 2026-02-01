package com.chalabookkaru.booking.client;

import com.chalabookkaru.booking.exception.BookingException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ShowServiceClient {


    private final RestTemplate restTemplate= new RestTemplate();
    private final String showsURL = "http://localhost:8083/shows";

    public void validateShows(Long showId) {
        try {
            restTemplate.getForObject(showsURL + "/" + showId, Object.class);
        }catch (Exception e){
            throw new BookingException("Unable to communicate with Show MS", HttpStatus.NOT_FOUND);
        }
    }
}