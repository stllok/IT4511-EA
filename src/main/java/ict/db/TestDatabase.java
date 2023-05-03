/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ict.db;

import ict.bean.VenueMember;
import ict.bean.SeniorStaff;
import ict.bean.Staff;
import ict.bean.Venue;
import java.util.ArrayList;

/**
 *
 * @author kelvinleung
 */
public class TestDatabase {

    private static ArrayList<VenueMember> ms = new ArrayList<>();
    private static int ms_idx = 4;
    private static ArrayList<Staff> ss = new ArrayList<>();
    private static int ss_idx = 4;
    private static ArrayList<SeniorStaff> sss = new ArrayList<>();
    private static int sss_idx = 4;
    private static ArrayList<Venue> vs = new ArrayList<>();
    private static int vs_idx = 2;

    public ArrayList<VenueMember> getMembers() {
        return ms;
    }

    public ArrayList<Staff> getStaffs() {
        return ss;
    }

    public ArrayList<SeniorStaff> getSeniorStaffs() {
        return sss;
    }

    public ArrayList<Venue> getVenues() {
        return vs;
    }

    public VenueMember getMember(String username) {
        for (VenueMember m : getMembers()) {
            if (m.getUsername().equals(username)) {
                return m;
            }
        }
        return null;
    }

    public VenueMember getMember(int id) {
        for (VenueMember m : getMembers()) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public Venue getVenue(int id) {
        for (Venue v : getVenues()) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    public Staff getStaff(String username) {
        for (Staff s : getStaffs()) {
            if (s.getUsername().equals(username)) {
                return s;
            }
        }
        return null;
    }

    public SeniorStaff getSeniorStaff(String username) {
        for (SeniorStaff ss : getSeniorStaffs()) {
            if (ss.getUsername().equals(username)) {
                return ss;
            }
        }
        return null;
    }

    public void addMember(String username, String password, String name) {
        ms.add(new VenueMember(ms_idx++, username, name, password));
    }

    public void removeMember(int id) {
        for (int i = 0; i < ms.size(); i++) {
            if (ms.get(i).getId() == id) {
                ms.remove(i);
                return;
            }
        }
    }

    public void removeVenue(int id) {
        for (int i = 0; i < vs.size(); i++) {
            if (vs.get(i).getId() == id) {
                vs.remove(i);
                return;
            }
        }
    }

    public void addVenue(int bookingFee, String img, String name, String type, String capacity, String location, String description, boolean ListOnBookingSystem) {
        vs.add(new Venue(vs_idx++, bookingFee, img, name, type, capacity, location, description, ListOnBookingSystem));
    }

    public boolean addStaff(String username, String password) {
        return true;
    }

    public TestDatabase() {
        if (ms.isEmpty()) {
            ms.add(new VenueMember(1, "username1", "name1", "123"));
            ms.add(new VenueMember(2, "username2", "name2", "234"));
            ms.add(new VenueMember(3, "username3", "name3", "345"));
        }
        if (ss.isEmpty()) {
            ss.add(new Staff(1, "staff1", "123"));
            ss.add(new Staff(2, "staff2", "234"));
            ss.add(new Staff(3, "staff3", "345"));
        }
        if (sss.isEmpty()) {
            sss.add(new SeniorStaff(1, "seniorstaff1", "123"));
            sss.add(new SeniorStaff(2, "seniorstaff2", "234"));
            sss.add(new SeniorStaff(3, "seniorstaff3", "345"));
        }
        if (vs.isEmpty()) {
            vs.add(new Venue(1, 72, "sample image", "TKO Venue", "bicycle", "700m x 700m", "Tseung Kwan O", "A new generation venue built in 2013", true));
        }
    }
}
