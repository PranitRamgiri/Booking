package com.chalabookkaru.booking.client;

import com.chalabookkaru.booking.dto.ShowResponse;
import com.chalabookkaru.booking.exception.BookingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Component
public class ShowServiceClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public ShowResponse validateShow(Long showId) {
        try {
            ResponseEntity<ShowResponse> response = restTemplate.getForEntity(
                    "http://localhost:8083/shows/{showId}",
                    ShowResponse.class,
                    showId
            );
            return response.getBody();

        } catch (HttpClientErrorException.NotFound ex) {
            throw new BookingException("Show not found for given showId", HttpStatus.NOT_FOUND);
        } catch (ResourceAccessException ex) {
            throw new BookingException("Show service is unavailable", HttpStatus.SERVICE_UNAVAILABLE);
        } catch (Exception ex) {
            throw new BookingException("Unable to communicate with ShowMS", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
