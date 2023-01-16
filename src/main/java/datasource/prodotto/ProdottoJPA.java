package datasource.prodotto;

import datasource.DataSourceJPA;
import entity.Prodotto;

public class ProdottoJPA extends DataSourceJPA<Prodotto, Integer> implements InterfaceProdottoJPA {
    public ProdottoJPA(Class<Prodotto> entityClass) {
        super(entityClass);
    }
}
