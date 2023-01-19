package servlets.informazioni;

import java.io.IOException;
import java.io.Serial;
import java.time.LocalDate;

import entities.Informazioni;
import entities.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.informazioni.InformazioniJPA;
import repository.utente.UtenteJPA;
import utils.InterfaceStringValidation;

@WebServlet("/InserisciInformazioniServlet")
public class InserisciInformazioniServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String utenteID = req.getParameter("utenteID");
        String utenteNome = req.getParameter("utenteNome");
        String utenteCognome = req.getParameter("utenteCognome");
        String utenteCodiceFiscale = req.getParameter("utenteCodiceFiscale");
        String utenteDataNascita = req.getParameter("utenteDataNascita");
        String utenteTelefono = req.getParameter("utenteTelefono");
        if (InterfaceStringValidation.isValidUser(utenteID)) {
            Utente utente = new UtenteJPA(Utente.class).findById(Integer.parseInt(utenteID));
            if (InterfaceStringValidation.existInformazioni(utente)) {
                Informazioni informazioni = utente.getInformazioni();
                if (InterfaceStringValidation.isValidString(utenteNome)) {
                    informazioni.setNome(utenteNome);
                }
                if (InterfaceStringValidation.isValidString(utenteCognome)) {
                    informazioni.setCognome(utenteCognome);
                }
                if (InterfaceStringValidation.isValidString(utenteCodiceFiscale)) {
                    informazioni.setCodiceFiscale(utenteCodiceFiscale);
                }
                if (InterfaceStringValidation.isValidString(utenteDataNascita)) {
                    informazioni.setDataNascita(LocalDate.parse(utenteDataNascita));
                }
                if (InterfaceStringValidation.isValidString(utenteCodiceFiscale)) {
                    informazioni.setTelefono(utenteTelefono);
                }
                new InformazioniJPA(Informazioni.class).update(informazioni);
            } else {
                Informazioni informazioni = new Informazioni(utenteNome, utenteCognome, utenteCodiceFiscale, LocalDate.parse(utenteDataNascita), utenteTelefono, utente);
                new InformazioniJPA(Informazioni.class).save(informazioni);
            }
        }
        resp.sendRedirect("utente.jsp");
    }

}
