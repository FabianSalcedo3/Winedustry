package repository.datasource.prodotto;

import entities.prodotto.alcolico.Spirito;
import repository.DataSourceJPA;

import java.util.List;

public class SpiritoJPA extends DataSourceJPA<Spirito, String> {

    public SpiritoJPA() {
        super(Spirito.class);
    }

    public List<Spirito> findByVarieta(String varieta) {
        return super.findBySomethingList("where varieta=?1", varieta);
    }

}
