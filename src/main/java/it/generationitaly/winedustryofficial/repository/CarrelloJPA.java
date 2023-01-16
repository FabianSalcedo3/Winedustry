package it.generationitaly.winedustryofficial.repository;

import datasource.DataSourceJPA;
import datasource.InterfaceDataSourceJPA;
import entity.carrello.Carrello;

public class CarrelloJPA extends DataSourceJPA<Carrello, Integer> implements InterfaceDataSourceJPA<Carrello, Integer> {

    public CarrelloJPA(Class<Carrello> entityClass) {
        super(entityClass);
    }
}
