package repository.carrello;

import entities.carrello.CarrelloItem;
import repository.DataSourceJPA;

public class CarrelloItemJPA extends DataSourceJPA<CarrelloItem, String> implements InterfaceCarrelloItemJPA {

    public CarrelloItemJPA() {
        super(CarrelloItem.class);
    }

}
