package org.example.Entity;

import javax.persistence.*;

@Entity  // Le Indica al jpa que esta clase es una tabla de nuestra DB

@Table (name = "employees") // Le indica al jpa el nombre que tendera la clase
public class Employee {
    @Id // Le indica al jpa cual es el id

    // Le inca al jpa que el id es auto incremental con la strategy -> IDENTITY
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name") // Le indica al jpa que nombre debe tener la columna
    private String firstName;
    @Column(name = "pa_surname")
    private String paSurname;
    @Column(name = "ma_surname")
    private String maSurname;
    private String email;
    private Float salary;

    public Employee() {
    }

    public Employee(String email, String firstName, String maSurname, String paSurname, Float salary) {

        this.firstName = firstName;
        this.paSurname = paSurname;
        this.maSurname = maSurname;
        this.email = email;
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSurname() {
        return maSurname;
    }

    public void setMaSurname(String maSurname) {
        this.maSurname = maSurname;
    }

    public String getPaSurname() {
        return paSurname;
    }

    public void setPaSurname(String paSurname) {
        this.paSurname = paSurname;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "email='" + email + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", paSurname='" + paSurname + '\'' +
                ", maSurname='" + maSurname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
