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

@WebServlet("/AggiungiStudenteServlet")
public class AggiungiStudenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static StudenteRepository studenteRepository = new StudenteRepositoryImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codiceFiscale =  request.getParameter("codiceFiscale");
		int matricola =  Integer.parseInt(request.getParameter("matricola"));
		String nome =  request.getParameter("nome");
		String cognome =  request.getParameter("cognome");
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
		studente.setCodiceFiscale(codiceFiscale);
		studente.setMatricola(matricola);
		studente.setNome(nome);
		studente.setCognome(cognome);
		studente.setDataNascita(dataNascita);
		studente.setSesso(sesso.charAt(0));
		
		studenteRepository.save(studente);
		response.sendRedirect("ListaStudentiServlet");
	}

}
