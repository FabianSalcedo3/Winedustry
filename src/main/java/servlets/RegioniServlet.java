package servlets;

import entities.Regione;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.datasource.RegioneJPA;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/RegioniServlet")
public class RegioniServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Regione regione = new RegioneJPA().findById(req.getParameter("regioneID"));
        if (regione != null) {
            req.setAttribute("regione", regione);
            req.getRequestDispatcher("regione/regione.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("home/home.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Regione> regioni = new RegioneJPA().findAll();
        if (!regioni.isEmpty()) {
            req.setAttribute("regioni", regioni);
            req.getRequestDispatcher("regioni.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }


}