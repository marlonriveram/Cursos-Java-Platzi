package org.example.main;

import org.example.Repository.EmployeeRepository;
import org.example.Repository.IRepository;
import org.example.model.Employees;
import org.example.util.DataBaseConnection;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {



                /**
                 * Usamos la interfaz IRepository como tipo de dato para la variable 'repository'.
                 * Esto permite que el código sea más flexible y fácil de mantener, porque podemos cambiar la implementación
                 * (por ejemplo, usar otra clase que también implemente IRepository) sin modificar el resto del código.
                 * En este caso, EmployeeRepository implementa IRepository<Employees>, así que podemos instanciarlo así.
                 * Es una buena práctica en Java programar para la interfaz y no para la implementación.
                 *
                 */
                IRepository<Employees> repository = new EmployeeRepository();

               System.out.println("-----Lista Todos -------------------");

               repository.findAll().forEach(System.out::println);

                // System.out.println(repository.getById(3));

                //System.out.println("----- Inserte un employee ----------");

                Employees employee = new Employees();
                employee.setFirst_name("Yeranys");
                employee.setPa_surname("Gutierrez");
                employee.setMa_surname("Correa");
                employee.setEmail("yera@mail.com");
                employee.setSalary(1000000F);

                 // repository.save(employee);
                // repository.update(1,employee);

               // repository.delete(7);


               // System.out.println("-----Lista Final-----------------");

                //repository.findAll().forEach(System.out::println);






    }
}