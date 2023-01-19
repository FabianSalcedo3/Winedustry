package servlets.login;

import entities.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.utente.UtenteJPA;
import utils.InterfaceStringValidation;

import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String isInvalid = "is-invalid";
        if (InterfaceStringValidation.isValidString(username)) {
            if (InterfaceStringValidation.isValidString(password)) {
                if (InterfaceStringValidation.isValidString(email)) {
                    if (isValidUsername(username)) {
                        if (isValidEmail(email)) {
                            Utente utente = new Utente(email, username, password);
                            new UtenteJPA(Utente.class).save(utente);
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
        return (new UtenteJPA(Utente.class).findBySomething("where username=?1", username) == null);
    }

    private boolean isValidEmail(String email) {
        return (new UtenteJPA(Utente.class).findBySomething("where email=?1", email) == null);
    }

}
