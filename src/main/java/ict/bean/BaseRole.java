/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ict.bean;

/**
 *
 * @author kelvinleung
 */
public interface BaseRole {
    public boolean isPasswordMatch(String inputPassword);
    public boolean isAdmin();
    public boolean isSuperadmin();
}
