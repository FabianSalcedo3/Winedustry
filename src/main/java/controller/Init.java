package controller;

import repository.datasource.prodotto.ChampagneJPA;

public class Init {
    public static void main(String[] args) {
        new ChampagneJPA().findAll().forEach(System.out::println);
    }
}


