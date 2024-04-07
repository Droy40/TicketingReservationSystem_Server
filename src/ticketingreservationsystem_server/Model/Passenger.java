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
public class Passenger {
    private String title;
    private String firstMiddleName;
    private String familyName;
    private Date dob;
    private String nationality;

    public Passenger(String title, String firstMiddleName, String familyName, Date dob, String nationality) {
        this.title = title;
        this.firstMiddleName = firstMiddleName;
        this.familyName = familyName;
        this.dob = dob;
        this.nationality = nationality;
    }

    public Passenger() {
        this.title = "";
        this.firstMiddleName = "";
        this.familyName = "";
        this.dob = new Date();
        this.nationality = "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstMiddleName() {
        return firstMiddleName;
    }

    public void setFirstMiddleName(String firstMiddleName) {
        this.firstMiddleName = firstMiddleName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    
    
    
}
