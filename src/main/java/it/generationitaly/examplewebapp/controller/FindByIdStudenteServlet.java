package it.generationitaly.examplewebapp.controller;

import java.io.IOException;

import it.generationitaly.examplewebapp.entity.Studente;
import it.generationitaly.examplewebapp.repository.StudenteRepository;
import it.generationitaly.examplewebapp.repository.impl.StudenteRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/studente")
public class FindByIdStudenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudenteRepository studenteRepository = new StudenteRepositoryImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Studente studente = studenteRepository.findById(1);
		System.out.println(studente);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
