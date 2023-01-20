package servlets;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

import entities.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.utente.UtenteJPA;
import utils.ParametersValidation;

public class UtentiServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final ParametersValidation pv = new ParametersValidation();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String utenteID = req.getParameter("utenteID");
    	if (pv.isValidString(utenteID)) {
            Utente utente = new UtenteJPA().findById(Integer.parseInt(req.getParameter("utenteID")));
            req.setAttribute("utente", utente);
            req.getRequestDispatcher("utenti.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Utente> utenti = new UtenteJPA().findAll();
        if (!utenti.isEmpty()) {
            req.setAttribute("utenti", utenti);
            req.getRequestDispatcher("utenti.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
   
    
}
