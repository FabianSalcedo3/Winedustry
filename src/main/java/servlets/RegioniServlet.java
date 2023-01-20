package servlets;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

import entities.Regione;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.regione.RegioneJPA;
import utils.ParametersValidation;

@WebServlet("/RegioniServlet")
public class RegioniServlet extends HttpServlet {

	@Serial
	private static final long serialVersionUID = 1L;

	private static final ParametersValidation pv = new ParametersValidation();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String regioneID = req.getParameter("regioneID");
		if (pv.isValidString(regioneID)) {
			Regione regione = new RegioneJPA().findById(Integer.parseInt(req.getParameter("regioneID")));
			req.setAttribute("regione", regione);
			req.getRequestDispatcher("regione.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("test.jsp");
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