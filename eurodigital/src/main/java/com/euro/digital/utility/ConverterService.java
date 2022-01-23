package com.euro.digital.utility;

import com.euro.digital.dto.ExceptionVO;
import com.euro.digital.dto.FlightVO;
import com.euro.digital.dto.StatusVO;
import com.euro.digital.model.Itinerary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Class {@link ConverterService} is used to convert Model to DO and vice versa
 *
 * @author MKushwaha
 */

@Service
public class ConverterService {

    /**
     * Fucntion is used to flight model to VO, accept Itinerary as Model and return Flight VO
     * @param itinerary {@link Itinerary}
     * @return FlightVO
     */
    public  FlightVO convertFlightToVO(Itinerary itinerary){
        FlightVO flightVO = new FlightVO();
        flightVO.setFlight(itinerary.getPrefix() + " " +itinerary.getFlintNumber());
        flightVO.setArrivalDateTime(itinerary.getArrivalDate() + " on "+itinerary.getArrivalTime());
        flightVO.setDepartureDateTime(itinerary.getDepartureDate() + " on " + itinerary.getDepartureTime());
        flightVO.setRoute(itinerary.getRoute());
        if(StatusEnum.DL.getStatus().equalsIgnoreCase(itinerary.getStatus())) {
            flightVO.setStatus(StatusEnum.DL.getStatus());
        }else{
            flightVO.setStatus(StatusEnum.OT.getStatus());
        }
        return flightVO;
    }

    /**
     * Function is used to construct Exception VO from validation message and Status VO
     * @param statusVO {@link StatusVO}
     * @param message {@link String}
     * @return ExceptionVO
     */
    public ExceptionVO translateToExceptionVO(StatusVO statusVO, String message){
        ExceptionVO exceptionVO = new ExceptionVO();
        exceptionVO.setMessage(message);
        exceptionVO.setStatus(HttpStatus.NOT_FOUND.toString());
        exceptionVO.setRequest(statusVO);
        return exceptionVO;
    }
}
