package it.generationitaly.examplewebapp.controller;

import java.io.IOException;
import java.util.List;

import it.generationitaly.examplewebapp.entity.Corso;
import it.generationitaly.examplewebapp.repository.CorsoRepository;
import it.generationitaly.examplewebapp.repository.impl.CorsoRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListaCorsiServlet")
public class ListaCorsiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static CorsoRepository corsoRepository = new CorsoRepositoryImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Corso> corsi = corsoRepository.findAll();
		request.setAttribute("corsi", corsi);
		request.getRequestDispatcher("corsi.jsp").forward(request, response);
	}

}
