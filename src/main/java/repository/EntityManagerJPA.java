package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class EntityManagerJPA {

    public EntityManager getEntityManager(String persistence) {
        return Persistence.createEntityManagerFactory(persistence).createEntityManager();
    }

}
