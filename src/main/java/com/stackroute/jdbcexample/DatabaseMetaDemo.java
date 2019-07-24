package com.stackroute.jdbcexample;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseMetaDemo {
    private Connection connection;
    public void getMetaData()throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Employee", "root", "Root@123");
            DatabaseMetaData dbmd = connection.getMetaData();
//gives information about the driver and database
            System.out.println("Driver Name: " + dbmd.getDriverName());
            System.out.println("Driver Version: " + dbmd.getDriverVersion());
            System.out.println("UserName: " + dbmd.getUserName());
            System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
            System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}