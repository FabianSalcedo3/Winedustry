package it.generationitaly.examplewebapp.controller;

import java.io.IOException;

import it.generationitaly.examplewebapp.entity.Corso;
import it.generationitaly.examplewebapp.repository.CorsoRepository;
import it.generationitaly.examplewebapp.repository.impl.CorsoRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/AggiungiCorsoServlet")
public class AggiungiCorsoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static CorsoRepository corsoRepository = new CorsoRepositoryImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String codice = request.getParameter("codice");
		String nome = request.getParameter("nome");
		int cfu = Integer.parseInt(request.getParameter("cfu"));

		Corso corso = new Corso();
		corso.setCodice(codice);
		corso.setNome(nome);
		corso.setCfu(cfu);

		corsoRepository.save(corso);
		response.sendRedirect("ListaCorsiServlet");
	}

}
