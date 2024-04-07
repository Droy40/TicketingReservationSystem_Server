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
public class User {
    private int id;
    private String fullname;
    private String username;
    private String Password;
    private String Email;
    private Date dob;
    private Date member_since;
    private ArrayList<Reservation> reservationList;

    public User(int id, String fullname, String username, String Password, String Email, Date dob, Date member_since) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.Password = Password;
        this.Email = Email;
        this.dob = dob;
        this.member_since = member_since;     
        this.reservationList = new ArrayList<Reservation>();       
    }
    
    public User(){
        this.id = 0;
        this.fullname = "";
        this.username = "";
        this.Password = "";
        this.Email = "";
        this.dob = new Date();
        this.member_since = new Date();  
        this.reservationList = new ArrayList<Reservation>();
    }
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getMember_since() {
        return member_since;
    }

    public void setMember_since(Date member_since) {
        this.member_since = member_since;
    }
    
    public ArrayList<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(ArrayList<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
    //login request message = "LOGIN~username~password"
    //login sukses response message = "LOGIN-SUKSES~UserID~Userfullname~Userusername~Useremail~Userdob(dd-mm-yyyy)~Usermembersince(dd-mm-yy)" 
    //login gagal response message  = "LOGIN-GAGAL"
    public static String UserLogin(String Username, String Password){
        for (User user : Data.Users) {
            if(user.getUsername().equals(Username) && user.getPassword().equals(Password)){
                String[] messages = {"LOGIN-SUKSES",String.valueOf(user.getId()), user.getFullname() , user.getUsername(), user.getEmail(), user.getDob().getDate() + "/" + user.getDob().getMonth() + "/" + user.getDob().getYear(),user.getMember_since().getDate() + "/" + user.getMember_since().getMonth() + "/" + user.getMember_since().getYear()};
                return String.join( "~", messages);
            }
        }
        return "LOGIN-GAGAL";
    }
    
    
    @Override
    public String toString(){
        return "Fullname : " + this.getFullname() + 
               "\nUsername : " + this.getUsername() + 
               "\nEmail : " + this.getEmail() + 
               "\nDate of Birth : " + this.getDob() + 
               "\nMember Since : " + this.getMember_since() + 
               "\n";
    }

   

}
