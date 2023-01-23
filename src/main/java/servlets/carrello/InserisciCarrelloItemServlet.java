package servlets.carrello;

import entities.prodotto.Prodotto;
import entities.carrello.Carrello;
import entities.carrello.CarrelloItem;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.carrello.CarrelloItemJPA;
import repository.prodotto.ProdottoJPA;
import repository.utente.UtenteJPA;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/InserisciCarrelloItemServlet")
public class InserisciCarrelloItemServlet extends HttpServlet implements Servlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int quantita = Integer.parseInt(req.getParameter("pQuatita"));
        Prodotto prodotto = new ProdottoJPA().findById(req.getParameter("pID"));
        Carrello carrello = new UtenteJPA().findById(req.getParameter("uID")).getCarrello().get(0);
        List<CarrelloItem> carrelloItems = carrello.getCarrelloItems();
        for (CarrelloItem carrelloItem : carrelloItems) {
            if (carrelloItem.getProdotto().getId() == prodotto.getId()) {
                carrelloItem.setCarrello(carrello);
                carrelloItem.setProdotto(prodotto);
                carrelloItem.setQuantita(quantita);
                new CarrelloItemJPA().update(carrelloItem);
                return;
            }
        }
        new CarrelloItemJPA().save(new CarrelloItem(quantita, carrello, prodotto));
        resp.sendRedirect("prodotti.jsp");
    }
}


