package repository.pagamento;


import entities.Pagamento;
import repository.DataSourceJPA;

public class PagamentoJPA extends DataSourceJPA<Pagamento, Integer> implements InterfacePagamentoJPA {
    public PagamentoJPA() {
        super(Pagamento.class);
    }
}
