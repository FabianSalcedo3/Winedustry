package it.generationitaly.examplewebapp.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.generationitaly.examplewebapp.entity.Esame;
import it.generationitaly.examplewebapp.repository.EsameRepository;

public class EsameRepositoryImpl implements EsameRepository {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
	
	@Override
	public void add(Esame esame) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.persist(esame);
			tx.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			if (tx != null && tx.isActive())
				tx.rollback();
		} finally {
			if (em != null)
				em.close();
		}
		
	}

}
