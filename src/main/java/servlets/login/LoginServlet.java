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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession oldSession = req.getSession(false);
		if (oldSession != null) {
			oldSession.invalidate();
		}
		resp.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		AtomicReference<String> usernameTemp = new AtomicReference<>();
		List<Utente> utenti = new UtenteJPA().findAll();
		AtomicBoolean isValidateUsername = new AtomicBoolean(false);
		AtomicBoolean isValidatePassword = new AtomicBoolean(false);
		if (username.isEmpty() && password.isEmpty()) {
			req.setAttribute("validationUsername", "is-invalid");
			req.setAttribute("validationPassword", "is-invalid");
			req.setAttribute("errorUsernameLogin", "Inserisci un username!");
			req.setAttribute("errorPasswordLogin", "Inserisci una password!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		} else if (username.isEmpty()) {
			req.setAttribute("validationUsername", "is-invalid");
			req.setAttribute("errorUserLogin", "Inserisci un username!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
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
			req.setAttribute("validationUsername", "is-invalid");
			req.setAttribute("errorUsernameLogin", "Username non trovato!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else if (!isValidatePassword.get()) {
			req.setAttribute("validationPassword", "is-invalid");
			req.setAttribute("errorPasswordLogin", "Password errata!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else if (isValidateUsername.get() && isValidatePassword.get()) {
			HttpSession oldSession = req.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}
			HttpSession currentSession = req.getSession();
			currentSession.setAttribute("user", usernameTemp.get());
			currentSession.setMaxInactiveInterval(15 * 60);
			resp.sendRedirect("home/home.jsp");
		}
	}

}
