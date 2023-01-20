package repository.carrello;

import entities.carrello.CarrelloItem;
import repository.DataSourceJPA;
import repository.InterfaceDataSourceJPA;

public class CarrelloItemJPA extends DataSourceJPA<CarrelloItem, Integer> implements InterfaceDataSourceJPA<CarrelloItem, Integer> {

    public CarrelloItemJPA() {
        super(CarrelloItem.class);
    }
}
