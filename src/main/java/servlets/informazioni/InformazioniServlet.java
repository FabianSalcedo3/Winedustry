package servlets.informazioni;

import entities.Informazioni;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.informazioni.InformazioniJPA;
import repository.utente.UtenteJPA;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/InformazioniServlet")
public class InformazioniServlet extends HttpServlet implements Servlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Informazioni> informazioni = new UtenteJPA().findById("uID").getInformazioni();
        for (Informazioni informazione : informazioni) {
            if (informazione != null) {
                req.setAttribute("informazioni", informazione);
                req.getRequestDispatcher("informazioni.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("test.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Informazioni> informazioniList = new InformazioniJPA().findAll();
        if (!informazioniList.isEmpty()) {
            req.setAttribute("informazioniList", informazioniList);
            req.getRequestDispatcher("informazioni.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

}
