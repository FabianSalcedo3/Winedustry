package servlets.prodotto;

import entities.prodotto.Prodotto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.prodotto.ProdottoJPA;
import repository.prodotto.vino.VinoJPA;

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
            case 1 -> prodotti.addAll(new ProdottoJPA().findByAnnata(Integer.parseInt(req.getParameter("prodottoAnnata"))));
            case 2 -> prodotti.addAll(new ProdottoJPA().findByFormato(Double.parseDouble(req.getParameter("prodottoFormato"))));
            case 3 -> prodotti.addAll(new ProdottoJPA().findByGradazione(Integer.parseInt(req.getParameter("prodottoGradazione"))));
            case 4 -> prodotti.addAll(new VinoJPA().findByCategoria(req.getParameter("prodottoCategoria")));
            case 5 -> prodotti.addAll(new VinoJPA().findByVitigno(req.getParameter("prodottoVitigno")));
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
        new ProdottoJPA().findByAnnata(Integer.parseInt(value)).forEach(prodotto -> prodotti.put(prodotto.getId(), prodotto));
        new ProdottoJPA().findByGradazione(Integer.parseInt(value)).forEach(prodotto -> prodotti.put(prodotto.getId(), prodotto));
        new ProdottoJPA().findByFormato(Double.parseDouble(value)).forEach(prodotto -> prodotti.put(prodotto.getId(), prodotto));
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
