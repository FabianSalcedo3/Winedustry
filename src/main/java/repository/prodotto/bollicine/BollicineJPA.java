package repository.prodotto.bollicine;

import entities.prodotto.Bollicine;
import repository.DataSourceJPA;

public class BollicineJPA extends DataSourceJPA<Bollicine, String> implements InterfaceBollicineJPA {

    public BollicineJPA() {
        super(Bollicine.class);
    }
}
