package servlets.prodotto;

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entities.Prodotto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.prodotto.ProdottoJPA;
import utils.ParametersValidation;

@WebServlet("/RicercaProdottiServlet")
public class RicercaProdottiServlet extends HttpServlet {

	@Serial
	private static final long serialVersionUID = 1L;

	private static final ParametersValidation pv = new ParametersValidation();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodottoAnnata = req.getParameter("prodottoAnnata");
		String prodottoFormato = req.getParameter("prodottoFormato");
		String prodottoGradazione = req.getParameter("prodottoGradazione");
		String prodottoCategoria = req.getParameter("prodottoCategoria");
		String prodottoVitigno = req.getParameter("prodottoVitigno");

		if (pv.isValidInteger(prodottoVitigno)) {
			List<Prodotto> prodottiByAnnata = new ProdottoJPA().findBySomethingList("where annata = ?1", prodottoAnnata);
			if (!prodottiByAnnata.isEmpty()) {
				req.setAttribute("prodotti", prodottiByAnnata);
				req.getRequestDispatcher("regione.jsp").forward(req, resp);
				return;
			}
		} else if (pv.isValidDouble(prodottoFormato)) {
			List<Prodotto> prodottiByFormato = new ProdottoJPA().findBySomethingList("where formato = ?1", prodottoFormato);
			if (!prodottiByFormato.isEmpty()) {
				req.setAttribute("prodotti", prodottiByFormato);
				req.getRequestDispatcher("regione.jsp").forward(req, resp);
				return;
			}
		} else if (pv.isValidInteger(prodottoGradazione)) {
			List<Prodotto> prodottiByGradazione = new ProdottoJPA().findBySomethingList("where gradazione = ?1", prodottoGradazione);
			if (!prodottiByGradazione.isEmpty()) {
				req.setAttribute("prodotti", prodottiByGradazione);
				req.getRequestDispatcher("regione.jsp").forward(req, resp);
				return;
			}
		} else if (pv.isValidString(prodottoCategoria)) {
			List<Prodotto> prodottiByCategoria = new ProdottoJPA().findBySomethingList("where categoria = ?1", prodottoCategoria);
			if (!prodottiByCategoria.isEmpty()) {
				req.setAttribute("prodotti", prodottiByCategoria);
				req.getRequestDispatcher("regione.jsp").forward(req, resp);
				return;
			}
		} else if (pv.isValidString(prodottoVitigno)) {
			List<Prodotto> prodottiByVitigno = new ProdottoJPA().findBySomethingList("where vitigno = ?1", prodottoVitigno);
			if (!prodottiByVitigno.isEmpty()) {
				req.setAttribute("prodotti", prodottiByVitigno);
				req.getRequestDispatcher("regione.jsp").forward(req, resp);
				return;
			}
		}
		resp.sendRedirect("test.jsp");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String value = req.getParameter("ricercaProdotto");
		if (value != null && !value.isEmpty()) {
			HashMap<Integer, Prodotto> prodottiTemp = new HashMap<>();
			if (pv.isInteger(value)) {
				List<Prodotto> prodottiByAnnata = new ProdottoJPA().findBySomethingList("where annata = ?1", value);
				if (!prodottiByAnnata.isEmpty()) {
					prodottiByAnnata.forEach(prodotto -> prodottiTemp.put(prodotto.getId(), prodotto));
				}
				List<Prodotto> prodottiByGradazione = new ProdottoJPA().findBySomethingList("where gradazione = ?1", value);
				if (!prodottiByGradazione.isEmpty()) {
					prodottiByGradazione.forEach(prodotto -> prodottiTemp.put(prodotto.getId(), prodotto));
				}
			} else if (pv.isDouble(value)) {
				List<Prodotto> prodottiByFormato = new ProdottoJPA().findBySomethingList("where formato = ?1", value);
				if (!prodottiByFormato.isEmpty()) {
					prodottiByFormato.forEach(prodotto -> prodottiTemp.put(prodotto.getId(), prodotto));
				}
			} else {
				List<Prodotto> prodottiByCategoria = new ProdottoJPA().findBySomethingList("where categoria like ?1", value + "%");
				if (!prodottiByCategoria.isEmpty()) {
					prodottiByCategoria.forEach(prodotto -> prodottiTemp.put(prodotto.getId(), prodotto));
				}
				List<Prodotto> prodottiByVitigno = new ProdottoJPA().findBySomethingList("where vitigno like ?1", value + "%");
				if (!prodottiByVitigno.isEmpty()) {
					prodottiByVitigno.forEach(prodotto -> prodottiTemp.put(prodotto.getId(), prodotto));
				}
			}
			if (!prodottiTemp.isEmpty()) {
				List<Prodotto> prodotti = new ArrayList<>(prodottiTemp.values());
				req.setAttribute("prodotti", prodotti);
				req.getRequestDispatcher("regione.jsp").forward(req, resp);
				return;
			}
		}
		resp.sendRedirect("test.jsp");
	}

}
