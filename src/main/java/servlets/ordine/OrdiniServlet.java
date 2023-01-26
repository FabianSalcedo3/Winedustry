package servlets.ordine;

import entities.ordine.Ordine;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.datasource.ordine.OrdineJPA;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/OrdiniServlet")
public class OrdiniServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Ordine ordine = new OrdineJPA().findById(req.getParameter("oID"));
        if (ordine != null) {
            req.setAttribute("ordine", ordine);
            req.getRequestDispatcher("ordini.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ordine> ordini = new OrdineJPA().findAll();
        if (!ordini.isEmpty()) {
            req.setAttribute("ordini", ordini);
            req.getRequestDispatcher("ordini.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

}
