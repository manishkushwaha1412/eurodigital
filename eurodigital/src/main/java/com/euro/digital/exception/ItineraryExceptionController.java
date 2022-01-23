package com.euro.digital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * {@link ItineraryExceptionController} is a Advice which will be invoked in any exception occurs.
 * This class will use {@link ItineraryNotFoundException} and message passed by the API will be used
 * here to construct generic exception response
 *
 * @author MKushwaha
 */
@ControllerAdvice
public class ItineraryExceptionController {

    @ExceptionHandler(value = ItineraryNotFoundException.class)
    public ResponseEntity<Object> exception(ItineraryNotFoundException exception) {
        if (exception.getMessage() != null) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } else if (exception.getExceptionVO() != null) {
            return new ResponseEntity<>(exception.getExceptionVO(), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>("Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
