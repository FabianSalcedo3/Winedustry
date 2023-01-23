package repository.spedizione;

import entities.Spedizione;
import repository.DataSourceJPA;

public class SpedizioneJPA extends DataSourceJPA<Spedizione, String> implements InterfaceSpedizioneJPA {

    public SpedizioneJPA() {
        super(Spedizione.class);
    }

}
