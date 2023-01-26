package servlets.ordine;

import entities.ordine.Ordine;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.datasource.UtenteJPA;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/RicercaOrdiniServlet")
public class RicercaOrdiniServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uID = (Integer) req.getSession().getAttribute("uID");
        List<Ordine> ordini = new UtenteJPA().findById(uID).getOrdini();
        if (!ordini.isEmpty()) {
            req.setAttribute("ordini", ordini);
            req.getRequestDispatcher("prodotto.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("ordini.jsp");
        }

    }

}
