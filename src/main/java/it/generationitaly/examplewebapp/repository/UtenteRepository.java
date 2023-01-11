package it.generationitaly.examplewebapp.repository;

import it.generationitaly.examplewebapp.entity.Utente;

public interface UtenteRepository {
	
	void saveUtente(Utente utente);
	
	void updateUtente(Utente utente);
	
	void deleteByIdUtente(int id);
	
	Utente findById (int id);
	
	Utente findByUsername(String username);
}
