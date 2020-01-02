package com.carRental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionPool {
    public Connection con;
    public Connection getCon() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "password");
            System.out.println("connection is:"+con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

}