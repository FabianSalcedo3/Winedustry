package servlets.carrello;

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
import utils.ParametersValidation;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/InserisciCarrelloItemServlet")
public class InserisciCarrelloItemServlet extends HttpServlet implements Servlet {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final ParametersValidation pv = new ParametersValidation();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String utenteID = req.getParameter("utenteID");
        String prodottoID = req.getParameter("prodottoID");
        String quantita = req.getParameter("prodottoQuantita");
        if (pv.isValidInteger(utenteID) && pv.isValidInteger(prodottoID)) {
            new CarrelloItemJPA().save(new CarrelloItem(Integer.parseInt(quantita), new ProdottoJPA().findById(Integer.parseInt(prodottoID)),
                    new UtenteJPA().findById(Integer.parseInt(utenteID)).getCarrello()));
        }
        resp.sendRedirect("prodotti.jsp");
    }


}
