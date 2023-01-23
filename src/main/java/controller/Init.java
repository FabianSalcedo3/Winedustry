package controller;

import repository.prodotto.ProdottoJPA;
import repository.prodotto.birra.BirraJPA;
import repository.prodotto.bollicine.BollicineJPA;
import repository.prodotto.champagne.ChampagneJPA;
import repository.prodotto.spirito.SpiritoJPA;
import repository.prodotto.vino.VinoJPA;

public class Init {
    public static void main(String[] args) {
        new ProdottoJPA().findAll().forEach(System.out::println);
        new VinoJPA().findAll().forEach(System.out::println);
        new BirraJPA().findAll().forEach(System.out::println);
        new BollicineJPA().findAll().forEach(System.out::println);
        new ChampagneJPA().findAll().forEach(System.out::println);
        new SpiritoJPA().findAll().forEach(System.out::println);
    }
}


