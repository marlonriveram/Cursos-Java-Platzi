package org.example.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilEntity {

    // Nos abre las puertas a nuestra DB
    private static final EntityManagerFactory entitiManagerFactory = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory(){
        // "mypersistenceUnit" debe coincidir con el nombre definido en el archivo persistence.xml
        return Persistence.createEntityManagerFactory("mypersistenceUnit");
    }

    // 🔹 Método público para obtener un EntityManager listo para usar
    public static EntityManager getEntityManager(){
        return entitiManagerFactory.createEntityManager();
    }
}
