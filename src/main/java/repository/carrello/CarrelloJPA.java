package repository.carrello;


import entities.carrello.Carrello;
import repository.DataSourceJPA;

public class CarrelloJPA extends DataSourceJPA<Carrello, String> implements InterfaceCarrelloJPA{

    public CarrelloJPA() {
        super(Carrello.class);
    }
}
