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
        List<Utente> utenti = new UtenteJPA().findAll();
        for (Utente user : utenti) {
            if (!user.getUsername().equalsIgnoreCase(username) && !user.getEmail().equalsIgnoreCase(email)) {
                Utente utente = new Utente(email, username, password);
                new UtenteJPA().save(utente);
                new CarrelloJPA().save(new Carrello(utente));
                HttpSession oldSession = req.getSession(false);
                if (oldSession != null) {
                    oldSession.invalidate();
                }
                HttpSession currentSession = req.getSession();
                currentSession.setAttribute("user", username);
                currentSession.setMaxInactiveInterval(15 * 60);
                resp.sendRedirect("home/home.jsp");
            } else if (user.getUsername().equalsIgnoreCase(username)) {
                System.out.println("username già utilizzato");
                req.setAttribute("errorUsername", true);
                req.getRequestDispatcher("login/registrazione.jsp").forward(req, resp);
            }
            return;
        }
        System.out.println("email già utilizzata");
        req.setAttribute("errorEmail", true);
        req.getRequestDispatcher("login/registrazione.jsp").forward(req, resp);
    }
}
