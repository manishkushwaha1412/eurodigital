package com.euro.digital.repository;

import com.euro.digital.model.Itinerary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Interface {@link ItineraryRepository} act as Repository which will interact with DB
 * This class have API written ti get flight based on Flight number and departure date
 *
 * @author MKushwaha
 */

@Repository
public interface ItineraryRepository extends CrudRepository<Itinerary, Long> {


    @Query("Select itinerary from Itinerary itinerary where itinerary.flintNumber=:flintNumber and itinerary.departureDate=:departureDate")
    Itinerary fetchItineraryByDepartureDateAndNumber(@Param("flintNumber") String flintNumber, @Param("departureDate") String departureDate);

}
