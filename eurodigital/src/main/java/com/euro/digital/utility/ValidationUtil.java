package com.euro.digital.utility;

import com.euro.digital.exception.ItineraryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Class {@link ValidationUtil} is used to validate incoming request
 * like Flight number must be 4 digit example 1234, 0001, 0010 etc
 * Flight date must be in dd-MM-yyyy format like 23-01-2022
 *
 * @author MKushwaha
 */

@Service
public class ValidationUtil {

    Logger logger = LoggerFactory.getLogger(ValidationUtil.class);

    public static final String DATE_FORMAT = "dd-MM-yyyy";

    private static final DateTimeFormatter automationDateFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

    /**
     * Function is used to validate incoming data
     * @param date {@link String}
     * @param number {@link String}
     */
    public void validateStatusRequest(String date, String number){
        String validationMessage = null;
        boolean validation = false;
        if(number == null || !number.matches("[0-9]+") || number.length()!=4){
            validationMessage = "Flight Number is not correct, please use only 4 digit and try again";
            validation = true;
        }
        try {
            String departureDate = LocalDate.parse(date, automationDateFormatter).format(DateTimeFormatter.ofPattern(DATE_FORMAT));
            logger.info("Date format is as exception in dd-MM-yyyy and value is {} ", departureDate);
        }catch(Exception e){
            validation = true;
            validationMessage = "\n Invalid Date Format, please use  dd-MM-yyyy";
            throw new ItineraryNotFoundException("Invalid Date Format, please use  dd-MM-yyyy");
        }
        if(validation){
            logger.info("INVALID DATA :: message {} ", validationMessage);
            throw new ItineraryNotFoundException(validationMessage);
        }
    }

}
