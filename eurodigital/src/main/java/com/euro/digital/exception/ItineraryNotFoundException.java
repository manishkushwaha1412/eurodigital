package com.euro.digital.exception;

import com.euro.digital.dto.ExceptionVO;

/**
 * {@link ItineraryNotFoundException} is the class used to construct generic itinerary exception response
 * If API has to throw Itinerary Not found exception then API should use this class to throw the same
 *
 * @author MKushwaha
 */
public class ItineraryNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private ExceptionVO exceptionVO;

    private String message;

    public ItineraryNotFoundException() {

    }

    public ItineraryNotFoundException(String message) {
        this.message = message;
    }

    public ItineraryNotFoundException(ExceptionVO exceptionVO) {
        this.exceptionVO = exceptionVO;
    }

    public ExceptionVO getExceptionVO() {
        return exceptionVO;
    }

    public void setExceptionVO(ExceptionVO exceptionVO) {
        this.exceptionVO = exceptionVO;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
