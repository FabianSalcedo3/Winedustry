package servlets.login;

import entities.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.datasource.UtenteJPA;

import java.io.IOException;
import java.io.Serial;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

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
        resp.sendRedirect("login/registrazione.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        AtomicBoolean isValidUsername = new AtomicBoolean(false);
        AtomicBoolean isValidPassword = new AtomicBoolean(false);
        AtomicInteger uID = new AtomicInteger();
        List<Utente> utenti = new UtenteJPA().findAll();
        utenti.forEach(user -> {
            if (user.getUsername().equalsIgnoreCase(username)) {
                isValidUsername.set(true);
                if (user.getPassword().equals(password)) {
                    isValidPassword.set(true);
                    uID.set(user.getId());
                }
            }
        });
        if (isValidUsername.get() && isValidPassword.get()) {
            HttpSession oldSession = req.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            HttpSession currentSession = req.getSession();
            currentSession.setAttribute("uID", uID.get());
            currentSession.setMaxInactiveInterval(30 * 60);
            resp.sendRedirect("home/home.jsp");
            return;
        } else if (!isValidPassword.get()) {
            req.setAttribute("errorPassword", true);
            req.getRequestDispatcher("login/registrazione.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("errorUsername", false);
        req.getRequestDispatcher("login/registrazione.jsp").forward(req, resp);
    }
}
