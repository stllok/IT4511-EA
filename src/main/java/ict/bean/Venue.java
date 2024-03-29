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
public class Venue implements Serializable {

    public int getBookingFee() {
        return bookingFee;
    }

    public void setBookingFee(int bookingFee) {
        this.bookingFee = bookingFee;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    private int id, bookingFee;
    private String img, name, type, capacity, location, description;
    private boolean ListOnBookingSystem;

    public boolean isListOnBookingSystem() {
        return ListOnBookingSystem;
    }

    public void setListOnBookingSystem(boolean ListOnBookingSystem) {
        this.ListOnBookingSystem = ListOnBookingSystem;
    }

    public Venue(int id, int bookingFee, String img, String name, String type, String capacity, String location, String description, boolean ListOnBookingSystem) {
        this.id = id;
        this.bookingFee = bookingFee;
        this.img = img;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.location = location;
        this.description = description;
        this.ListOnBookingSystem = ListOnBookingSystem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Venue() {
        this.ListOnBookingSystem = false;
    }
}
