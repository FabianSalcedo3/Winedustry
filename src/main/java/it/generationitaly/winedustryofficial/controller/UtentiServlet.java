package it.generationitaly.winedustryofficial.controller;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

import it.generationitaly.winedustryofficial.entity.Utente;
import it.generationitaly.winedustryofficial.repository.UtenteJPA;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UtentiServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("utenteID").isEmpty()) {
            Utente utente = new UtenteJPA(Utente.class).findById(Integer.parseInt(req.getParameter("utenteID")));
            req.setAttribute("utente", utente);
            req.getRequestDispatcher("utenti.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Utente> utenti = new UtenteJPA(Utente.class).findAll();
        if (!utenti.isEmpty()) {
            req.setAttribute("utenti", utenti);
            req.getRequestDispatcher("utenti.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
