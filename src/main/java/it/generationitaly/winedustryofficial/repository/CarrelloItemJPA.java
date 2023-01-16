package it.generationitaly.winedustryofficial.repository;

import it.generationitaly.winedustryofficial.entity.Carrello;

public class CarrelloItemJPA extends DataSourceJPA<Carrello, Integer> implements InterfaceDataSourceJPA<Carrello, Integer> {

    public CarrelloItemJPA(Class<Carrello> entityClass) {
        super(entityClass);
    }
}
