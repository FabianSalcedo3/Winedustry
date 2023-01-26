package repository.datasource.prodotto;

import entities.prodotto.alcolico.Champagne;
import repository.DataSourceJPA;

import java.util.List;

public class ChampagneJPA extends DataSourceJPA<Champagne, String> {

    public ChampagneJPA() {
        super(Champagne.class);
    }

    public List<Champagne> findByDosaggio(String dosaggio) {
        return super.findBySomethingList("where dosaggio=?1", dosaggio);
    }

    public List<Champagne> findByAffinamento(String affinamento) {
        return super.findBySomethingList("where affinamento=?1", affinamento);
    }


}
