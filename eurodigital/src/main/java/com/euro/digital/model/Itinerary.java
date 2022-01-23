package com.euro.digital.model;

import javax.persistence.*;

/**
 * this is Model class which used to hold Itinerary data
 *
 * @author MKushwaha
 */

@Entity
@Table(name = "FLT_DETAILS")
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fltId;

    @Column(name = "FLT_NUMBER")
    private String flintNumber;

    @Column(name = "FLT_SUFFIX")
    private String suffix;

    @Column(name = "FLT_PREFIX")
    private String prefix;

    @Column(name = "FLT_SCH_DEP_DATE")
    private String departureDate;

    @Column(name = "FLT_SCH_DEP_TIME")
    private String departureTime;

    @Column(name = "FLT_ACT_DEP_DATE")
    private String departureActualDate;

    @Column(name = "FLT_ACT_DEP_TIME")
    private String departureActualTime;

    @Column(name = "FLT_SCH_ARR_DATE")
    private String arrivalDate;

    @Column(name = "FLT_SCH_ARR_TIME")
    private String arrivalTime;

    @Column(name = "FLT_ACT_ARR_DATE")
    private String arrivalActualDate;

    @Column(name = "FLT_ACT_ARR_TIME")
    private String arrivalActualTime;

    @Column(name = "FLT_ROUTE")
    private String route;

    @Column(name = "FLT_STATUS")
    private String status;

    public String getFlintNumber() {
        return flintNumber;
    }

    public void setFlintNumber(String flintNumber) {
        this.flintNumber = flintNumber;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureActualDate() {
        return departureActualDate;
    }

    public void setDepartureActualDate(String departureActualDate) {
        this.departureActualDate = departureActualDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalActualDate() {
        return arrivalActualDate;
    }

    public void setArrivalActualDate(String arrivalActualDate) {
        this.arrivalActualDate = arrivalActualDate;
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

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureActualTime() {
        return departureActualTime;
    }

    public void setDepartureActualTime(String departureActualTime) {
        this.departureActualTime = departureActualTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Itinerary{" +
                "fltId=" + fltId +
                ", flintNumber='" + flintNumber + '\'' +
                ", suffix='" + suffix + '\'' +
                ", prefix='" + prefix + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", departureActualDate='" + departureActualDate + '\'' +
                ", departureActualTime='" + departureActualTime + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", arrivalActualDate='" + arrivalActualDate + '\'' +
                ", arrivalActualTime='" + arrivalActualTime + '\'' +
                ", route='" + route + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalActualTime() {
        return arrivalActualTime;
    }

    public void setArrivalActualTime(String arrivalActualTime) {
        this.arrivalActualTime = arrivalActualTime;
    }

    public Long getFltId() {
        return fltId;
    }

    public void setFltId(Long flightId) {
        this.fltId = flightId;
    }

}
