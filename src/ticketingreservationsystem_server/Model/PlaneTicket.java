/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketingreservationsystem_server.Model;

import java.util.ArrayList;
import java.util.Date;
import ticketingreservationsystem_server.Data;

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
    
    public static String CariTiketPesawat(Date departureDate, String from, String to, String adult, String children, String infant, String seatClass){
        ArrayList<FlightSchedule> flightSchedules = new ArrayList<>();
        for (FlightSchedule flightSchedule : Data.FlightSchedules) {
            if(flightSchedule.getDepartureAirport().equals(from) &&
               flightSchedule.getArrivalAirport().equals(to) &&
                flightSchedule.getDepartureDate().equals(departureDate) && 
                    flightSchedule.getSeatClass().equals(seatClass)){
                flightSchedules.add(flightSchedule);
            }
        }
        ArrayList<String> TiketPesawats = new ArrayList<>();        
        
        for (FlightSchedule flightSchedule : flightSchedules) {
            String tiketsString =  flightSchedule.getFlightNumber() + "," + flightSchedule.getDepartureDate().getDate() + "/" + flightSchedule.getDepartureDate().getMonth() + "/" + flightSchedule.getDepartureDate().getYear() + ","
                             + from + "," + to + "," + seatClass + "," +flightSchedule.getAirline() + "," + String.valueOf(flightSchedule.getPrice());
            TiketPesawats.add(tiketsString);
        }
        
        if(!TiketPesawats.isEmpty()){
            TiketPesawats.add(0, "TIKET-PESAWAT-DITEMUKAN");
        }
        else{
             TiketPesawats.add(0, "TIKET-PESAWAT-TIDAK-DITEMUKAN");
        }
        
        String messages = String.join("~", TiketPesawats);
        
        return messages;
    }
    
    
    
    
}
