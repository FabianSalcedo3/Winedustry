package servlets.ordine;

import java.io.IOException;
import java.io.Serial;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import entities.Utente;
import entities.ordine.CarrelloItem;
import entities.ordine.Ordine;
import entities.ordine.OrdineItem;
import entities.prodotto.Prodotto;
import entities.prodotto.alcolico.Alcolico;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.datasource.UtenteJPA;
import repository.datasource.ordine.OrdineItemJPA;
import repository.datasource.ordine.OrdineJPA;
import repository.datasource.prodotto.ProdottoJPA;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {

	@Serial
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utente utente = new UtenteJPA().findById((Integer) req.getSession().getAttribute("uID"));
		List<CarrelloItem> carrelloItems = utente.getCarrello().get(0).getCarrelloItems();
		int cSize = carrelloItems.size();
		for (int i = 0; i < cSize; i++) {
			int quantita = Integer.parseInt(req.getParameter("pQuantita" + i));
			Prodotto prodotto = new ProdottoJPA().findById(req.getParameter("pID" + i));
			carrelloItems.forEach(carrelloItem -> {
				if (carrelloItem.getProdotto().getId() == prodotto.getId() && carrelloItem.getQuantita() != quantita) {
					carrelloItem.setQuantita(quantita);
				}
			});
		}
		new OrdineJPA().save(new Ordine("cod" + utente.getId(), false, utente));
		Ordine ordine = new OrdineJPA().findByCodice("cod" + utente.getId());
		AtomicReference<Double> totale = new AtomicReference<>();
		carrelloItems.forEach(carrelloItem -> {
			if (carrelloItem.getProdotto() instanceof Alcolico) {
				totale.set(totale.get() + carrelloItem.getProdotto().getPrezzo() + 5.56);
				new OrdineItemJPA().save(new OrdineItem(true, carrelloItem.getQuantita(), ordine, carrelloItem.getProdotto()));
			} else {
				totale.set(totale.get() + carrelloItem.getProdotto().getPrezzo());
				new OrdineItemJPA().save(new OrdineItem(false, carrelloItem.getQuantita(), ordine, carrelloItem.getProdotto()));
			}
		});
		if (Boolean.parseBoolean(req.getParameter("isSpedizione"))) {
			totale.set(totale.get() + 15);
		}
		ordine.setPagamento(utente.getPagamenti().get(0));
		ordine.setTotale(totale.get());
		ordine.setEvaso(true);
		new OrdineJPA().update(ordine);
		resp.sendRedirect("ProdottiServlet");
	}
}
