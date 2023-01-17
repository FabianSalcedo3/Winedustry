package it.generationitaly.winedustryofficial.servlet;

import datasource.carrello.CarrelloJPA;
import datasource.carrello.item.CarrelloItemJPA;
import datasource.prodotto.ProdottoJPA;
import datasource.utente.UtenteJPA;
import entity.Prodotto;
import entity.Utente;
import entity.carrello.Carrello;
import entity.carrello.CarrelloItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

public class CarrelloItemServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("utenteID").isEmpty()) {
            Utente utente = new UtenteJPA(Utente.class).findById(Integer.parseInt(req.getParameter("utenteID")));
            if (utente.getCarrello() == null) {
                Carrello carrello = new Carrello();
                carrello.setId(utente.getId());
                new CarrelloJPA(Carrello.class).save(carrello);
            }
            CarrelloItem carrelloItem = new CarrelloItem();
            carrelloItem.setCarrello(utente.getCarrello());
            carrelloItem.setQuantita(Integer.parseInt(req.getParameter("prodottoQuantita")));
            carrelloItem.setProdotto(new ProdottoJPA(Prodotto.class).findById(Integer.valueOf(req.getParameter("prodottoID"))));
            new CarrelloItemJPA(CarrelloItem.class).save(carrelloItem);
            req.setAttribute("utente", utente);
            req.getRequestDispatcher("carrello.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
