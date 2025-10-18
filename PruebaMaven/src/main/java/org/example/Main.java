package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        Connection myconn = null;
        Statement myStamt = null;
        ResultSet myRes = null;


        myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");

        myStamt = myconn.createStatement();

        myRes = myStamt.executeQuery("SELECT * FROM employees");
        while (myRes.next()){
            System.out.println(myRes.getString("first_name"));
        }

    }
}