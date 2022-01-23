package com.euro.digital.dto;

/**
 * {@link FlightVO} class is used to holds flight related data like flight, departure/arrival date status
 * This class will be returned when API response is success and APP will get this structure as response
 * from API
 *
 * @author MKushwaha
 */

public class FlightVO {
    private String flight;
    private String departureDateTime;
    private String arrivalDateTime;
    private String route;
    private String status;


    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FlightVO{" +
                "flight='" + flight + '\'' +
                ", departureDateTime='" + departureDateTime + '\'' +
                ", arrivalDateTime='" + arrivalDateTime + '\'' +
                ", route='" + route + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
