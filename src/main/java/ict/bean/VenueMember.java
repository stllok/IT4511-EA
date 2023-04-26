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
public class VenueMember implements Serializable, BaseRole {

    private int id;
    private String username, name, password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public VenueMember() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VenueMember(int id, String username, String name, String password) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
    }

    @Override
    public boolean isPasswordMatch(String inputPassword) {
        return (inputPassword == null ? false : inputPassword.equals(password));
    }

    @Override
    public boolean isAdmin() {
        return false;
    }

    @Override
    public boolean isSuperadmin() {
        return false;
    }
}
