/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketingreservationsystem_server.Model;

/**
 *
 * @author Lenovo
 */
public class Airport {
    private String name;
    private String city;
    private String country;
    private String airportCode;

    public Airport() {
        this.name = "";
        this.city = "";
        this.country = "";
        this.airportCode = "";
    }

    public Airport(String name, String city, String country, String airportCode) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.airportCode = airportCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }
    
    
    
    
    
}
