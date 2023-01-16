package it.generationitaly.winedustryofficial.repository;

import datasource.DataSourceJPA;
import datasource.InterfaceDataSourceJPA;
import entity.carrello.Carrello;

public class CarrelloItemJPA extends DataSourceJPA<Carrello, Integer> implements InterfaceDataSourceJPA<Carrello, Integer> {

    public CarrelloItemJPA(Class<Carrello> entityClass) {
        super(entityClass);
    }
}
