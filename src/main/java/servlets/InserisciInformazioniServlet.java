package servlets;

import entities.Informazioni;
import entities.Utente;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.datasource.InformazioniJPA;
import repository.datasource.UtenteJPA;

import java.io.IOException;
import java.io.Serial;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/InserisciInformazioniServlet")
public class InserisciInformazioniServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nome = req.getParameter("uNome");
        String cognome = req.getParameter("uCognome");
        String codiceFiscale = req.getParameter("uCodiceFiscale");
        LocalDate dataNascita = LocalDate.parse(req.getParameter("uDataNascita"));
        String telefono = req.getParameter("uTelefono");
        int uID = (Integer) req.getSession().getAttribute("uID");
        Utente utente = new UtenteJPA().findById(uID);
        List<Informazioni> informazioni = utente.getInformazioni();
        for (Informazioni informazione : informazioni) {
            if (informazione != null) {
                informazione.setNome(nome);
                informazione.setCognome(cognome);
                informazione.setCodiceFiscale(codiceFiscale);
                informazione.setDataNascita(dataNascita);
                informazione.setTelefono(telefono);
                new InformazioniJPA().update(informazione);
            } else {
                new InformazioniJPA().save(new Informazioni(nome, cognome, codiceFiscale, dataNascita, telefono, utente));
            }
        }
        resp.sendRedirect("utente.jsp");
    }
}

