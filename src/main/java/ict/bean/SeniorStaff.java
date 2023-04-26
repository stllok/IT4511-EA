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
public class SeniorStaff implements Serializable, BaseRole {

    private int id;
    private String username, password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SeniorStaff() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SeniorStaff(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean isPasswordMatch(String inputPassword) {
        return (inputPassword == null ? false : inputPassword.equals(password));
    }

    @Override
    public boolean isAdmin() {
        return true;
    }

    @Override
    public boolean isSuperadmin() {
        return true;
    }
}
