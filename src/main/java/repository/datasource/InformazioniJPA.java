package repository.datasource;

import entities.Informazioni;
import repository.DataSourceJPA;

public class InformazioniJPA extends DataSourceJPA<Informazioni, String> {

    public InformazioniJPA() {
        super(Informazioni.class);
    }
}
