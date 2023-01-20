package servlets.carrello;

import entities.carrello.CarrelloItem;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.carrello.CarrelloItemJPA;
import utils.ParametersValidation;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/CarrelloItemsServlet")
public class CarrelloItemsServlet extends HttpServlet implements Servlet {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final ParametersValidation pv = new ParametersValidation();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carrelloItemID = req.getParameter("carrelloItemID");
        if (pv.isValidString(carrelloItemID)) {
            CarrelloItem carrelloItem = new CarrelloItemJPA().findById(Integer.parseInt(req.getParameter("carrelloItemID")));
            req.setAttribute("carrelloItem", carrelloItem);
            req.getRequestDispatcher("carrelloItem.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("test.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CarrelloItem> carrelloItems = new CarrelloItemJPA().findAll();
        if (!carrelloItems.isEmpty()) {
            req.setAttribute("carrelloItems", carrelloItems);
            req.getRequestDispatcher("carrelloItem.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

}
