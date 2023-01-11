package it.generationitaly.examplewebapp.controller;

import java.io.IOException;
import java.util.List;

import it.generationitaly.examplewebapp.entity.Studente;
import it.generationitaly.examplewebapp.repository.StudenteRepository;
import it.generationitaly.examplewebapp.repository.impl.StudenteRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListaStudentiServlet")
public class ListaStudentiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static StudenteRepository studenteRepository = new StudenteRepositoryImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Studente> studenti = studenteRepository.findAll();
		request.setAttribute("studenti", studenti);
		request.getRequestDispatcher("studenti.jsp").forward(request,response);
	}

}
