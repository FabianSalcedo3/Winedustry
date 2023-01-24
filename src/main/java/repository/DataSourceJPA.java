package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public abstract class DataSourceJPA<T, PK> implements InterfaceDataSourceJPA<T, PK> {

    private final Class<T> entityClass;

    private final EntityManager em = new EntityManagerJPA().getEntityManager("persistence");

    public DataSourceJPA(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T findById(PK id) {
        T entity = null;
        try {
            em.getTransaction().begin();
            entity = em.find(entityClass, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return entity;
    }

    @Override
    public List<T> findAll() {
        List<T> entities = null;
        try {
            em.getTransaction().begin();
            entities = em.createQuery("from " + entityClass.getName(), entityClass).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return entities;
    }

    @Override
    public void save(T entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(T entity) {
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(T entity) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(entity));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void deleteById(PK id) {
        try {
            em.getTransaction().begin();
            T entity = em.find(entityClass, id);
            em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public T findBySomething(String query, Object value) {
        T entities = null;
        try {
            em.getTransaction().begin();
            entities = em.createQuery("from " + entityClass.getName() + " " + query, entityClass).setParameter(1, value).getSingleResult();
            em.getTransaction().commit();
        } catch (PersistenceException persistenceException) {
            em.getTransaction().rollback();
        }
        return entities;
    }

    @Override
    public List<T> findBySomethingList(String query, Object value) {
        List<T> entities = null;
        try {
            em.getTransaction().begin();
            entities = em.createQuery("from " + entityClass.getName() + " " + query, entityClass).setParameter(1, value).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return entities;
    }

    @Override
    public List<T> findByMore(String query, int nPar, Object[] values) {
        List<T> entities = null;
        try {
            em.getTransaction().begin();
            TypedQuery<T> typedQuery = em.createQuery("from " + entityClass.getName() + " " + query, entityClass);
            for (int i = 1; i <= nPar; i++) {
                typedQuery.setParameter(i, values[i - 1]);
            }
            entities = typedQuery.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return entities;
    }

}
