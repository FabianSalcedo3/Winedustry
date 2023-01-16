package datasource.pagamento;

import datasource.DataSourceJPA;
import entity.Pagamento;

public class PagamentoJPA extends DataSourceJPA<Pagamento, Integer> implements InterfacePagamentoJPA {
    public PagamentoJPA(Class<Pagamento> entityClass) {
        super(entityClass);
    }
}
