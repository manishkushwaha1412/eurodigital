package com.euro.digital.controller;

import com.euro.digital.utility.ConverterService;
import com.euro.digital.dto.FlightVO;
import com.euro.digital.dto.StatusVO;
import com.euro.digital.helper.StatusHelper;
import com.euro.digital.model.Itinerary;
import com.euro.digital.service.StatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Class StatusController: This is controller class and APIs will hit this class when invoked.
 * This API have /api/v1/ as root path and this class have multiple methods like
 * Find All flight /api/v1/flights/all
 * Flight Flight by departure date and flight number /api/v1/flights? query parameter
 *
 * @author MKushwaha
 */

@RestController
@RequestMapping("/api/v1")
public class StatusController {

    Logger logger = LoggerFactory.getLogger(StatusController.class);

    @Autowired
    private StatusService statusService;

    @Autowired
    private ConverterService converterService;

    @Autowired
    private StatusHelper statusHelper;


    /**
     * Function is used to search all flights
     *
     * @return List<Itinerary>
     */
    @GetMapping("/flights/all")
    public List<Itinerary> findAllItineraries() {
        return statusService.getAllItineraries();
    }

    /**
     * This function is used to get flight by flight Id
     *
     * @param id {@link Long}
     * @return FlightVO
     */
    @GetMapping("/flights/{id}")
    public FlightVO findItineraryById(@PathVariable("id") Long id) {
        return converterService.convertFlightToVO(statusService.getItineraryById(id));
    }

    /**
     * This function is used to get flight by departure date and flight number
     * If departure date and flight number is not present in request, it will throw validation message
     * If flight number and departure date is null in request, it will throw validation message
     * Flight Number should be  digit like 123, 0001 or 0010 etc.
     * Flight Departure date must be dd-MM-yyyy format like 23-01-2022
     *
     * @param flightNumb {@link Optional<String>}
     * @param depDate    {@link Optional<String>}
     * @return ResponseEntity<Object>
     */
    @GetMapping("/flights/status")
    public ResponseEntity<Object> findItineraryByDateAndNumber(@RequestParam("flightNumber") Optional<String> flightNumb,
                                                               @RequestParam("departureDate") Optional<String> depDate) {

        String flightNumber = flightNumb.isPresent() && !flightNumb.get().equals("") ? flightNumb.get() : null;
        String departureDate = depDate.isPresent() && !depDate.get().equals("") ? depDate.get() : null;
        logger.info("API - /flight?flightNumber={} & departureDate={} is called ", flightNumber, departureDate);
        return statusHelper.validateAndFindResult(flightNumber, departureDate);

    }

    /**
     * This function is used to get flight by departure date and flight number
     * If departure date and flight number is not present in request, it will throw validation message
     * If flight number and departure date is null in request, it will throw validation message
     * Flight Number should be  digit like 123, 0001 or 0010 etc.
     * Flight Departure date must be dd-MM-yyyy format like 23-01-2022
     *
     * @param statusVO {@link StatusVO}
     * @return ResponseEntity<Object>
     */
    @PostMapping("/status")
    public ResponseEntity<Object> findItineraryByNumberAndDate(@RequestBody StatusVO statusVO) {
        logger.info("API - /flights/status is called with StatusVO {} ", statusVO);
        return statusHelper.validateAndFindResult(statusVO.getFlightNumber(), statusVO.getDepartureDate());
    }

}
