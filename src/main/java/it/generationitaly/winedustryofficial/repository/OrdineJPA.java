package it.generationitaly.winedustryofficial.repository;


import it.generationitaly.winedustryofficial.entity.Ordine;

public class OrdineJPA extends DataSourceJPA<Ordine, Integer> implements InterfaceOrdineJPA {

    public OrdineJPA(Class<Ordine> entityClass) {
        super(entityClass);
    }

}
