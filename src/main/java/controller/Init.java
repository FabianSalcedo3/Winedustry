package controller;

import java.time.LocalDate;

import entities.Informazioni;
import entities.Utente;
import jakarta.persistence.criteria.CriteriaBuilder;
import repository.informazioni.InformazioniJPA;
import repository.utente.UtenteJPA;
import utils.InterfaceStringValidation;

public class Init {

    public static void main(String[] args) {
        String utenteID = "101";
        String utenteNome = "Test11";
        String utenteCognome = "";
        String utenteCodiceFiscale = "cfTest10";
        String utenteDataNascita = "2013-05-21";
        String utenteTelefono = "8888888888";
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
    }


}
