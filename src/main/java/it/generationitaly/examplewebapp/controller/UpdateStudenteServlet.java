package it.generationitaly.examplewebapp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import it.generationitaly.examplewebapp.entity.Studente;
import it.generationitaly.examplewebapp.repository.StudenteRepository;
import it.generationitaly.examplewebapp.repository.impl.StudenteRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateStudenteServlet")
public class UpdateStudenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static StudenteRepository studenteRepository = new StudenteRepositoryImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Studente studente = studenteRepository.findById(id);
		request.setAttribute("studente", studente);
		request.getRequestDispatcher("modifica-studente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String codiceFiscale = request.getParameter("codiceFiscale");
		int matricola = Integer.parseInt(request.getParameter("matricola"));
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String dataNascitaAsString = request.getParameter("dataNascita");
		String sesso = request.getParameter("sesso");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date dataNascita = null;

		try {
			dataNascita = sdf.parse(dataNascitaAsString);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}

		Studente studente = new Studente();
		studente.setId(id);
		studente.setCodiceFiscale(codiceFiscale);
		studente.setMatricola(matricola);
		studente.setNome(nome);
		studente.setCognome(cognome);
		studente.setDataNascita(dataNascita);
		studente.setSesso(sesso.charAt(0));

		studenteRepository.update(studente);
		response.sendRedirect("ListaStudentiServlet");

	}

}
