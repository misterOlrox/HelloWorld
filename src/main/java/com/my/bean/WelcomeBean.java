package com.my.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.annotation.Resource;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ManagedBean
@SessionScoped
public class WelcomeBean {
    private String firstName;
    private String lastName;
    private String registrationDate;

    private Logger logger = Logger.getLogger("com.my.bean");

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
            logger.log(Level.SEVERE, "login failed", ex);
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
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/helloworld_database?useUnicode=true&serverTimezone=UTC",
                "root", "password");
        if (conn == null) throw new SQLException("No connection");
        try {
            PreparedStatement query = conn.prepareStatement(
                    "SELECT registration_date from Users WHERE first_name = ? AND last_name = ?");
            query.setString(1, firstName);
            query.setString(2, lastName);
            ResultSet result = query.executeQuery();
            if (!result.next()){
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