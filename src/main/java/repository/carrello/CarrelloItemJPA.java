package repository.carrello;

import entities.carrello.Carrello;
import repository.DataSourceJPA;
import repository.InterfaceDataSourceJPA;

public class CarrelloItemJPA extends DataSourceJPA<Carrello, Integer> implements InterfaceDataSourceJPA<Carrello, Integer> {

    public CarrelloItemJPA(Class<Carrello> entityClass) {
        super(entityClass);
    }
}
