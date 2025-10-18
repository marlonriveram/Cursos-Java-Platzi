package org.example.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static String url = "jdbc:mysql://localhost:3306/project";
    private static String user = "root";
    private static String password = "";

    // se reemplaza por el pool
    // private static Connection myConn;

    private static BasicDataSource pool;

    /*

    Se reemplaza, la conección con Connectio por pool

    public static Connection getInstance() throws SQLException {
        if (myConn == null) {
            myConn = DriverManager.getConnection(url,user,password);
        }

        return myConn;
    }

*/

    // Se instancia el pool
    public static BasicDataSource getInstance () throws SQLException {
        if(pool == null){
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(user);
            pool.setPassword(password);

            pool.setInitialSize(3); // Tamaño pool
            pool.setMinIdle(3); // Min de conexiones activas
            pool.setMaxIdle(10); // Max de conexines activas
            pool.setMaxTotal(10); // Numero total conexiones

        }

        return pool;
    }

    // Metodo que obtendra una solo conexión de poll
    public static Connection getConnection () throws SQLException {
        return getInstance().getConnection();
    }
}

