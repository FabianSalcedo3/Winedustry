package repository.pagamento;


import entities.Pagamento;
import repository.DataSourceJPA;

public class PagamentoJPA extends DataSourceJPA<Pagamento, String> implements InterfacePagamentoJPA {
    public PagamentoJPA() {
        super(Pagamento.class);
    }
}
