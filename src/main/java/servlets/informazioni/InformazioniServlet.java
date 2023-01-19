package servlets.informazioni;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

import entities.Informazioni;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.informazioni.InformazioniJPA;

@WebServlet("/InformazioniServlet")
public class InformazioniServlet extends HttpServlet implements Servlet {

	@Serial
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String informazioniID = req.getParameter("informazioniID");
		if (isValidString(informazioniID)) {
			Informazioni informazioni = new InformazioniJPA(Informazioni.class).findById(Integer.parseInt(req.getParameter("informazioniID")));
			req.setAttribute("informazioni", informazioni);
			req.getRequestDispatcher("informazioni.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("test.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Informazioni> informazioniList = new InformazioniJPA(Informazioni.class).findAll();
		if (!informazioniList.isEmpty()) {
			req.setAttribute("informazioniList", informazioniList);
			req.getRequestDispatcher("informazioni.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("index.jsp");
		}
	}

	private boolean isValidString(String value) {
		return (value != null && !value.isEmpty());
	}

}
