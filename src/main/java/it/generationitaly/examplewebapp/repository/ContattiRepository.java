package it.generationitaly.examplewebapp.repository;

import it.generationitaly.examplewebapp.entity.Contatti;

public interface ContattiRepository {

	Contatti findById(int id);
}
