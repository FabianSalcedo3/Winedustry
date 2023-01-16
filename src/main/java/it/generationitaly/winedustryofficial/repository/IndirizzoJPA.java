package it.generationitaly.winedustryofficial.repository;


import it.generationitaly.winedustryofficial.entity.Indirizzo;

public class IndirizzoJPA extends DataSourceJPA<Indirizzo, Integer> implements InterfaceIndirizzoJPA {

    public IndirizzoJPA(Class<Indirizzo> entityClass) {
        super(entityClass);
    }
}
