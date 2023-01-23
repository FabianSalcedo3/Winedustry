package repository.datasource.prodotto;

import entities.prodotto.alcolico.Birra;
import repository.DataSourceJPA;

import java.util.List;

public class BirraJPA extends DataSourceJPA<Birra, String> {

    public BirraJPA() {
        super(Birra.class);
    }

    public List<Birra> findByFermentazione(String fermentazione) {
        return super.findBySomethingList("where fermentazione=?1", fermentazione);
    }

    public List<Birra> findByGusto(String gusto) {
        return super.findBySomethingList("where gusto=?1", gusto);
    }

    public List<Birra> findByCaratteristiche(String caratteristiche) {
        return super.findBySomethingList("where caratteristiche=?1", caratteristiche);
    }

}
