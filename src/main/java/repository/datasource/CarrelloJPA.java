package repository.datasource;


import entities.ordine.Carrello;
import repository.DataSourceJPA;

public class CarrelloJPA extends DataSourceJPA<Carrello, String> {

    public CarrelloJPA() {
        super(Carrello.class);
    }
}
