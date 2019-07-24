package com.stackroute.jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTransactionDemo {
  private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/Employee";
  private static final String DB_USER = "root";
  private static final String DB_PASSWORD = "Root@123";

  public void transactionDemo() throws SQLException, ClassNotFoundException {
    Class.forName(DB_DRIVER);
    Connection dbConnection = null;
    PreparedStatement preparedStatementInsert = null;
    PreparedStatement preparedStatementUpdate = null;

    String insertTableSQL = "INSERT INTO employee"
      + "(id, name, age, gender) VALUES"
      + "(?,?,?,?)";

    try {
      dbConnection = getDBConnection();

      dbConnection.setAutoCommit(false);

      preparedStatementInsert = dbConnection.prepareStatement(insertTableSQL);
      preparedStatementInsert.setInt(1, 9);
      preparedStatementInsert.setString(2, "rahul");
      preparedStatementInsert.setInt(3, 12);
      preparedStatementInsert.setString(4,"male" );

      preparedStatementInsert.executeUpdate();

      dbConnection.commit();

      System.out.println("Done!");

    } catch (SQLException e) {

      System.out.println(e.getMessage());
      dbConnection.rollback();

    } finally {

      if (preparedStatementInsert != null) {
        preparedStatementInsert.close();
      }

      if (preparedStatementUpdate != null) {
        preparedStatementUpdate.close();
      }

      if (dbConnection != null) {
        dbConnection.close();
      }

    }

  }

  private static Connection getDBConnection() {

    Connection dbConnection = null;

    try {

      Class.forName(DB_DRIVER);

    } catch (ClassNotFoundException e) {

      System.out.println(e.getMessage());

    }

    try {

      dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
        DB_PASSWORD);
      return dbConnection;

    } catch (SQLException e) {

      System.out.println(e.getMessage());

    }

    return dbConnection;

  }



}
