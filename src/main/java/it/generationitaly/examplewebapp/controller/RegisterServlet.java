package it.generationitaly.examplewebapp.controller;

import java.io.IOException;

import it.generationitaly.examplewebapp.entity.Utente;
import it.generationitaly.examplewebapp.repository.UtenteRepository;
import it.generationitaly.examplewebapp.repository.impl.UtenteRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UtenteRepository utenteRepository = new UtenteRepositoryImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Utente utenteVerifica = utenteRepository.findByUsername(username);
		
		if(utenteVerifica != null) {
			request.setAttribute("username-error", "Username esistente");
			response.sendRedirect("register.jsp");
		}else {
			Utente utente = new Utente();
			utente.setUsername(username);
			utente.setPassword(password);
			utenteRepository.saveUtente(utente);
			response.sendRedirect("login.jsp");
		}
	}

}
