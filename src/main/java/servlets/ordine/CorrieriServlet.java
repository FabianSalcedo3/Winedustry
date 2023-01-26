package servlets.ordine;

import entities.ordine.Corriere;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.datasource.ordine.CorriereJPA;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/CorrieriServlet")
public class CorrieriServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Corriere corriere = new CorriereJPA().findById(req.getParameter("cID"));
        if (corriere != null) {
            req.setAttribute("corriere", corriere);
            req.getRequestDispatcher("corrieri.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Corriere> corrieri = new CorriereJPA().findAll();
        if (!corrieri.isEmpty()) {
            req.setAttribute("corrieri", corrieri);
            req.getRequestDispatcher("corrieri.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

}
