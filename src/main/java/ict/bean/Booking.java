/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ict.bean;

import java.io.Serializable;

/**
 *
 * @author kelvinleung
 */
public class Booking implements Serializable {
    private String date, time;
    private Guest[] guests;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Guest[] getGuests() {
        return guests;
    }

    public void setGuests(Guest[] guests) {
        this.guests = guests;
    }

    public Booking(String date, String time, Guest[] guests) {
        this.date = date;
        this.time = time;
        this.guests = guests;
    }

    public Booking() {
    }
}
