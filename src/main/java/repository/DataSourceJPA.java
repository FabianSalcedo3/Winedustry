package repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

public abstract class DataSourceJPA<T, PK> implements InterfaceDataSourceJPA<T, PK> {

	private final Class<T> entityClass;

	public DataSourceJPA(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	private EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("persistence").createEntityManager();
	}

	@Override
	public T findById(PK id) {
		T entity = null;
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			entity = em.find(entityClass, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return entity;
	}

	@Override
	public List<T> findAll() {
		List<T> entities = null;
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			entities = em.createQuery("from " + entityClass.getName(), entityClass).getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return entities;
	}

	@Override
	public void save(T entity) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public void update(T entity) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(T entity) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.merge(entity));
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public void deleteById(PK id) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			T entity = em.find(entityClass, id);
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public List<T> findBySomethingList(String query, Object value) {
		List<T> entities = null;
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			entities = em.createQuery("from " + entityClass.getName() + " " + query, entityClass).setParameter(1, value).getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return entities;
	}

	@Override
	public List<T> findByMore(String query, int nPar, Object[] values) {
		List<T> entities = null;
		EntityManager em = getEntityManager();
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
		} finally {
			em.close();
		}
		return entities;
	}

	@Override
	public T findBySomething(String query, Object value) {
		T entities = null;
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entities = entityManager.createQuery("from " + entityClass.getName() + " " + query, entityClass).setParameter(1, value).getSingleResult();
			entityManager.getTransaction().commit();
		} catch (PersistenceException persistenceException) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
		return entities;
	}

}
