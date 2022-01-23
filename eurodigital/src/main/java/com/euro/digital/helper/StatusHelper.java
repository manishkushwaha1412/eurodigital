package com.euro.digital.helper;

import com.euro.digital.utility.ConverterService;
import com.euro.digital.utility.ValidationUtil;
import com.euro.digital.dto.FlightVO;
import com.euro.digital.dto.StatusVO;
import com.euro.digital.exception.ItineraryNotFoundException;
import com.euro.digital.model.Itinerary;
import com.euro.digital.service.StatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Class {@link StatusHelper} is act as Helper for {@link com.euro.digital.controller.StatusController} class
 * Status Controller will delegated request to helper to call service, validate request and construct response
 *
 * @author MKushwaha
 */
@Component
public class StatusHelper {

    Logger logger = LoggerFactory.getLogger(StatusHelper.class);

    @Autowired
    private ValidationUtil validationUtil;

    @Autowired
    private ConverterService converterService;

    @Autowired
    private StatusService statusService;


    /**
     * Function us used to validate incoming request and find the data based on request
     *
     * @param flightNumber  {@link String}
     * @param departureDate {@link String}
     * @return ResponseEntity
     */
    public ResponseEntity<Object> validateAndFindResult(String flightNumber, String departureDate) {
        if (flightNumber == null || departureDate == null) {
            logger.warn("Flight Number {} and Departure Date {} has been passed which throws exception, MANDATORY FIELDS ", flightNumber, departureDate);
            throw new ItineraryNotFoundException("Flight Number and Departure date (dd-mm-yyyy) both are mandatory to search status");
        }
        validationUtil.validateStatusRequest(departureDate, flightNumber);
        Itinerary itinerary = statusService.getFlightByNumberAndDate(flightNumber, departureDate);
        return constructOutput(itinerary, new StatusVO(flightNumber, departureDate));
    }

    /**
     * Function is used to construct Itinerary response
     *
     * @param itinerary {@link Itinerary}
     * @param statusVO  {@link StatusVO}
     * @return ResponseEntity
     */
    private ResponseEntity<Object> constructOutput(Itinerary itinerary, StatusVO statusVO) {
        if (itinerary != null) {
            FlightVO flightVO = converterService.convertFlightToVO(itinerary);
            logger.info("API SUCCESS RESULT :: Flight Details {} ", flightVO);
            return new ResponseEntity<>(flightVO, HttpStatus.OK);
        } else {
            String message = "Itinerary Not found for given request";
            logger.warn("API NO DATA RESULT :: Message {} ", message);
            throw new ItineraryNotFoundException(converterService.translateToExceptionVO(statusVO, message));
        }
    }
}
