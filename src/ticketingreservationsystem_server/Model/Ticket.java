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
public class Ticket {
    public static int idCount = 0;
    private String id;
    private double ticketPrice;
    private Date createdDate;
//    private Date updatedDate;
    private Passenger passenger;
    
    
    public Ticket() {
        this.id = "";
        this.ticketPrice = 0;
        this.createdDate = new Date();
//        this.updatedDate = new Date(); 
        this.passenger = new Passenger();
    }

    public Ticket(String id, double ticketPrice,  Passenger passenger) {
        this.id = id;
        this.ticketPrice = ticketPrice;
        this.createdDate = new Date();
//        this.updatedDate = updatedDate;
        this.passenger = new Passenger(passenger.getPassengerType(),passenger.getTitle(), passenger.getFirstMiddleName(), passenger.getFamilyName(), passenger.getDob(), passenger.getNationality());
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public Date getUpdatedDate() {
//        return updatedDate;
//    }
//
//    public void setUpdatedDate(Date updatedDate) {
//        this.updatedDate = updatedDate;
//    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    
    public static int GenerateID(){
        return idCount++;
    }


    
}
