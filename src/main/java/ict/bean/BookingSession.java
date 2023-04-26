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
public class BookingSession implements Serializable {
    private Booking booking;
    private Venue venue;
    private int session_time;
    private String session_date;
    private int check_in, check_out;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public int getSession_time() {
        return session_time;
    }

    public void setSession_time(int session_time) {
        this.session_time = session_time;
    }

    public String getSession_date() {
        return session_date;
    }

    public void setSession_date(String session_date) {
        this.session_date = session_date;
    }

    public int getCheck_in() {
        return check_in;
    }

    public void setCheck_in(int check_in) {
        this.check_in = check_in;
    }

    public int getCheck_out() {
        return check_out;
    }

    public void setCheck_out(int check_out) {
        this.check_out = check_out;
    }

    public BookingSession(Booking booking, Venue venue, int session_time, String session_date, int check_in, int check_out) {
        this.booking = booking;
        this.venue = venue;
        this.session_time = session_time;
        this.session_date = session_date;
        this.check_in = check_in;
        this.check_out = check_out;
    }
}
