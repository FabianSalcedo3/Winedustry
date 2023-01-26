package servlets.ordine;

import entities.ordine.Carrello;
import entities.ordine.CarrelloItem;
import entities.prodotto.Prodotto;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.datasource.ordine.CarrelloItemJPA;
import repository.datasource.UtenteJPA;
import repository.datasource.prodotto.ProdottoJPA;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/InserisciCarrelloItemServlet")
public class InserisciCarrelloItemServlet extends HttpServlet implements Servlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int quantita = Integer.parseInt(req.getParameter("pQuantita"));
        Prodotto prodotto = new ProdottoJPA().findById(req.getParameter("pID"));
        int uID = (Integer) req.getSession().getAttribute("uID");
        Carrello carrello = new UtenteJPA().findById(uID).getCarrello().get(0);
        List<CarrelloItem> carrelloItems = carrello.getCarrelloItems();
        for (CarrelloItem carrelloItem : carrelloItems) {
            if (carrelloItem.getProdotto().getId() == prodotto.getId()) {
                carrelloItem.setCarrello(carrello);
                carrelloItem.setProdotto(prodotto);
                carrelloItem.setQuantita(carrelloItem.getQuantita() + quantita);
                new CarrelloItemJPA().update(carrelloItem);
                req.setAttribute("prodotti", new ProdottoJPA().findAll());
                req.getRequestDispatcher("shop/shop.jsp").forward(req, resp);
                return;
            }
        }
        new CarrelloItemJPA().save(new CarrelloItem(quantita, carrello, prodotto));
        req.setAttribute("prodotti", new ProdottoJPA().findAll());
        req.getRequestDispatcher("shop/shop.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new CarrelloItemJPA().deleteById(req.getParameter("cItemID"));
        resp.sendRedirect("cart/cart.jsp");
    }
}