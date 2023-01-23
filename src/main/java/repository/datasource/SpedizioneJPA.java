package repository.datasource;

import entities.ordine.Spedizione;
import repository.DataSourceJPA;

public class SpedizioneJPA extends DataSourceJPA<Spedizione, String> {

    public SpedizioneJPA() {
        super(Spedizione.class);
    }

}
