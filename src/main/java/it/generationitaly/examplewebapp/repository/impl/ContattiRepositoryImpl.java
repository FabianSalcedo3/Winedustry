package it.generationitaly.examplewebapp.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.generationitaly.examplewebapp.entity.Contatti;
import it.generationitaly.examplewebapp.entity.Studente;
import it.generationitaly.examplewebapp.repository.ContattiRepository;

public class ContattiRepositoryImpl implements ContattiRepository {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");

	@Override
	public Contatti findById(int id) {
		Contatti contatti = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			contatti = em.find(Contatti.class, id);
			tx.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			if (tx != null && tx.isActive())
				tx.rollback();
		} finally {
			if (em != null)
				em.close();
		}
		return contatti;
	}

	@Override
	public List<Contatti> findAll() {
		List<Contatti> contatti = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			contatti = em.createQuery("from Contatti", Contatti.class).getResultList();
			tx.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			if (tx != null && tx.isActive())
				tx.rollback();
		} finally {
			if (em != null)
				em.close();
		}
		return contatti;
	}

	@Override
	public void save(Contatti contatto) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.persist(contatto);
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
