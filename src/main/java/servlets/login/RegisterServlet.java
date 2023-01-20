package servlets.login;

import entities.Utente;
import entities.carrello.Carrello;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.carrello.CarrelloJPA;
import repository.utente.UtenteJPA;
import utils.ParametersValidation;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final ParametersValidation pv = new ParametersValidation();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String isInvalid = "is-invalid";
        if (pv.isValidString(username)) {
            if (pv.isValidString(password)) {
                if (pv.isValidString(email)) {
                    if (isValidUsername(username)) {
                        if (isValidEmail(email)) {
                            Utente utente = new Utente(email, username, password);
                            Carrello carrello = new Carrello(utente);
                            new UtenteJPA().save(utente);
                            new CarrelloJPA().save(carrello);
                            HttpSession oldSession = req.getSession(false);
                            if (oldSession != null) {
                                oldSession.invalidate();
                            }
                            HttpSession currentSession = req.getSession();
                            currentSession.setAttribute("user", utente.getUsername());
                            currentSession.setMaxInactiveInterval(15 * 60);
                            resp.sendRedirect("home/home.jsp");
                        } else {
                            req.setAttribute("invalidEmail", "Email già utilizzata");
                            req.setAttribute("isInvalidEmail", isInvalid);
                            req.getRequestDispatcher("login.jsp").forward(req, resp);
                        }
                    } else {
                        req.setAttribute("invalidUsername", "Username non disponibile");
                        req.setAttribute("isInvalidUsername", isInvalid);
                        req.getRequestDispatcher("login.jsp").forward(req, resp);
                    }
                } else {
                    req.setAttribute("invalidEmail", "Inserisci una email");
                    req.setAttribute("isInvalidEmail", isInvalid);
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("invalidPassword", "Inserisci una password");
                req.setAttribute("isInvalidPassword", isInvalid);
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("invalidUsername", "Inserisci un username");
            req.setAttribute("isInvalidUsername", isInvalid);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    private boolean isValidUsername(String username) {
        return (new UtenteJPA().findBySomething("where username=?1", username) == null);
    }

    private boolean isValidEmail(String email) {
        return (new UtenteJPA().findBySomething("where email=?1", email) == null);
    }

}
