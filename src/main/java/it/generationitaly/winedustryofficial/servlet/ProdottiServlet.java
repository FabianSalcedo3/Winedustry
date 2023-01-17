package it.generationitaly.winedustryofficial.servlet;

import datasource.prodotto.ProdottoJPA;
import entity.Prodotto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

public class ProdottiServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("prodottoID").isEmpty()) {
            Prodotto prodotto = new ProdottoJPA(Prodotto.class).findById(Integer.parseInt(req.getParameter("prodottoID")));
            req.setAttribute("prodotto", prodotto);
            req.getRequestDispatcher("prodotti.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Prodotto> prodotti = new ProdottoJPA(Prodotto.class).findAll();
        if (!prodotti.isEmpty()) {
            req.setAttribute("prodotti", prodotti);
            req.getRequestDispatcher("prodotti.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
