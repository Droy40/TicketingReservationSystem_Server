/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketingreservationsystem_server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import ticketingreservationsystem_server.Model.PlaneTicket;
import ticketingreservationsystem_server.Model.User;

/**
 *
 * @author Lenovo
 */
public class SocketController extends Thread{
    public static ArrayList<SocketController> clients;
    private Socket clientSocket;
    private BufferedReader in;
    private DataOutputStream out;

    public SocketController(Socket clientSocket) {
        try {
            this.clientSocket = clientSocket;
            this.in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
            this.out = new DataOutputStream(this.clientSocket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(SocketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void SendMessageToClient(String Message){
        try {
            if(Message.contains("\n")){
                out.writeBytes(Message);            
            }
            else{
                out.writeBytes(Message + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(SocketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ListeningClient(){
        try {
            String messageFromClient = this.in.readLine();
            String[] messages = messageFromClient.split("~");
            String MessageToClient;
            String[] departure;
            Date departureDate;
            switch (messages[0]) {
                case "LOGIN":
                    MessageToClient = User.UserLogin(messages[1], messages[2]);
                    SendMessageToClient(MessageToClient);
                    break;
                case "REGISTER":
                    String[] dob = messages[4].split("/");
                    Date dobDate = new Date(Integer.parseInt(dob[2]), Integer.parseInt(dob[1]), Integer.parseInt(dob[0]));
                    MessageToClient = User.UserRegister(messages[1], messages[2], messages[3], dobDate, messages[5]);
                    SendMessageToClient(MessageToClient);
                    break;
                case "CARI-TIKET-PESAWAT":
                    String[] departrure = messages[1].split("/");
                    departureDate = new Date(Integer.parseInt(departrure[2]),Integer.parseInt(departrure[1]) , Integer.parseInt(departrure[0]));
                    MessageToClient = PlaneTicket.CariTiketPesawat(departureDate, messages[2], messages[3], messages[4], messages[5], messages[6], messages[7]);
                    SendMessageToClient(MessageToClient);
                    break;
                case "CARI-TIKET-KAPAL":
                    departrure = messages[1].split("/");
                    departureDate = new Date(Integer.parseInt(departrure[2]),Integer.parseInt(departrure[1]) , Integer.parseInt(departrure[0]));
                    MessageToClient = PlaneTicket.CariTiketPesawat(departureDate, messages[2], messages[3], messages[4], messages[5], messages[6], messages[7]);
                    SendMessageToClient(MessageToClient);
                    break;
                case "CARI-TIKET-KERETA":
                    departrure = messages[1].split("/");
                    departureDate = new Date(Integer.parseInt(departrure[2]),Integer.parseInt(departrure[1]) , Integer.parseInt(departrure[0]));
                    MessageToClient = PlaneTicket.CariTiketPesawat(departureDate, messages[2], messages[3], messages[4], messages[5], messages[6], messages[7]);
                    SendMessageToClient(MessageToClient);
                    break;                    
                case "CARI-SEWA-MOBIL":
                    break;
                default:
                    throw new AssertionError();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(SocketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while(true){
            ListeningClient();
        }
    }
    
    
}
