package com.chalabookkaru.booking.client;

import com.chalabookkaru.booking.dto.MovieResponse;
import com.chalabookkaru.booking.exception.BookingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieServiceClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public MovieResponse validateMovie(Long movieId) {
        try {
            ResponseEntity<MovieResponse> response = restTemplate.getForEntity(
                    "http://localhost:8082/movies/{movieId}",
                    MovieResponse.class,
                    movieId
            );
            return response.getBody();

        } catch (HttpClientErrorException ex) {
            throw new BookingException("Movie not found for given movieId", HttpStatus.NOT_FOUND);
        } catch (ResourceAccessException ex) {
            throw new BookingException("Movie service is unavailable", HttpStatus.SERVICE_UNAVAILABLE);
        } catch (Exception ex) {
            throw new BookingException("Unable to communicate with MovieMS", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
