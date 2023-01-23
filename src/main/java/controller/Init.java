package controller;

import repository.datasource.PagamentoJPA;

public class Init {
    public static void main(String[] args) {
        new PagamentoJPA().findAll().forEach(System.out::println);
    }
}


