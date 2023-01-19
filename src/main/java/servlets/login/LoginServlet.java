package servlets.login;

import java.io.IOException;
import java.io.Serial;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import entities.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.utente.UtenteJPA;

@WebServlet("/LoginServlet")
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AtomicReference<String> usernameTemp = new AtomicReference<>();
		List<Utente> utenti = new UtenteJPA(Utente.class).findAll();
		AtomicBoolean isValidateUsername = new AtomicBoolean(false);
		AtomicBoolean isValidatePassword = new AtomicBoolean(false);
		if (username.isEmpty() && password.isEmpty()) {
			request.setAttribute("validationUsername", "is-invalid");
			request.setAttribute("validationPassword", "is-invalid");
			request.setAttribute("errorUsernameLogin", "Inserisci un username!");
			request.setAttribute("errorPasswordLogin", "Inserisci una password!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		} else if (username.isEmpty()) {
			request.setAttribute("validationUsername", "is-invalid");
			request.setAttribute("errorUserLogin", "Inserisci un username!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		utenti.forEach(utente -> {
			if (utente.getUsername().equals(username)) {
				isValidateUsername.set(true);
				if (utente.getPassword().equals(password)) {
					isValidatePassword.set(true);
					usernameTemp.set(utente.getUsername());
				}
			}
		});
		if (!isValidateUsername.get()) {
			request.setAttribute("validationUsername", "is-invalid");
			request.setAttribute("errorUsernameLogin", "Username non trovato!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else if (!isValidatePassword.get()) {
			request.setAttribute("validationPassword", "is-invalid");
			request.setAttribute("errorPasswordLogin", "Password errata!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else if (isValidateUsername.get() && isValidatePassword.get()) {
			HttpSession oldSession = request.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}
			HttpSession currentSession = request.getSession();
			currentSession.setAttribute("user", usernameTemp.get());
			currentSession.setMaxInactiveInterval(15 * 60);
			response.sendRedirect("home/home.jsp");
		}
	}

}
