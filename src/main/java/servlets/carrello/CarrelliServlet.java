package servlets.carrello;

import entities.carrello.Carrello;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.carrello.CarrelloJPA;
import utils.ParametersValidation;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/CarrelliServlet")
public class CarrelliServlet extends HttpServlet implements Servlet {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final ParametersValidation pv = new ParametersValidation();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carrelloID = req.getParameter("carrelloID");
        if (pv.isValidString(carrelloID)) {
            Carrello carrello = new CarrelloJPA().findById(Integer.parseInt(req.getParameter("carrelloID")));
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
