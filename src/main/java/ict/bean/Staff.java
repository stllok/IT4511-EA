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
public class Staff implements Serializable, BaseRole {

    private int id;
    private String username, password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Staff(int id, String username, String password) {
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
        return false;
    }
}
