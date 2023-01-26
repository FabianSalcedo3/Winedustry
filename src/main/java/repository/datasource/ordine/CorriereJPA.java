package repository.datasource.ordine;


import entities.ordine.Corriere;
import repository.DataSourceJPA;

public class CorriereJPA extends DataSourceJPA<Corriere, String>{
    public CorriereJPA() {
        super(Corriere.class);
    }
}
