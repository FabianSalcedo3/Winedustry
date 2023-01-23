package repository.datasource.prodotto;

import entities.prodotto.Prodotto;
import repository.DataSourceJPA;

import java.util.List;

public class ProdottoJPA extends DataSourceJPA<Prodotto, String> {

    public ProdottoJPA() {
        super(Prodotto.class);
    }

}
