package com.my.database;

public class ConnectionBuilderFactory {
    public static ConnectionBuilder getConnectionBuilder() {
        return new SimpleConnectionBuilder();
    }
}
