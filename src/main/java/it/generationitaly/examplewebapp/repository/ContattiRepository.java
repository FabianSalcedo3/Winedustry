package it.generationitaly.examplewebapp.repository;

import java.util.List;

import it.generationitaly.examplewebapp.entity.Contatti;

public interface ContattiRepository {

	Contatti findById(int id);
	
	List<Contatti> findAll();
	
	void save(Contatti contatto);
	
	void update(Contatti contatto);
}
