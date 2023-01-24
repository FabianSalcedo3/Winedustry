package repository.datasource;


import entities.ordine.Pagamento;
import repository.DataSourceJPA;

public class PagamentoJPA extends DataSourceJPA<Pagamento, String> {
    public PagamentoJPA() {
        super(Pagamento.class);
    }
}
