package utils;

import entities.Utente;

public class ParametersValidation {

    public boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isValidUser(String id) {
        return (id != null && !id.isEmpty() && isInteger(id));
    }

    public boolean isValidString(String value) {
        return (value != null && !value.isEmpty());
    }

    public boolean existInformazioni(Utente utente) {
        return (utente != null && utente.getInformazioni() != null);
    }

    public boolean isValidInteger(String value) {
        return (value != null && !value.isEmpty() && isInteger(value));
    }

    public boolean isValidDouble(String value) {
        return (value != null && !value.isEmpty() && isDouble(value));
    }

}
