package Conexion_DB;

import java.sql.*;

public class ConexionDB {

    // 🔹 Variables de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/project"; // cambia "project" por tu BD
    private static final String USER = "root";
    private static final String PASSWORD = "";


    private Connection myConn = null;
    private Statement myStamt = null;
    private PreparedStatement myPreStament = null;
    private ResultSet myRes = null;

    public ConexionDB() {
        try {
            //Conexión a la DB
            myConn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Conexión exitosa");
        }catch (Exception e){
            System.out.println("Error al conectarse a la base de datos ✖️");
            e.getStackTrace();
        }
    }

    // Lectura de datos
    public void select () {
        try {
            // Permite enviar consultas sql sencillas sin parametros
            myStamt = myConn.createStatement();

            String sql = "SELECT * FROM employees";
            // Permite hacer la consulta sql y enviarela y retorna la respuesta en un objeto
            myRes = myStamt.executeQuery(sql);

            while (myRes.next()){ // Recorre las filas de la respuesta de myRes

                // getString toma el valor de la columna que se le indique
                System.out.println(myRes.getString("first_name"));
            }
        }catch (Exception e){
            System.out.println("Error en la consulta");
            e.getStackTrace();
        }
    }


    // Inserción de datos
    public void insert ( ){
        try {
            String sql = "INSERT INTO employees (first_name,pa_surname) VALUES (?,?)";

            //Permite mandar consultas sql con parametros INSERT/DELETE/UPDATE
            myPreStament = myConn.prepareStatement(sql);

            // setString permite añadir los valores para el prepareStatement
            myPreStament.setString(1,"Yeranys");
            myPreStament.setString(2,"Gutierrez");

            int rowAffeted = myPreStament.executeUpdate();

            while (rowAffeted > 0 ){
                System.out.println("Se ha creado un nuevo empleado");
                break;
            }
        }catch (Exception e){
            System.out.println("Algo salio mal en la consulta");
            e.getStackTrace();
        }
    }

    // Actualización de datos

    public void update ()  {
        try {
            myStamt = myConn.createStatement();

            String sql = "UPDATE employees " + "set email= 'yeranys@example.com' " + "WHERE first_name = 'Yeranys'";
            int rowAffected = myStamt.executeUpdate(sql);

            System.out.println();

            myRes = myStamt.executeQuery("SELECT * FROM `employees` ORDER BY `first_name`");

            while (myRes.next()){

                System.out.println(myRes.getString("first_name") + "," + myRes.getString("email"));
            }

        }catch (Exception e) {
            e.getStackTrace();
        }

    }

    public void delete () throws SQLException {

        String sql = "DELETE FROM employees "
                    + "WHERE id = ?";

        myPreStament = myConn.prepareStatement(sql);

        myPreStament.setString(1,"6");

        int rowAffeted = myPreStament.executeUpdate();

        while (rowAffeted > 0){
            System.out.println("Se ha eliminado un registro");
            return;
        }
    }
}
