package repository.datasource.prodotto;

import entities.prodotto.alcolico.Bollicine;
import repository.DataSourceJPA;

public class BollicineJPA extends DataSourceJPA<Bollicine, String> {

    public BollicineJPA() {
        super(Bollicine.class);
    }
}
