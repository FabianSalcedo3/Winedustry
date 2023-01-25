package servlets.login;

import entities.Utente;
import entities.ordine.Carrello;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.datasource.CarrelloJPA;
import repository.datasource.UtenteJPA;

import java.io.IOException;
import java.io.Serial;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        AtomicBoolean isValidUsername = new AtomicBoolean(true);
        AtomicBoolean isValidEmail = new AtomicBoolean(true);
        List<Utente> utenti = new UtenteJPA().findAll();
        utenti.forEach(utente -> {
            if (utente.getUsername().equalsIgnoreCase(username)) {
                isValidUsername.set(false);
            }
            if (utente.getEmail().equalsIgnoreCase(email)) {
                isValidEmail.set(false);
            }
        });
        if (isValidUsername.get() && isValidEmail.get()) {
            Utente utente = new Utente(email, username, password);
            new UtenteJPA().save(utente);
            new CarrelloJPA().save(new Carrello(utente));
            HttpSession oldSession = req.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            HttpSession currentSession = req.getSession();
            int uID = new UtenteJPA().findByUsername(username).getId();
            currentSession.setAttribute("uID", uID);
            currentSession.setMaxInactiveInterval(30 * 60);
            resp.sendRedirect("home/home.jsp");
            return;
        } else if (!isValidUsername.get()) {
            System.out.println("username già utilizzato");
            req.setAttribute("errorUsername", true);
            req.getRequestDispatcher("login/registrazione.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("errorEmail", true);
        req.getRequestDispatcher("login/registrazione.jsp").forward(req, resp);
    }
}