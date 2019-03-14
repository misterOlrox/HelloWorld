package com.my.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.NamingException;
import com.my.data.connect.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            doLogin();
        }
        catch (SQLException ex) {
            return "error";
        } catch (NamingException e) {
            e.printStackTrace();
        }
        if (registrationDate==null)
            return "newUser";
        else
            return "oldUser";
    }

    public void doLogin() throws SQLException, NamingException {
        Connection conn = DatabaseConnector.getConnection();
        if (conn == null) throw new SQLException("No connection");
        try {
            PreparedStatement query = conn.prepareStatement(
                    "SELECT registration_date from Users WHERE first_name = ? AND last_name = ?");
            query.setString(1, firstName);
            query.setString(2, lastName);
            ResultSet result = query.executeQuery();
            if (!result.next()){
                registrationDate = null;
                PreparedStatement statement = conn.prepareStatement("INSERT INTO Users VALUES(?,?,NOW())");
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                statement.addBatch();
                statement.execute();
                return;
            }
            else
                registrationDate = result.getString(1);
        }
        finally {
            conn.close();
        }
    }
}