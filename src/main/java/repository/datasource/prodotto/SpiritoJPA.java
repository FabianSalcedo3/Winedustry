package repository.datasource.prodotto;

import entities.prodotto.alcolico.Spirito;
import repository.DataSourceJPA;

public class SpiritoJPA extends DataSourceJPA<Spirito, String> {

    public SpiritoJPA() {
        super(Spirito.class);
    }
}
