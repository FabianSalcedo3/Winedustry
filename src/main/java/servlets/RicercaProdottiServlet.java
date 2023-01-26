package servlets;

import entities.prodotto.Prodotto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.datasource.prodotto.ProdottoJPA;
import repository.datasource.prodotto.VinoJPA;

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
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
			case 1 : {
				prodotti.addAll(new VinoJPA().findByCategoria(req.getParameter("prodottoCategoria")));
				break;
			}
			case 2 : {
				prodotti.addAll(new VinoJPA().findByVitigno(req.getParameter("prodottoVitigno")));
				break;
			}
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
		List<Prodotto> prodotti = new ProdottoJPA().findBySomethingList("where annata like ?1 or prezzo like ?1 or categoria like ?1 or vitigno like ?1",
				value);
		if (!prodotti.isEmpty()) {
			req.setAttribute("prodotti", prodotti);
			req.getRequestDispatcher("shop/shop.jsp").forward(req, resp);
			return;
		}
		resp.sendRedirect("home/home.jsp");
	}
}
