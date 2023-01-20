package controller;

import repository.utente.UtenteJPA;

public class Init {

    public static void main(String[] args) {
    	new UtenteJPA().findAll().forEach(utente ->{
    		System.out.println(utente);
    		System.out.println(utente.getIndirizzo());
    		System.out.println(utente.getInformazioni());
    		System.out.println(utente.getPagamento());
    	});
    }

}
