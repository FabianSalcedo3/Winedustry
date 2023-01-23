package repository.corriere;


import entities.Corriere;
import repository.DataSourceJPA;
import repository.InterfaceDataSourceJPA;

public class CorriereJPA extends DataSourceJPA<Corriere, String> implements InterfaceCorriereJPA {

    public CorriereJPA() {
        super(Corriere.class);
    }
}
