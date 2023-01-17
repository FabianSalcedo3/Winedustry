package it.generationitaly.winedustryofficial.controller;

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import it.generationitaly.winedustryofficial.entity.Prodotto;
import it.generationitaly.winedustryofficial.repository.ProdottoJPA;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RicercaProdottiServlet")
public class RicercaProdottiServlet extends HttpServlet {

	@Serial
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodottoAnnataAsString = req.getParameter("prodottoAnnata");
		String prodottoFormatoAsString = req.getParameter("prodottoFormato");
		String prodottoGradazioneAsString = req.getParameter("prodottoGradazione");
		String prodottoCategoriaAsString = req.getParameter("prodottoCategoria");
		String prodottoVitignoAsString = req.getParameter("prodottoVitigno");

		if (prodottoAnnataAsString != null && !prodottoAnnataAsString.isEmpty()) {
			if (isInteger(prodottoAnnataAsString)) {
				int prodottoAnnata = Integer.parseInt(prodottoAnnataAsString);
				List<Prodotto> prodottiByAnnata = new ProdottoJPA(Prodotto.class)
						.findBySomethingList("where annata = ?1", prodottoAnnata);
				if (!prodottiByAnnata.isEmpty()) {
					req.setAttribute("prodotti", prodottiByAnnata);
					req.getRequestDispatcher("regione.jsp").forward(req, resp);
					return;
				}
			}
		}

		if (prodottoFormatoAsString != null && !prodottoFormatoAsString.isEmpty()) {
			if (isDouble(prodottoFormatoAsString)) {
				double prodottoFormato = Double.parseDouble(prodottoFormatoAsString);
				List<Prodotto> prodottiByFormato = new ProdottoJPA(Prodotto.class)
						.findBySomethingList("where formato = ?1", prodottoFormato);
				if (!prodottiByFormato.isEmpty()) {
					req.setAttribute("prodotti", prodottiByFormato);
					req.getRequestDispatcher("regione.jsp").forward(req, resp);
					return;
				}
			}
		}

		if (prodottoGradazioneAsString != null && !prodottoGradazioneAsString.isEmpty()) {
			if (isInteger(prodottoGradazioneAsString)) {
				int prodottoGradazione = Integer.parseInt(prodottoGradazioneAsString);
				List<Prodotto> prodottiByGradazione = new ProdottoJPA(Prodotto.class)
						.findBySomethingList("where gradazione = ?1", prodottoGradazione);
				if (!prodottiByGradazione.isEmpty()) {
					req.setAttribute("prodotti", prodottiByGradazione);
					req.getRequestDispatcher("regione.jsp").forward(req, resp);
					return;
				}
			}
		}
		if (prodottoCategoriaAsString != null && !prodottoCategoriaAsString.isEmpty()) {
			List<Prodotto> prodottiByCategoria = new ProdottoJPA(Prodotto.class)
					.findBySomethingList("where categoria = ?1", prodottoCategoriaAsString);
			if (!prodottiByCategoria.isEmpty()) {
				req.setAttribute("prodotti", prodottiByCategoria);
				req.getRequestDispatcher("regione.jsp").forward(req, resp);
				return;
			}
		}
		if (prodottoVitignoAsString != null && !prodottoVitignoAsString.isEmpty()) {
			List<Prodotto> prodottiByVitigno = new ProdottoJPA(Prodotto.class).findBySomethingList("where vitigno = ?1",
					prodottoVitignoAsString);
			if (!prodottiByVitigno.isEmpty()) {
				req.setAttribute("prodotti", prodottiByVitigno);
				req.getRequestDispatcher("regione.jsp").forward(req, resp);
				return;
			}
		}

		resp.sendRedirect("test.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String value = req.getParameter("ricercaProdotto");
		if (value != null && !value.isEmpty()) {
			HashMap<Integer, Prodotto> prodottiTemp = new HashMap<>();
			if (isInteger(value)) {
				int valueAsInt = Integer.parseInt(value);
				List<Prodotto> prodottiByAnnata = new ProdottoJPA(Prodotto.class)
						.findBySomethingList("where annata = ?1", valueAsInt);
				if (!prodottiByAnnata.isEmpty()) {
					prodottiByAnnata.forEach(prodotto -> prodottiTemp.put(prodotto.getId(), prodotto));
				}
				List<Prodotto> prodottiByGradazione = new ProdottoJPA(Prodotto.class)
						.findBySomethingList("where gradazione = ?1", value);
				if (!prodottiByGradazione.isEmpty()) {
					prodottiByGradazione.forEach(prodotto -> prodottiTemp.put(prodotto.getId(), prodotto));
				}
			} else if (isDouble(value)) {
				double valueAsDouble = Double.parseDouble(value);
				List<Prodotto> prodottiByFormato = new ProdottoJPA(Prodotto.class)
						.findBySomethingList("where formato = ?1", valueAsDouble);
				if (!prodottiByFormato.isEmpty()) {
					prodottiByFormato.forEach(prodotto -> prodottiTemp.put(prodotto.getId(), prodotto));
				}
			} else {
				List<Prodotto> prodottiByCategoria = new ProdottoJPA(Prodotto.class)
						.findBySomethingList("where categoria like ?1", value + "%");
				if (!prodottiByCategoria.isEmpty()) {
					prodottiByCategoria.forEach(prodotto -> prodottiTemp.put(prodotto.getId(), prodotto));
				}
				List<Prodotto> prodottiByVitigno = new ProdottoJPA(Prodotto.class)
						.findBySomethingList("where vitigno like ?1", value + "%");
				if (!prodottiByVitigno.isEmpty()) {
					prodottiByVitigno.forEach(prodotto -> prodottiTemp.put(prodotto.getId(), prodotto));
				}
			}
			if (!prodottiTemp.isEmpty()) {
				List<Prodotto> prodotti = new ArrayList<>(prodottiTemp.values());
				req.setAttribute("prodotti", prodotti);
				req.getRequestDispatcher("regione.jsp").forward(req, resp); // da cambiare in prodotti filtrati
				return;
			}
		}
		resp.sendRedirect("test.jsp");
	}

	private boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean isDouble(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
