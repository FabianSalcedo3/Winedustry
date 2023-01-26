package repository.datasource.ordine;

import entities.ordine.CarrelloItem;
import repository.DataSourceJPA;

public class CarrelloItemJPA extends DataSourceJPA<CarrelloItem, String> {

    public CarrelloItemJPA() {
        super(CarrelloItem.class);
    }

}
