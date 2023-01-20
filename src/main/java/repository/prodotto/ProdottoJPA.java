package repository.prodotto;

import entities.Prodotto;
import repository.DataSourceJPA;

public class ProdottoJPA extends DataSourceJPA<Prodotto, Integer> implements InterfaceProdottoJPA {
    public ProdottoJPA() {
        super(Prodotto.class);
    }
}
