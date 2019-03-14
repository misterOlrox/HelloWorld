package com.my.bean;

import com.my.database.DatabaseHelper;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.SQLException;

@ManagedBean
@SessionScoped
public class WelcomeBean {
    private String firstName;
    private String lastName;
    private String registrationDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String submit() {
        try {
            DatabaseHelper helper = new DatabaseHelper();
            registrationDate = helper.getRegDateByName(firstName, lastName);
            if (registrationDate == null) {
                helper.createNewUser(firstName, lastName);
                return "newUser";
            } else {
                return "oldUser";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "error";
        }
    }
}