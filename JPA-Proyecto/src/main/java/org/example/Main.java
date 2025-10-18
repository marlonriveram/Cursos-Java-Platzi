package org.example;

import org.example.Entity.Employee;
import org.example.util.UtilEntity;

import javax.persistence.EntityManager;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Permite hacer las operaciones de persistencia
        EntityManager em = UtilEntity.getEntityManager();

        System.out.println("------ Lista ------------------");
        List<Employee> employees = em.createQuery("SELECT e FROM Employee e",Employee.class).getResultList();

        employees.forEach(System.out::println);




        System.out.println("--------- Encontrar uno");

        int empleadoId = 3;
        Employee empleado = em.find(Employee.class,empleadoId);

        System.out.println("Empleado encontrado: " + empleado);




        System.out.println("------- Creación -------------");

        Employee nuevoEmpleado = new Employee("carlos@mail.com","carlos","cano","restrepo",1450000F);

        /*Iniciamos una transacción.

        Esto le dice a JPA que vamos a realizar una acción que cambia la base de datos
        (insertar, actualizar o borrar)
         */
        em.getTransaction().begin();

        /*
         Le decimos a JPA que queremos guardar este nuevo empleado en la base de datos.
         Aún no se guarda físicamente, solo se prepara el cambio.
         */
        em.persist(nuevoEmpleado);
        em.getTransaction().commit();

        System.out.println("Nuevo empleado creado: " + nuevoEmpleado);





        System.out.println("------------ Actualizar --------------");

        int employeToUpdateId = 2;
        Employee employeeToUpdate = em.find(Employee.class,employeToUpdateId);

        System.out.println("Empleado a modificar: " + employeeToUpdate);

        employeeToUpdate.setFirstName("Pepito");
        employeeToUpdate.setPaSurname("Perez");
        employeeToUpdate.setEmail("pepito@mail.com");

        /*
        em.getTransaction().begin();
        em.merge(employeeToUpdate);
        em.getTransaction().commit();
        */

        System.out.println("Empleado actualizado: " + employeeToUpdate);


        System.out.println("----------- Eliminación -------------------");

        int employeeToDeleteId = 2;

        Employee employeeToDelete = em.find(Employee.class,employeeToDeleteId);

        System.out.println("Empleado eliminado: " + employeeToDelete);

        /*
        em.getTransaction().begin();
        em.remove(employeeToDelete);
        em.getTransaction().commit();
        em.close(); //  cerrar la conexión a la DB

         */



    }
}