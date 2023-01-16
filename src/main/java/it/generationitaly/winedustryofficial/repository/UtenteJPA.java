package it.generationitaly.winedustryofficial.repository;

import datasource.DataSourceJPA;
import entity.Utente;

public class UtenteJPA extends DataSourceJPA<Utente, Integer> implements InterfaceUtenteJPA {

    public UtenteJPA(Class<Utente> entityClass) {
        super(entityClass);
    }

}
