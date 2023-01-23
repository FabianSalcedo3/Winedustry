package repository.prodotto.birra;

import entities.prodotto.Birra;
import repository.DataSourceJPA;

public class BirraJPA extends DataSourceJPA<Birra, String> implements InterfaceBirraJPA {

    public BirraJPA() {
        super(Birra.class);
    }
}
