package com.my.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHelper {
    private final static String SQL_SELECT_REG_DATE =
            "SELECT registration_date from Users WHERE first_name = ? AND last_name = ?";
    private final static String SQL_INSERT_NEW_USER =
            "INSERT INTO Users VALUES(?,?,NOW())";

    private ConnectionBuilder connectionBuilder = ConnectionBuilderFactory.getConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return connectionBuilder.getConnection();
    }

    public String getRegDateByName(String firstName, String lastName) throws SQLException {
        Connection con = getConnection();
        PreparedStatement query = con.prepareStatement(SQL_SELECT_REG_DATE);
        query.setString(1, firstName);
        query.setString(2, lastName);
        ResultSet result = query.executeQuery();
        if (!result.next()) {
            return null;
        } else {
            return result.getString(1);
        }
    }

    public void createNewUser(String firstName, String lastName) throws SQLException {
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement(SQL_INSERT_NEW_USER);
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.addBatch();
        statement.execute();
    }
}
