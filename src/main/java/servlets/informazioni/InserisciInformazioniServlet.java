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

@WebServlet("/InserisciInformazioniServlet")
public class InserisciInformazioniServlet extends HttpServlet {

	@Serial
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String utenteID = req.getParameter("utenteID");
		String utenteNome = req.getParameter("utenteNome");
		String utenteCognome = req.getParameter("utenteCognome");
		String utenteCodiceFiscale = req.getParameter("utenteCodiceFiscale");
		String utenteDataNascita = req.getParameter("utenteDataNascita");
		String utenteTelefono = req.getParameter("utenteTelefono");
		if (isValidUser(utenteID)) {
			Utente utente = new UtenteJPA(Utente.class).findById(Integer.parseInt(utenteID));
			if (!existInformazioni(utente)) {
				Informazioni informazioni = new Informazioni();
				if (isValidString(utenteNome)) {
					informazioni.setNome(utenteNome);
				} else if (isValidString(utenteCognome)) {
					informazioni.setCognome(utenteCognome);
				} else if (isValidString(utenteCodiceFiscale)) {
					informazioni.setCodiceFiscale(utenteCodiceFiscale);
				} else if (isValidString(utenteDataNascita)) {
					informazioni.setDataNascita(LocalDate.parse(utenteDataNascita));
				} else if (isValidString(utenteTelefono)) {
					informazioni.setTelefono(utenteTelefono);
				}
				informazioni.setId(utente.getId());
				new InformazioniJPA(Informazioni.class).save(informazioni);
				return;
			} else if (existInformazioni(utente)) {
				Informazioni informazioni = new InformazioniJPA(Informazioni.class).findById(utente.getInformazioni().getId());
				if (isValidString(utenteNome)) {
					informazioni.setNome(utenteNome);
				} else if (isValidString(utenteCognome)) {
					informazioni.setCognome(utenteCognome);
				} else if (isValidString(utenteCodiceFiscale)) {
					informazioni.setCodiceFiscale(utenteCodiceFiscale);
				} else if (isValidString(utenteDataNascita)) {
					informazioni.setDataNascita(LocalDate.parse(utenteDataNascita));
				} else if (isValidString(utenteTelefono)) {
					informazioni.setTelefono(utenteTelefono);
				}
				new InformazioniJPA(Informazioni.class).save(informazioni);
			}
		}
		resp.sendRedirect("utente.jsp");
	}

	private boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean isValidUser(String id) {
		return (id != null && !id.isEmpty() && isInteger(id));
	}

	private boolean isValidString(String value) {
		return (value != null && !value.isEmpty());
	}

	private boolean existInformazioni(Utente utente) {
		return (utente != null && utente.getInformazioni() == null);
	}

}
