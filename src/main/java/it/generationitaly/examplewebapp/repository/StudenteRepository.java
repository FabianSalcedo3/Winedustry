package it.generationitaly.examplewebapp.repository;

import java.util.List;

import it.generationitaly.examplewebapp.entity.Studente;

public interface StudenteRepository {

	Studente findById(int id);
	
	List<Studente> findAll();
	
	void save(Studente studente);
	
	void update(Studente studente);
	
	

}
