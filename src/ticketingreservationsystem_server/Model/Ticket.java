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
    
    private int id;
    private String name;
    private String desc;
    private double ticketPrice;
    private Date createdDate;
    private Date updatedDate;
    private Passenger passenger;
    
    
    public Ticket() {
        this.id = 0;
        this.name = "";
        this.desc = "";
        this.ticketPrice = 0;
        this.createdDate = new Date();
        this.updatedDate = new Date(); 
        this.passenger = new Passenger();
    }

    public Ticket(int id, String name, String desc, Date ticketDate, double ticketPrice, Date createdDate, Date updatedDate, Passenger passenger) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.ticketPrice = ticketPrice;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.passenger = new Passenger(passenger.getTitle(), passenger.getFirstMiddleName(), passenger.getFamilyName(), passenger.getDob(), passenger.getNationality());
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    


    
}
