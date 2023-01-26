package controller;

import repository.datasource.prodotto.ProdottoJPA;

public class Init {
    public static void main(String[] args) {
        new ProdottoJPA().findBySomethingList("where annata like ?1 or prezzo like ?1 or categoria like ?1 or vitigno like ?1", "ch%").forEach(System.out::println);
    }
}