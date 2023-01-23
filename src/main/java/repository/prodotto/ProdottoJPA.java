package repository.prodotto;

import entities.prodotto.Prodotto;
import repository.DataSourceJPA;

import java.util.List;

public class ProdottoJPA extends DataSourceJPA<Prodotto, String> implements InterfaceProdottoJPA {

    public ProdottoJPA() {
        super(Prodotto.class);
    }

    public List<Prodotto> findByAnnata(int annata) {
        return super.findBySomethingList("where annata=?1", annata);
    }

    public List<Prodotto> findByGradazione(int gradazione) {
        return super.findBySomethingList("where gradazione=?1", gradazione);
    }

    public List<Prodotto> findByFormato(double formato) {
        return super.findBySomethingList("where formato=?1", formato);
    }

}
