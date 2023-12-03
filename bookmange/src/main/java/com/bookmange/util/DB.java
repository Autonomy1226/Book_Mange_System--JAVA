package com.bookmange.util;

import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class DB {
    static String ip;
    static int port=3036;
    static String db;
    static String username;
    static String password;
    static String encoding;

    static {
        ResourceBundle resource = ResourceBundle.getBundle("database", Locale.getDefault());
        ip = resource.getString("host");
        db = resource.getString("database");
        username = resource.getString("username");
        password = resource.getString("password");
        encoding = resource.getString("encoding");

    }
    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s/%s?characterEncoding=%s&useSSL=false", ip, db, encoding);
        return DriverManager.getConnection(url, username, password);
    }
}

