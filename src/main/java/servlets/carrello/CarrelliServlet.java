package servlets.carrello;

import entities.carrello.Carrello;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.carrello.CarrelloJPA;
import repository.utente.UtenteJPA;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/CarrelliServlet")
public class CarrelliServlet extends HttpServlet implements Servlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Carrello carrello = new UtenteJPA().findById(req.getParameter("uID")).getCarrello().get(0);
        if (carrello != null) {
            req.setAttribute("carrello", carrello);
            req.getRequestDispatcher("carrello.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("test.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Carrello> carrelli = new CarrelloJPA().findAll();
        if (!carrelli.isEmpty()) {
            req.setAttribute("carrelli", carrelli);
            req.getRequestDispatcher("carrello.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

}
