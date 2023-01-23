package repository.datasource.prodotto;

import entities.prodotto.alcolico.Birra;
import repository.DataSourceJPA;

public class BirraJPA extends DataSourceJPA<Birra, String> {

    public BirraJPA() {
        super(Birra.class);
    }
}
