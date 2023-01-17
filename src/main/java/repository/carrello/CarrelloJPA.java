package repository.carrello;


import entities.carrello.Carrello;
import repository.DataSourceJPA;
import repository.InterfaceDataSourceJPA;

public class CarrelloJPA extends DataSourceJPA<Carrello, Integer> implements InterfaceDataSourceJPA<Carrello, Integer> {

    public CarrelloJPA(Class<Carrello> entityClass) {
        super(entityClass);
    }
}
