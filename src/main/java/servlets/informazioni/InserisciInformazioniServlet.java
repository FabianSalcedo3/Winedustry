package servlets.informazioni;

import java.io.IOException;
import java.io.Serial;
import java.time.LocalDate;

import entities.Informazioni;
import entities.Utente;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.informazioni.InformazioniJPA;
import repository.utente.UtenteJPA;
import utils.ParametersValidation;

@WebServlet("/InserisciInformazioniServlet")
public class InserisciInformazioniServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final ParametersValidation pv = new ParametersValidation();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String utenteID = req.getParameter("utenteID");
        String utenteNome = req.getParameter("utenteNome");
        String utenteCognome = req.getParameter("utenteCognome");
        String utenteCodiceFiscale = req.getParameter("utenteCodiceFiscale");
        String utenteDataNascita = req.getParameter("utenteDataNascita");
        String utenteTelefono = req.getParameter("utenteTelefono");
        if (pv.isValidUser(utenteID)) {
            Utente utente = new UtenteJPA().findById(Integer.parseInt(utenteID));
            Informazioni informazioni = new Informazioni();
            if (pv.isValidString(utenteNome)) {informazioni.setNome(utenteNome);}
            if (pv.isValidString(utenteCognome)) {informazioni.setCognome(utenteCognome);}
            if (pv.isValidString(utenteCodiceFiscale)) {informazioni.setCodiceFiscale(utenteCodiceFiscale);}
            if (pv.isValidString(utenteDataNascita)) {informazioni.setDataNascita(LocalDate.parse(utenteDataNascita));}
            if (pv.isValidString(utenteTelefono)) {informazioni.setTelefono(utenteTelefono);}
            if (pv.existInformazioni(utente)) {
                new InformazioniJPA().update(informazioni);
            } else {
                new InformazioniJPA().save(informazioni);
            }
        }
        resp.sendRedirect("utente.jsp");
    }
}

