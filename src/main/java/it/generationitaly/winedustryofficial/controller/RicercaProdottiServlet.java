package it.generationitaly.winedustryofficial.controller;

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import it.generationitaly.winedustryofficial.entity.Prodotto;
import it.generationitaly.winedustryofficial.repository.ProdottoJPA;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RicercaProdottiServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("prodottoAnnata").isEmpty()) {
            List<Prodotto> prodottiByAnnata = new ProdottoJPA(Prodotto.class).findBySomethingList("where annata = ?1", req.getParameter("prodottoAnnata"));
            if (!prodottiByAnnata.isEmpty()) {
                req.setAttribute("prodotti", prodottiByAnnata);
                req.getRequestDispatcher("prodotti.jsp").forward(req, resp);
            }
        } else if (!req.getParameter("prodottoFormato").isEmpty()) {
            List<Prodotto> prodottiByFormato = new ProdottoJPA(Prodotto.class).findBySomethingList("where formato = ?1", req.getParameter("prodottoFormato"));
            if (!prodottiByFormato.isEmpty()) {
                req.setAttribute("prodotti", prodottiByFormato);
                req.getRequestDispatcher("prodotti.jsp").forward(req, resp);
            }
        } else if (!req.getParameter("prodottoGradazione").isEmpty()) {
            List<Prodotto> prodottiByGradazione = new ProdottoJPA(Prodotto.class).findBySomethingList("where gradazione = ?1", req.getParameter("prodottoGradazione"));
            if (!prodottiByGradazione.isEmpty()) {
                req.setAttribute("prodotti", prodottiByGradazione);
                req.getRequestDispatcher("prodotti.jsp").forward(req, resp);
            }
        } else if (!req.getParameter("prodottoCategoria").isEmpty()) {
            List<Prodotto> prodottiByCategoria = new ProdottoJPA(Prodotto.class).findBySomethingList("where categoria = ?1", req.getParameter("prodottoCategoria"));
            if (!prodottiByCategoria.isEmpty()) {
                req.setAttribute("prodotti", prodottiByCategoria);
                req.getRequestDispatcher("prodotti.jsp").forward(req, resp);
            }
        } else if (!req.getParameter("prodottoVitigno").isEmpty()) {
            List<Prodotto> prodottiByVitigno = new ProdottoJPA(Prodotto.class).findBySomethingList("where vitigno = ?1", req.getParameter("prodottoVitigno"));
            if (!prodottiByVitigno.isEmpty()) {
                req.setAttribute("prodotti", prodottiByVitigno);
                req.getRequestDispatcher("prodotti.jsp").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("ricercaProdotto").isEmpty()) {
            String value = req.getParameter("ricercaProdotto");
            HashMap<Integer, Prodotto> prodottiTemp = new HashMap<>();
            if (isNumeric(value)) {
                List<Prodotto> prodottiByAnnata = new ProdottoJPA(Prodotto.class).findBySomethingList("where annata = ?1", value);
                if (!prodottiByAnnata.isEmpty()) {
                    prodottiByAnnata.forEach(prodotto -> prodottiTemp.put(prodotto.getId(), prodotto));
                }
                List<Prodotto> prodottiByFormato = new ProdottoJPA(Prodotto.class).findBySomethingList("where formato = ?1", value);
                if (!prodottiByFormato.isEmpty()) {
                    prodottiByFormato.forEach(prodotto -> prodottiTemp.put(prodotto.getId(), prodotto));
                }
                List<Prodotto> prodottiByGradazione = new ProdottoJPA(Prodotto.class).findBySomethingList("where gradazione = ?1", value);
                if (!prodottiByGradazione.isEmpty()) {
                    prodottiByGradazione.forEach(prodotto -> prodottiTemp.put(prodotto.getId(), prodotto));
                }
            } else {
                List<Prodotto> prodottiByCategoria = new ProdottoJPA(Prodotto.class).findBySomethingList("where categoria like = ?1", value + "%");
                if (!prodottiByCategoria.isEmpty()) {
                    prodottiByCategoria.forEach(prodotto -> prodottiTemp.put(prodotto.getId(), prodotto));
                }
                List<Prodotto> prodottiByVitigno = new ProdottoJPA(Prodotto.class).findBySomethingList("where vitigno like = ?1", value + "%");
                if (!prodottiByVitigno.isEmpty()) {
                    prodottiByVitigno.forEach(prodotto -> prodottiTemp.put(prodotto.getId(), prodotto));
                }
            }
            if (!prodottiTemp.isEmpty()) {
                List<Prodotto> prodotti = new ArrayList<>(prodottiTemp.values());
                req.setAttribute("prodotti", prodotti);
                req.getRequestDispatcher("prodotti.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("home.jsp");
            }
        }
    }

    private boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
