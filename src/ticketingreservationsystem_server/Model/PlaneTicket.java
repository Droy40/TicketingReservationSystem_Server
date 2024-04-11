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
    public static int seatCount = 0;
    private FlightSchedule flightSchedule;
    private String seat;

    public PlaneTicket() {
        super();
        this.seat = "";
    }

    public PlaneTicket(FlightSchedule flightSchedule, String seat, String id, double ticketPrice, Passenger passenger) {
        super(id, ticketPrice, passenger);
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
    
//Request tiket pesawat : "CARI-TIKET-PESAWAT~DATE/MONTH/YEAR~FROM~TO~ADULT~CHILDREN~INFANT~SEATCLASS"
    // RESPONSE JIKA TIKET DITEMUKAN : "TIKET-PESAWAT-DITEMUKAN~TIKET1(FLIGHTNUMBER,DATE/MONTH/YEAR,FROM,TO,SEATCLASS,AIRLINE,PRICE)~TIKET2~TIKET SETERUSNYA"
    // RESPONSE JIKA TIKET TIDAK DITEMUKAN : "TIKET-PESAWAT-TIDAK-DITEMUKAN"
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
    
    public static PlaneTicket CariTicket(String id){
        for (Ticket ticket : Data.Tickets) {
            if(ticket.getId().equals(id)){
                return (PlaneTicket)ticket;
            }
        }
        return null;
    }
    
    public static int GenerateSeat(){
        return seatCount++;
    }
    
    
}
