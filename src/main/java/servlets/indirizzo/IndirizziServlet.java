package servlets.indirizzo;

import entities.Indirizzo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.indirizzo.IndirizzoJPA;
import utils.ParametersValidation;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/IndirizziServlet")
public class IndirizziServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final ParametersValidation pv = new ParametersValidation();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String indirizzoID = req.getParameter("indirizzoID");
        if (pv.isValidString(indirizzoID)) {
            Indirizzo indirizzo = new IndirizzoJPA().findById(Integer.parseInt(req.getParameter("indirizzoID")));
            req.setAttribute("indirizzo", indirizzo);
            req.getRequestDispatcher("indirizzo.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("test.jsp");
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