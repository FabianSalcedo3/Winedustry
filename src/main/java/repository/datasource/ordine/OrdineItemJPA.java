package repository.datasource.ordine;

import entities.ordine.OrdineItem;
import repository.DataSourceJPA;
import repository.InterfaceDataSourceJPA;

public class OrdineItemJPA extends DataSourceJPA<OrdineItem, Integer> implements InterfaceDataSourceJPA<OrdineItem, Integer> {
    public OrdineItemJPA() {
        super(OrdineItem.class);
    }
}
