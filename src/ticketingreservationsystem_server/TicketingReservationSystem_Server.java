/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ticketingreservationsystem_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import ticketingreservationsystem_server.Model.FlightSchedule;
import ticketingreservationsystem_server.Model.User;

/**
 *
 * @author Lenovo
 */
public class TicketingReservationSystem_Server extends Thread{

    /**
     * @param args the command line arguments
     */
    
    private ServerSocket serverSocket;
    
    public TicketingReservationSystem_Server(){
        try {            
            serverSocket = new ServerSocket(11111);
            this.start();
        } catch (IOException ex) {
            Logger.getLogger(TicketingReservationSystem_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static void main(String[] args) {
        IntantiateAllArrayList();
        AddData();
        new TicketingReservationSystem_Server();
    }
    
    public static void IntantiateAllArrayList(){
        SocketController.clients = new ArrayList<SocketController>();
        
        Data.Users = new ArrayList<>();
        Data.Tickets = new  ArrayList<>();
        Data.Reservations = new ArrayList<>();
        Data.FlightSchedules = new ArrayList<>();
    }
    
    public static void AddData(){
        String[] FullNames = new String[]{
            "Aharon Guerner",
            "Mariska Bernardeschi",
            "Yehudit Cabera",
            "Rich Golthorpp",
            "Theodoric Sawyer",
            "Emery Collingridge",
            "Fidela Gerardet",
            "Arte De Lisle",
            "Irwinn Shernock",
            "Stearne Nowlan"
        };
        String[] usernames = new String[]{
            "kelfleet0",
            "khorick1",
            "cneilan2",
            "dklesel3",
            "fkinghorne4",
            "bbeer5",
            "mranvoise6",
            "lvicar7",
            "rcorkell8",
            "sbatalle9"
        };
        
        String[] passwords = new String[]{
            "2725",
            "9158",
            "5480",
            "1683",
            "2713",
            "5402",
            "5575",
            "2166",
            "8899",
            "1883"
        };
        String[] emails = new String[]{
            "sgirth0@furl.net",
            "acymper1@forbes.com",
            "mtrevor2@msn.com",
            "tcalderon3@digg.com",
            "ggrebbin4@booking.com",
            "rhugk5@amazon.de",
            "eschwier6@wikimedia.org",
            "dtrustrie7@homestead.com",
            "dmagarrell8@java.com",
            "elawes9@dot.gov"
        };

        for (int i = 0; i < FullNames.length; i++) {
            
            Data.Users.add(new User(Data.Users.size() + 1,FullNames[i],usernames[i],passwords[i],emails[i],new Date(2020-1900, 5, 10),new Date(2020-1900, 5, 10)));
        }
        
        String[] airlines = {
            "InnoZ",
            "Meemm",
            "Aimbu",
            "Yodoo",
            "Rhycero",
            "Realcube",
            "Topiczoom",
            "Jabbertype",
            "Realcube",
            "Quatz"
        };
        
        String[] departureAirports = {
        "Kurundi Airport",
        "Marion Downs Airport",
        "Hesler Noble Field",
        "Inhaminga Airport",
        "Colmar-Houssen Airport",
        "Fremont County Airport",
        "Sharpe AAF",
        "Newcastle Airport",
        "South Bimini Airport",
        "Juvenal Loureiro Cardoso Airport"
        };
        
        String[] arrivalAirports = {
        "Udon Thani Airport",
        "Dr. Antonio Nicolás Briceño Airport",
        "Likiep Airport",
        "Swansea Airport",
        "Port Bailey Seaplane Base",
        "Lethbridge County Airport",
        "Grabtsevo Airport",
        "North Fork Valley Airport",
        "Boone Municipal Airport",
        "Pauk Airport"
        };
        
        for(int i = 0; i < airlines.length; i++){
            Data.FlightSchedules.add(new FlightSchedule(String.valueOf(Data.FlightSchedules.size() + 1),airlines[i] + " Airline",departureAirports[i],arrivalAirports[i], new Date(2024-1900,3,11),"Economy",1000000));
            Data.FlightSchedules.add(new FlightSchedule(String.valueOf(Data.FlightSchedules.size() + 1),airlines[i] + " Airline2",departureAirports[i],arrivalAirports[i], new Date(2024-1900,3,11),"Economy",2000000));
            Data.FlightSchedules.add(new FlightSchedule(String.valueOf(Data.FlightSchedules.size() + 1),airlines[i] + " Airline",departureAirports[i],arrivalAirports[i], new Date(2024-1900,3,11),"Premium Economy",1000000));
            Data.FlightSchedules.add(new FlightSchedule(String.valueOf(Data.FlightSchedules.size() + 1),airlines[i] + " Airline",departureAirports[i],arrivalAirports[i], new Date(2024-1900,3,11),"Business",1000000));
            Data.FlightSchedules.add(new FlightSchedule(String.valueOf(Data.FlightSchedules.size() + 1),airlines[i] + " Airline",departureAirports[i],arrivalAirports[i], new Date(2024-1900,3,11),"First Class",1000000));
        }
        
        
        
    }

    @Override
    public void run() {
        while (true) {            
            try {
                Socket client = serverSocket.accept();
                SocketController sc = new SocketController(client); 
                SocketController.clients.add(sc);
                sc.start();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
}
