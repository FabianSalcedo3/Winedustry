package repository.informazioni;

import entities.Informazioni;
import repository.DataSourceJPA;

public class InformazioniJPA extends DataSourceJPA<Informazioni, Integer> implements InterfaceInformazioniJPA {

    public InformazioniJPA() {
        super(Informazioni.class);
    }
}
