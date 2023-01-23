package repository.prodotto.champagne;

import entities.prodotto.Champagne;
import repository.DataSourceJPA;

public class ChampagneJPA extends DataSourceJPA<Champagne, String> implements InterfaceChampagneJPA {

    public ChampagneJPA() {
        super(Champagne.class);
    }
}
