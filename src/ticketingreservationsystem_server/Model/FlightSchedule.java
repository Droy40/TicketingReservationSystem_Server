/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketingreservationsystem_server.Model;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class FlightSchedule {
    private Airline airline;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private Date departureDate;
    private Date arrivalDate;
    private String seatClass;

    public FlightSchedule() {
        this.airline = new Airline();
        this.departureAirport = new Airport();
        this.arrivalAirport = new Airport();
        this.departureDate = new Date();
        this.arrivalDate = new Date();
        this.seatClass = "";
    }

    public FlightSchedule(Airline airline, Airport departureAirport, Airport arrivalAirport, Date departureDate, Date arrivalDate, String seatClass) {
        this.airline = airline;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.seatClass = seatClass;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }
    
    
    
    
    
}
