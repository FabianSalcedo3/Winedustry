package repository.prodotto.vino;

import entities.prodotto.Vino;
import repository.DataSourceJPA;

import java.util.List;

public class VinoJPA extends DataSourceJPA<Vino, String> implements InterfaceVinoJPA {

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

}
