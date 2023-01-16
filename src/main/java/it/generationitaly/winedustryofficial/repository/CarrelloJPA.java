package it.generationitaly.winedustryofficial.repository;

import it.generationitaly.winedustryofficial.entity.Carrello;

public class CarrelloJPA extends DataSourceJPA<Carrello, Integer> implements InterfaceDataSourceJPA<Carrello, Integer> {

    public CarrelloJPA(Class<Carrello> entityClass) {
        super(entityClass);
    }
}
