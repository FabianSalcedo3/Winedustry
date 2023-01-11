package it.generationitaly.examplewebapp.repository;

import java.util.List;

import it.generationitaly.examplewebapp.entity.Corso;

public interface CorsoRepository {
	List<Corso> findAll();

	void save(Corso corso);

	void update(Corso corso);
	
	Corso findById(int id);
}
