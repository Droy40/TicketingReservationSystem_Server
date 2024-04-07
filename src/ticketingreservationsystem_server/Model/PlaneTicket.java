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
public class PlaneTicket extends Ticket {
    private FlightSchedule flightSchedule;
    private String seat;

    public PlaneTicket() {
        super();
        this.seat = "";
    }

    public PlaneTicket(FlightSchedule flightSchedule, String seat, int id, String name, String desc, Date ticketDate, double ticketPrice, Date createdDate, Date updatedDate, Passenger passenger) {
        super(id, name, desc, ticketDate, ticketPrice, createdDate, updatedDate, passenger);
        this.flightSchedule = flightSchedule;
        this.seat = seat;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }    

    public FlightSchedule getFlightSchedule() {
        return flightSchedule;
    }

    public void setFlightSchedule(FlightSchedule flightSchedule) {
        this.flightSchedule = flightSchedule;
    }
    
    
    
    
}
