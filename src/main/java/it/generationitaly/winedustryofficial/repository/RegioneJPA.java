package it.generationitaly.winedustryofficial.repository;


import it.generationitaly.winedustryofficial.entity.Regione;

public class RegioneJPA extends DataSourceJPA<Regione, Integer> implements InterfaceRegioneJPA {

    public RegioneJPA(Class<Regione> entityClass) {
        super(entityClass);
    }

}
