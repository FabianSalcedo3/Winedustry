package servlets;

import entities.prodotto.Prodotto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.datasource.prodotto.ProdottoJPA;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/ProdottiServlet")
public class ProdottiServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Prodotto prodotto = new ProdottoJPA().findById(req.getParameter("prodottoID"));
        if (prodotto != null) {
            req.setAttribute("prodotto", prodotto);
            req.getRequestDispatcher("prodotto/prodotto.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("home/home.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Prodotto> prodotti = new ProdottoJPA().findAll();
        if (!prodotti.isEmpty()) {
            req.setAttribute("prodotti", prodotti);
            req.getRequestDispatcher("shop/shop.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("home/home.jsp");
        }
    }

}
