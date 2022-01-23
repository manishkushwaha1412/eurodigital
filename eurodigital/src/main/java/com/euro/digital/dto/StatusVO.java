package com.euro.digital.dto;

/**
 * {@link StatusVO} class is used to get flight number and departure date
 * as input request in flight status query. App will construct this object and send as part if header
 *
 * @author MKushwaha
 */
public class StatusVO {

    private String flightNumber;
    private String departureDate;

    public StatusVO() {
    }

    public StatusVO(String flightNumber, String departureDate) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }
}
