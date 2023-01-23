package repository.datasource.prodotto;

import entities.prodotto.alcolico.Alcolico;
import repository.DataSourceJPA;

public class AlcolicoJPA extends DataSourceJPA<Alcolico, String> {
    public AlcolicoJPA() {
        super(Alcolico.class);
    }
}
