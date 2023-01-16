package it.generationitaly.winedustryofficial.repository;


import it.generationitaly.winedustryofficial.entity.Prodotto;

public class ProdottoJPA extends DataSourceJPA<Prodotto, Integer> implements InterfaceProdottoJPA {
    public ProdottoJPA(Class<Prodotto> entityClass) {
        super(entityClass);
    }
}
