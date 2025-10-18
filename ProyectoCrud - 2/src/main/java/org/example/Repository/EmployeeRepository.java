package org.example.Repository;

import org.example.model.Employees;
import org.example.util.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IRepository<Employees> {

    private Connection getConnection() throws SQLException {
        return DataBaseConnection.getConnection();
    }

    @Override
    public List<Employees> findAll() throws SQLException {
        List<Employees> employees = new ArrayList<>();

        try ( Connection myConn = getConnection();
                Statement myStamt = myConn.createStatement();
             ResultSet myRes = myStamt.executeQuery("SELECT * FROM employees");){
            while (myRes.next()){
                Employees e = createEmployee(myRes);
                employees.add(e);
            }
        }

        return employees;
    }



    @Override
    public Employees getById(Integer id) throws SQLException {
        Employees employee = null;

        try(    Connection myConn = getConnection();
                PreparedStatement myStamt = myConn.prepareStatement("SELECT * FROM employees WHERE id = ?");){
                myStamt.setInt(1,id);
                try(ResultSet myRes = myStamt.executeQuery()){
                    if(myRes.next()){
                        employee = createEmployee(myRes);
                    }
                }
        }
        return employee;
    }

    @Override
    public void save(Employees employee) throws SQLException {
        String sql = "INSERT INTO employees (first_name,pa_surname,ma_surname,email,salary) "
                        + "VALUES (?,?,?,?,?)";

            try (   Connection myConn = getConnection();
                    PreparedStatement myStamt = myConn.prepareStatement(sql);){
                myStamt.setString(1,employee.getFirst_name());
                myStamt.setString(2,employee.getPa_surname());
                myStamt.setString(3,employee.getMa_surname());
                myStamt.setString(4,employee.getEmail());
                myStamt.setFloat(5,employee.getSalary());
                myStamt.executeUpdate();
            }

    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (   Connection myCoon = getConnection();
                PreparedStatement myStamt = myCoon.prepareStatement(sql);){
            myStamt.setInt(1,id);
            myStamt.executeUpdate();
        }
    }

    @Override
    public  void update (Integer id,Employees employee) throws SQLException {
        String sql = "UPDATE employees "
                + "SET first_name = ?, pa_surname = ? ,ma_surname = ? ,email = ?, salary = ? "
                + "WHERE id = ?";
        try (   Connection myCoon = getConnection();
                PreparedStatement myStamt = myCoon.prepareStatement(sql);){
            myStamt.setString(1,employee.getFirst_name());
            myStamt.setString(2,employee.getPa_surname());
            myStamt.setString(3,employee.getMa_surname());
            myStamt.setString(4,employee.getEmail());
            myStamt.setFloat(5,employee.getSalary());
            myStamt.setInt(6,id);
            myStamt.executeUpdate();

        }
    }

    private Employees createEmployee(ResultSet myRes) throws SQLException {
        Employees e = new Employees();
        e.setId(myRes.getInt("id"));
        e.setFirst_name(myRes.getString("first_name"));
        e.setPa_surname(myRes.getString("pa_surname"));
        e.setMa_surname(myRes.getString("ma_surname"));
        e.setEmail(myRes.getString("email"));
        e.setSalary(myRes.getFloat("salary"));
        return e;
    }
}
