package it.generationitaly.examplewebapp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import it.generationitaly.examplewebapp.entity.Corso;
import it.generationitaly.examplewebapp.entity.Studente;
import it.generationitaly.examplewebapp.repository.CorsoRepository;
import it.generationitaly.examplewebapp.repository.impl.CorsoRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateCorsoServlet")
public class UpdateCorsoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static CorsoRepository corsoRepository = new CorsoRepositoryImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Corso corso = corsoRepository.findById(id);
		request.setAttribute("corso", corso);
		request.getRequestDispatcher("modifica-corso.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String codice = request.getParameter("codice");
		String nome = request.getParameter("nome");
		int cfu = Integer.parseInt(request.getParameter("cfu"));

		Corso corso = new Corso();
		corso.setId(id);
		corso.setCodice(codice);
		corso.setNome(nome);
		corso.setCfu(cfu);

		corsoRepository.update(corso);
		response.sendRedirect("ListaCorsiServlet");
	}


}
