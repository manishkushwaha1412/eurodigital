package com.euro.digital.service;

import com.euro.digital.model.Itinerary;
import com.euro.digital.repository.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class {@link StatusServiceImpl} is used to implement all service methods which will serve business needs
 *
 * @author MKushwaha
 */

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    ItineraryRepository itineraryRepository;

    /**
     * Function is used to get Itinerary based on Id
     * @param id {@link Long}
     * @return Itinerary
     */
    @Override
    public Itinerary getItineraryById(Long id) {
        Optional<Itinerary> itineraryOptional = itineraryRepository.findById(id);
        return itineraryOptional.orElse(null);
    }

    /**
     * Function is used to get all Itineraries
     * @return List<Itinerary>
     */
    @Override
    public List<Itinerary> getAllItineraries() {
        List<Itinerary> itineraries = new ArrayList<>();
        itineraryRepository.findAll().forEach(itineraries::add);
        return itineraries;
    }

    /**
     * Function is used to get Itinerary based on number and date
     * @param number {@link String}
     * @param date {@link String}
     * @return Itinerary
     */
    @Override
    public Itinerary getFlightByNumberAndDate(String number, String date) {
        return itineraryRepository.fetchItineraryByDepartureDateAndNumber(number, date);
    }


}
