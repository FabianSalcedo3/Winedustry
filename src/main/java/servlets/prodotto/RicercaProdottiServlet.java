package servlets.prodotto;

import entities.prodotto.Prodotto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.datasource.prodotto.VinoJPA;

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/RicercaProdottiServlet")
public class RicercaProdottiServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ricercaBy = Integer.parseInt(req.getParameter("ricercaBy"));
        List<Prodotto> prodotti = new ArrayList<>();
        switch (ricercaBy) {
           case 1: {prodotti.addAll(new VinoJPA().findByCategoria(req.getParameter("prodottoCategoria")));break;}
            case 2: {prodotti.addAll(new VinoJPA().findByVitigno(req.getParameter("prodottoVitigno")));break;}
        }
        if (!prodotti.isEmpty()) {
            req.setAttribute("prodotti", prodotti);
            req.getRequestDispatcher("prodotto.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("prodotti.jsp");
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("prodottoValue");
        HashMap<Integer, Prodotto> prodotti = new HashMap<>();
        new VinoJPA().findByCategoria(value).forEach(prodotto -> prodotti.put(prodotto.getId(), prodotto));
        new VinoJPA().findByVitigno(value).forEach(prodotto -> prodotti.put(prodotto.getId(), prodotto));
        if (!prodotti.values().isEmpty()) {
            req.setAttribute("prodotti", prodotti.values());
            req.getRequestDispatcher("regione.jsp").forward(req, resp);
            return;
        }
        resp.sendRedirect("test.jsp");
    }

}
