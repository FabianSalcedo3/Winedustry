package it.generationitaly.winedustryofficial.servlet;

import datasource.regione.RegioneJPA;
import entity.Regione;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

public class RegioniServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("regioneID").isEmpty()) {
            Regione regione = new RegioneJPA(Regione.class).findById(Integer.parseInt(req.getParameter("regioneID")));
            req.setAttribute("regione", regione);
            req.getRequestDispatcher("regioni.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Regione> regioni = new RegioneJPA(Regione.class).findAll();
        if (!regioni.isEmpty()) {
            req.setAttribute("regioni", regioni);
            req.getRequestDispatcher("regioni.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
