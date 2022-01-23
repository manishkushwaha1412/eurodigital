package com.euro.digital;

import com.euro.digital.model.Itinerary;
import org.springframework.stereotype.Component;

@Component
public class TestDataGenerator {

    public Itinerary getFlightBynNumberAndDate(){
        Itinerary itinerary = new Itinerary();
        itinerary.setArrivalDate("22-02-2022");
        itinerary.setArrivalTime("02:30");
        itinerary.setDepartureDate("22-02-2022");
        itinerary.setDepartureTime("01:00");
        itinerary.setRoute("FRA-ZRH");
        itinerary.setFlintNumber("1234");
        itinerary.setStatus("OT");
        return itinerary;
    }

}
