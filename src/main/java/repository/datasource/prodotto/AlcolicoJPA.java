package repository.datasource.prodotto;

import entities.prodotto.alcolico.Alcolico;
import repository.DataSourceJPA;

import java.util.List;

public class AlcolicoJPA extends DataSourceJPA<Alcolico, String> {

    public AlcolicoJPA() {
        super(Alcolico.class);
    }

    public List<Alcolico> findByGradazione(String gradazione) {
        return super.findBySomethingList("where gradazione=?1", gradazione);
    }

}
