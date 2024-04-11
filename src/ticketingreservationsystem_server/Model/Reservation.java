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
    private String id;
    private User user;
    private Date createdDate;
    private ArrayList<Ticket> ticketList;

    public Reservation() {
        this.id = "";
        this.user = null;
        this.ticketList = new ArrayList<Ticket>();
        this.createdDate = new Date();
    }

    public Reservation(String id,User user, ArrayList<Ticket> ticketList) {
        this.id = id;
        this.user = user;
        this.ticketList = ticketList;
        this.createdDate = new Date();       
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
