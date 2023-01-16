package it.generationitaly.winedustryofficial.repository;

import it.generationitaly.winedustryofficial.entity.Utente;

public class UtenteJPA extends DataSourceJPA<Utente, Integer> implements InterfaceUtenteJPA {

    public UtenteJPA(Class<Utente> entityClass) {
        super(entityClass);
    }

}
