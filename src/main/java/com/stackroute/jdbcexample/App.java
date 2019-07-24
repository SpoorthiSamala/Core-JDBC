package com.stackroute.jdbcexample;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws Exception {
        EmployeeDemo emp=new EmployeeDemo();
        emp.getEmployeeDetails();
        System.out.println();
        //to print details in reverse order
        emp.getEmployeeDetailsInReverseOrder();
        System.out.println();
        //to print employee details from second row in reverse
        emp.getEmployeeDetailsFromSecondRowInReverse();
        System.out.println();
        //to print name and gender of an employee
        emp.getEmployeeDetailsByNameAndGender("teju","female");
        System.out.println();
        //creating an object for databasemetademo class
        DatabaseMetaDemo databaseMetaDemo=new DatabaseMetaDemo();
        databaseMetaDemo.getMetaData();
        System.out.println();
        //creating an object and accesing ResultMetaDataDemo class
        ResulSetMetaDataDemo resulSetMetaDataDemo=new ResulSetMetaDataDemo();
        resulSetMetaDataDemo.resultMetaData();
        System.out.println();
        //creating an object and accessing RowSetDemo class
        RowSetDemo rowSetDemo=new RowSetDemo();
        rowSetDemo.rowSetDemo();
        System.out.println();
        //creating an object and accessing JdbcTransactionDemo class
        JdbcTransactionDemo jdbcTransactionDemo=new JdbcTransactionDemo();
        jdbcTransactionDemo.transactionDemo();
        //creating an object and accessing JDBCBatchDemo class
        JDBCBatchDemo jdbcBatchDemo=new JDBCBatchDemo();
        jdbcBatchDemo.addBatch();

    }
}