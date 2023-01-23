package repository.prodotto.spirito;

import entities.prodotto.Spirito;
import repository.DataSourceJPA;

public class SpiritoJPA extends DataSourceJPA<Spirito, String> implements InterfaceSpiritoJPA {

    public SpiritoJPA() {
        super(Spirito.class);
    }
}
