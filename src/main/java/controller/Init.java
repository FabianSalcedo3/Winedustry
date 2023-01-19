package controller;

import java.time.LocalDate;

import entities.Informazioni;
import entities.Utente;
import repository.informazioni.InformazioniJPA;
import repository.utente.UtenteJPA;

public class Init {

	public static void main(String[] args) {
		String utenteID = "2";
		String utenteNome = "Test";
		String utenteCognome = "Test";
		String utenteCodiceFiscale = "cfTest";
		String utenteDataNascita = "2013-05-21";
		String utenteTelefono = "8888888888";
		if (isValidUser(utenteID)) {
			Utente utente = new UtenteJPA(Utente.class).findById(Integer.parseInt(utenteID));
			if (!existInformazioni(utente)) {
				Informazioni informazioni = new Informazioni();
				if (isValidString(utenteNome)) {
					informazioni.setNome(utenteNome);
				}
				if (isValidString(utenteCognome)) {
					informazioni.setCognome(utenteCognome);
				}
				if (isValidString(utenteCodiceFiscale)) {
					informazioni.setCodiceFiscale(utenteCodiceFiscale);
				}
				if (isValidString(utenteDataNascita)) {
					informazioni.setDataNascita(LocalDate.parse(utenteDataNascita));
				}
				if (isValidString(utenteTelefono)) {
					informazioni.setTelefono(utenteTelefono);
				}
				informazioni.setId(utente.getId());
				new InformazioniJPA(Informazioni.class).save(informazioni);

				return;
			} else {
				Informazioni informazioni = new InformazioniJPA(Informazioni.class).findById(utente.getInformazioni().getId());
				if (isValidString(utenteNome)) {
					informazioni.setNome(utenteNome);
				}
				if (isValidString(utenteCognome)) {
					informazioni.setCognome(utenteCognome);
				}
				if (isValidString(utenteCodiceFiscale)) {
					informazioni.setCodiceFiscale(utenteCodiceFiscale);
				}
				if (isValidString(utenteDataNascita)) {
					informazioni.setDataNascita(LocalDate.parse(utenteDataNascita));
				}
				if (isValidString(utenteTelefono)) {
					informazioni.setTelefono(utenteTelefono);
				}
				new InformazioniJPA(Informazioni.class).update(informazioni);
				System.out.println(informazioni);
			}
		}
	}

	private static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static boolean isValidUser(String id) {
		return (id != null && !id.isEmpty() && isInteger(id));
	}

	private static boolean isValidString(String value) {
		return (value != null && !value.isEmpty());
	}

	private static boolean existInformazioni(Utente utente) {
		return (utente != null && utente.getInformazioni() == null);
	}

}
