package servlets.prodotto;

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entities.prodotto.Prodotto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.datasource.RegioneJPA;
import repository.datasource.prodotto.ProdottoJPA;
import repository.datasource.prodotto.VinoJPA;

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
        String value = req.getParameter("pValue");
        HashMap<Integer, Prodotto> prodotti = new HashMap<>();
        if(isValidNumber(value)) {
        	new VinoJPA().findByAnnata(value).forEach(prodotto -> prodotti.put(prodotto.getId(), prodotto));
        	new ProdottoJPA().findByPrezzo(value).forEach(prodotto -> prodotti.put(prodotto.getId(), prodotto));
        }
        new VinoJPA().findByCategoria(value).forEach(prodotto -> prodotti.put(prodotto.getId(), prodotto));
        new VinoJPA().findByVitigno(value).forEach(prodotto -> prodotti.put(prodotto.getId(), prodotto));
        new VinoJPA().findByRegione(new RegioneJPA().findByNome(value)).forEach(prodotto -> prodotti.put(prodotto.getId(), prodotto));
        if (!prodotti.values().isEmpty()) {
        	List<Prodotto> listaProdotti = new ArrayList<>();
        	prodotti.values().forEach(prodotto -> listaProdotti.add(prodotto));
            req.setAttribute("prodotti",listaProdotti );
            req.getRequestDispatcher("shop/shop.jsp").forward(req, resp);
            return;
        }
        resp.sendRedirect("home/home.jsp");
    }
    
    private boolean isValidNumber(String value) {
    	try {
			Integer.parseInt(value);
			return true;
		} catch (Exception e) {
			return false;
		}
    }

}
