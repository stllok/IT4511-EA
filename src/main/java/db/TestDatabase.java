/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import bean.VenueMember;
import bean.SeniorStaff;
import bean.Staff;
import java.util.ArrayList;

/**
 *
 * @author kelvinleung
 */
public class TestDatabase {

    private ArrayList<VenueMember> ms = new ArrayList<>();
    private int ms_idx = 4;
    private ArrayList<Staff> ss = new ArrayList<>();
    private ArrayList<SeniorStaff> sss = new ArrayList<>();

    public ArrayList<VenueMember> getMembers() {
        return ms;
    }

    public ArrayList<Staff> getStaffs() {
        return ss;
    }

    public ArrayList<SeniorStaff> getSeniorStaffs() {
        return sss;
    }

    public VenueMember getMember(String username, String password) {
        for (VenueMember m : getMembers()) {
            if (m.getUsername().equals(username) && m.getPassword().equals(password)) {
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

    public Staff getStaff(String username, String password) {
        for (Staff s : getStaffs()) {
            if (s.getUsername().equals(username) && s.getPassword().equals(password)) {
                return s;
            }
        }
        return null;
    }

    public boolean addMember(String username, String password, String name) {
        ms.add(new VenueMember(ms_idx++, username, name, password));
        return true;
    }

    public void removeMember(int id) {
        for (int i = 0; i < ms.size(); i++) {
            if (ms.get(i).getId() == id) {
                ms.remove(i);
                return;
            }
        }
    }

    public boolean addStaff(String username, String password) {
        return true;
    }

    public TestDatabase() {
        ms.add(new VenueMember(1, "username1", "name1", "123"));
        ms.add(new VenueMember(2, "username2", "name2", "234"));
        ms.add(new VenueMember(3, "username3", "name3", "345"));
    }
}
