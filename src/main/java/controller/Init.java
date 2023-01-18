package controller;

import entities.Prodotto;
import repository.prodotto.ProdottoJPA;

public class Init {

	public static void main(String[] args) {
		new ProdottoJPA(Prodotto.class).findAll().forEach(prodotto -> {
			System.out.println(prodotto);
			System.out.println(prodotto.getRegione().getNome());
		});
	}

}
