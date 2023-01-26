package servlets;

import entities.Indirizzo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.datasource.IndirizzoJPA;
import repository.datasource.UtenteJPA;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/IndirizziServlet")
public class IndirizziServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uID = (Integer) req.getSession().getAttribute("uID");
        List<Indirizzo> indirizzi = new UtenteJPA().findById(uID).getIndirizzi();
        for (Indirizzo indirizzo : indirizzi) {
            if (indirizzo != null) {
                req.setAttribute("indirizzo", indirizzo);
                req.getRequestDispatcher("indirizzo.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("test.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Indirizzo> indirizzi = new IndirizzoJPA().findAll();
        if (!indirizzi.isEmpty()) {
            req.setAttribute("indirizzi", indirizzi);
            req.getRequestDispatcher("indirizzi.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }


}