package servlets;

import entities.Indirizzo;
import entities.Utente;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.datasource.IndirizzoJPA;
import repository.datasource.UtenteJPA;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/InserisciIndirizzoServlet")
public class InserisciIndirizzoServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String via = req.getParameter("uVia");
        String civico = req.getParameter("uCivico");
        int cap = Integer.parseInt(req.getParameter("uCap"));
        String citta = req.getParameter("uCitta");
        String provincia = req.getParameter("uProvincia");
        int uID = (Integer) req.getSession().getAttribute("uID");
        Utente utente = new UtenteJPA().findById(uID);
        List<Indirizzo> indirizzi = new UtenteJPA().findById(uID).getIndirizzi();
        for (Indirizzo indirizzo : indirizzi) {
            if (indirizzo != null) {
                indirizzo.setVia(via);
                indirizzo.setCivico(civico);
                indirizzo.setCap(cap);
                indirizzo.setCitta(citta);
                indirizzo.setProvincia(provincia);
                new IndirizzoJPA().update(indirizzo);
            } else {
                new IndirizzoJPA().save(new Indirizzo(via, civico, cap, citta, provincia, utente));
            }
            resp.sendRedirect("utente.jsp");
        }
    }
}



