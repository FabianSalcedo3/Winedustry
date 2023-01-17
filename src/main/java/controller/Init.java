package controller;

import entities.Prodotto;
import repository.prodotto.ProdottoJPA;

public class Init {

	public static void main(String[] args) {
		new ProdottoJPA(Prodotto.class).findBySomethingList("where annata = ?1", "1910").forEach(System.out::println);
	}

}
