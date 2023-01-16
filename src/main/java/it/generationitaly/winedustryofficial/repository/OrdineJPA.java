package it.generationitaly.winedustryofficial.repository;

import datasource.DataSourceJPA;
import entity.Ordine;


public class OrdineJPA extends DataSourceJPA<Ordine, Integer> implements InterfaceOrdineJPA {

    public OrdineJPA(Class<Ordine> entityClass) {
        super(entityClass);
    }

}
