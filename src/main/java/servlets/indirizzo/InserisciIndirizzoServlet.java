package servlets.indirizzo;

import entities.Indirizzo;
import entities.Utente;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.indirizzo.IndirizzoJPA;
import repository.utente.UtenteJPA;
import utils.ParametersValidation;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/InserisciIndirizzoServlet")
public class InserisciIndirizzoServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final ParametersValidation pv = new ParametersValidation();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String utenteID = req.getParameter("utenteID");
        String utenteVia = req.getParameter("utenteVia");
        String utenteCivico = req.getParameter("utenteCivico");
        String utenteCap = req.getParameter("utenteCap");
        String utenteCitta = req.getParameter("utenteCitta");
        String utenteProvincia = req.getParameter("utenteProvincia");
        if (pv.isValidUser(utenteID)) {
            Utente utente = new UtenteJPA().findById(Integer.parseInt(utenteID));
            Indirizzo indirizzo = new Indirizzo();
            if (pv.isValidString(utenteVia)) {indirizzo.setVia(utenteVia);}
            if (pv.isValidString(utenteCivico)) {indirizzo.setCivico(utenteCivico);}
            if (pv.isValidInteger(utenteCap)) {indirizzo.setCap(Integer.parseInt(utenteCap));}
            if (pv.isValidString(utenteCitta)) {indirizzo.setCitta(utenteCitta);}
            if (pv.isValidString(utenteProvincia)) {indirizzo.setProvincia(utenteProvincia);}
            if (pv.existIndirizzo(utente)) {
                new IndirizzoJPA().update(indirizzo);
            } else {
                new IndirizzoJPA().save(indirizzo);
            }
        }
        resp.sendRedirect("utente.jsp");
    }
}

