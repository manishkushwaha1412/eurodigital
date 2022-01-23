package com.euro.digital.service;

import com.euro.digital.model.Itinerary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interface {@link StatusService} have all service will be used by Implementation and server the business needs
 *
 * @author MKushwaha
 */

@Service
public interface StatusService {

    Itinerary getItineraryById(Long id);

    List<Itinerary> getAllItineraries();

    Itinerary getFlightByNumberAndDate(String number, String date);

}
