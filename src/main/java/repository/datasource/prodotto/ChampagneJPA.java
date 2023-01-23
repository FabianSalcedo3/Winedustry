package repository.datasource.prodotto;

import entities.prodotto.alcolico.Champagne;
import repository.DataSourceJPA;

public class ChampagneJPA extends DataSourceJPA<Champagne, String> {

    public ChampagneJPA() {
        super(Champagne.class);
    }
}
