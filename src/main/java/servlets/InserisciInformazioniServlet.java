package servlets;

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
		if (utenteID != null && !utenteID.isEmpty() && isInteger(utenteID)) {
			Utente utente = new UtenteJPA(Utente.class).findById(Integer.parseInt(utenteID));
			if (utente != null && utente.getInformazioni() == null) {
				Informazioni informazioni = new Informazioni();
				if (utenteNome != null && !utenteNome.isEmpty()) {
					informazioni.setNome(utenteNome);
				} else if (utenteCognome != null && !utenteCognome.isEmpty()) {
					informazioni.setCognome(utenteCognome);
				} else if (utenteCodiceFiscale != null && !utenteCodiceFiscale.isEmpty()) {
					informazioni.setCodiceFiscale(utenteCodiceFiscale);
				} else if (utenteDataNascita != null && !utenteDataNascita.isEmpty()) {
					informazioni.setDataNascita(LocalDate.parse(utenteDataNascita));
				} else if (utenteTelefono != null && !utenteTelefono.isEmpty()) {
					informazioni.setTelefono(utenteTelefono);
				}
				informazioni.setId(utente.getId());
				new InformazioniJPA(Informazioni.class).save(informazioni);
				return;
			} else if (utente != null && utente.getInformazioni() != null) {
				Informazioni informazioni = new InformazioniJPA(Informazioni.class).findById(utente.getInformazioni().getId());
				if (utenteNome != null && !utenteNome.isEmpty()) {
					informazioni.setNome(utenteNome);
				} else if (utenteCognome != null && !utenteCognome.isEmpty()) {
					informazioni.setCognome(utenteCognome);
				} else if (utenteCodiceFiscale != null && !utenteCodiceFiscale.isEmpty()) {
					informazioni.setCodiceFiscale(utenteCodiceFiscale);
				} else if (utenteDataNascita != null && !utenteDataNascita.isEmpty()) {
					informazioni.setDataNascita(LocalDate.parse(utenteDataNascita));
				} else if (utenteTelefono != null && !utenteTelefono.isEmpty()) {
					informazioni.setTelefono(utenteTelefono);
				}
				new InformazioniJPA(Informazioni.class).save(informazioni);
			}
		}
		resp.sendRedirect("utente.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	private boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
