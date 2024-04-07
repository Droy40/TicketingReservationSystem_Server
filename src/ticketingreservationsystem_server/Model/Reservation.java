/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketingreservationsystem_server.Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Reservation {
    private User user;
    private Date createdDate;
    private Date updatedDate;   
    private ArrayList<Ticket> ticketList;

    public Reservation() {
        this.user = null;
        this.ticketList = new ArrayList<Ticket>();
        this.createdDate = new Date(0,0,0);
        this.updatedDate = new Date(0,0,0);
    }

    public Reservation(User user, Ticket ticket, int quantity, Date createdDate, Date updatedDate) {
        this.user = user;
        this.ticketList = new ArrayList<Ticket>();
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }    
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicket(ArrayList<Ticket> ticketList) {
        this.ticketList = ticketList;
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
    
    
}
