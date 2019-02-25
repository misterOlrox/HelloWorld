package com.my.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class WelcomeBean {

    // firstName to store value entered in index.xhtml
    private String firstName;

    // lastName to store value entered in index.xhtml
    private String lastName;

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

    // method called when user clicks submit button in index.xhtml
    // It returns String as welcome. Based on this String flow gets
    // forwarded to welcome.xhtml
    public String welcomeUser() {
        return "welcome";
    }
}