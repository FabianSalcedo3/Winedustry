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
        List<Utente> utenti = new UtenteJPA().findAll();
        for (Utente utente : utenti) {
            if (utente.getUsername().equalsIgnoreCase(username)) {
                if (utente.getPassword().equalsIgnoreCase(password)) {
                    HttpSession oldSession = req.getSession(false);
                    if (oldSession != null) {
                        oldSession.invalidate();
                    }
                    HttpSession currentSession = req.getSession();
                    currentSession.setAttribute("user", username);
                    currentSession.setMaxInactiveInterval(15 * 60);
                    resp.sendRedirect("home/home.jsp");
                } else {
                    System.out.println("password errata");
                    req.setAttribute("errorPassword", true);
                    req.getRequestDispatcher("login/registrazione.jsp").forward(req, resp);
                }
                return;
            }
        }
        System.out.println("username non trovato");
        req.setAttribute("errorUsername", false);
        req.getRequestDispatcher("login/registrazione.jsp").forward(req, resp);
    }

}
