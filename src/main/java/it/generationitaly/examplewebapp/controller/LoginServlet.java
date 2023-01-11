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
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UtenteRepository utenteRepository = new UtenteRepositoryImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		boolean hasErrors = false;
		
		if ("".equals(username)) {
			request.setAttribute("error-username", "il campo username è obbligatorio");
			hasErrors = true;
		}

		if ("".equals(password)) {
			request.setAttribute("error-password", "il campo password è obbligatorio");

			hasErrors = true;
		}

		if (hasErrors) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		Utente utente = utenteRepository.findByUsername(username);
		
		if (utente != null && utente.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("utenteId", utente.getId());
			session.setAttribute("utenteUsername", utente.getUsername());
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}


	}

}
