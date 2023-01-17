package servlets;

import java.io.IOException;
import java.io.Serial;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import entities.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.utente.UtenteJPA;

public class LoginServlet extends HttpServlet {

	@Serial
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession oldSession = request.getSession(false);
		if (oldSession != null) {
			oldSession.invalidate();
		}
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		AtomicReference<String> username = new AtomicReference<>();
		String password = request.getParameter("password");
		List<Utente> utenti = new UtenteJPA(Utente.class).findAll();
		AtomicBoolean isValidateEmail = new AtomicBoolean(false);
		AtomicBoolean isValidatePassword = new AtomicBoolean(false);
		if (email.isEmpty() && password.isEmpty()) {
			request.setAttribute("validationEmail", "is-invalid");
			request.setAttribute("validationPassword", "is-invalid");
			request.setAttribute("errorMailLogin", "Inserisci una e-mail!");
			request.setAttribute("errorPasswordLogin", "Inserisci una password!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		} else if (email.isEmpty()) {
			request.setAttribute("validationEmail", "is-invalid");
			request.setAttribute("errorUserLogin", "Inserisci una e-mail!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		utenti.forEach(utente -> {
			if (utente.getEmail().equals(email)) {
				isValidateEmail.set(true);
				if (utente.getPassword().equals(password)) {
					isValidatePassword.set(true);
					username.set(utente.getEmail());
				}
			}
		});
		if (!isValidateEmail.get()) {
			request.setAttribute("validationEmail", "is-invalid");
			request.setAttribute("errorMailLogin", "E-mail non trovata!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else if (!isValidatePassword.get()) {
			request.setAttribute("validationPassword", "is-invalid");
			request.setAttribute("errorPasswordLogin", "Password errata!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else if (isValidateEmail.get() && isValidatePassword.get()) {
			HttpSession oldSession = request.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}
			HttpSession currentSession = request.getSession();
			currentSession.setAttribute("user", username.get());
			currentSession.setMaxInactiveInterval(15 * 60);
			response.sendRedirect("home.jsp");
		}
	}

}
