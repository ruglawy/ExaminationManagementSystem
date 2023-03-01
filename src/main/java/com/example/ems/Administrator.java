/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ems;

/**
 *
 * @author Kareem
 */
public class Administrator extends Person {
    public Administrator(String username, String password, String name, String mobileNumber, String emailAddress){
        super(username, password, name, mobileNumber, emailAddress, "admin");
    }
}
