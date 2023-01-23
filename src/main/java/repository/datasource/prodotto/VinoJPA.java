package repository.datasource.prodotto;

import entities.Regione;
import entities.prodotto.alcolico.Vino;
import repository.DataSourceJPA;

import java.util.List;

public class VinoJPA extends DataSourceJPA<Vino, String> {

    public VinoJPA() {
        super(Vino.class);
    }

    public List<Vino> findByCategoria(String categoria) {
        return super.findBySomethingList("where categoria=?1", categoria);
    }

    public List<Vino> findByVitigno(String vitigno) {
        return super.findBySomethingList("where vitigno=?1", vitigno);
    }

    public List<Vino> findByDenominazione(String denominazione) {
        return super.findBySomethingList("where denominazione=?1", denominazione);
    }

    public List<Vino> findByRegione(Regione regione) {
        return super.findBySomethingList("where regione=?1", regione);
    }

}
