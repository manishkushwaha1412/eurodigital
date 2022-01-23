package com.euro.digital;

import com.euro.digital.model.Itinerary;
import com.euro.digital.service.StatusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class EurodigitalApplicationTests {

	@Autowired
	private StatusService statusService;

	@Autowired
	private TestDataGenerator testDataGenerator;


	@Test
	public void getFlightByDateAndNumber(){
		Itinerary mockItinerary = testDataGenerator.getFlightBynNumberAndDate();
		Itinerary serviceItinerary = statusService.getFlightByNumberAndDate(mockItinerary.getFlintNumber(), mockItinerary.getDepartureDate());
		assertEquals(mockItinerary.getArrivalDate(), serviceItinerary.getArrivalDate());
		assertEquals(mockItinerary.getArrivalTime(), serviceItinerary.getArrivalTime());
		assertEquals(mockItinerary.getDepartureDate(), serviceItinerary.getDepartureDate());
		assertEquals(mockItinerary.getDepartureTime(), serviceItinerary.getDepartureTime());
		assertEquals(mockItinerary.getFlintNumber(), serviceItinerary.getFlintNumber());
		assertEquals(mockItinerary.getRoute(), serviceItinerary.getRoute());
		assertEquals(mockItinerary.getStatus(), serviceItinerary.getStatus());
	}
	@Test
	void contextLoads() {
	}

}
