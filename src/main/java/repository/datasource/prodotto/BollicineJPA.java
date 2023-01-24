package repository.datasource.prodotto;

import entities.prodotto.alcolico.Bollicine;
import entities.prodotto.alcolico.Champagne;
import repository.DataSourceJPA;

import java.util.List;

public class BollicineJPA extends DataSourceJPA<Bollicine, String> {

    public BollicineJPA() {
        super(Bollicine.class);
    }

    public List<Bollicine> findByMetodo(String metodo) {
        return super.findBySomethingList("where metodo=?1", metodo);
    }
}
