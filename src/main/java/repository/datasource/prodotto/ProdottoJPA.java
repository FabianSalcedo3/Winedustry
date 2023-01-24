package repository.datasource.prodotto;

import entities.prodotto.Prodotto;
import entities.prodotto.alcolico.Spirito;
import repository.DataSourceJPA;

import java.util.List;

public class ProdottoJPA extends DataSourceJPA<Prodotto, String> {

    public ProdottoJPA() {
        super(Prodotto.class);
    }

    public List<Prodotto> findByNome(String nome) {
        return super.findBySomethingList("where nome=?1", nome);
    }

    public List<Prodotto> findByProduttore(String produttore) {
        return super.findBySomethingList("where produttore=?1", produttore);
    }

    public List<Prodotto> findByFormato(String formato) {
        return super.findBySomethingList("where formato=?1", formato);
    }

    public List<Prodotto> findByPrezzo(String prezzo) {
        return super.findBySomethingList("where prezzo=?1", prezzo);
    }

    public List<Prodotto> findByValutazione(String valutazione) {
        return super.findBySomethingList("where valutazione=?1", valutazione);
    }

    public List<Prodotto> findByNazione(String nazione) {
        return super.findBySomethingList("where nazione=?1", nazione);
    }

}
