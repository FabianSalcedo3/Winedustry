package utils;

import entities.Utente;

public interface InterfaceStringValidation {

	static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	static boolean isDouble(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	static boolean isValidUser(String id) {
		return (id != null && !id.isEmpty() && isInteger(id));
	}

	static boolean isValidString(String value) {
		return (value != null && !value.isEmpty());
	}

	static boolean existInformazioni(Utente utente) {
		return (utente != null && utente.getInformazioni() != null);
	}

	static boolean isValidInteger(String value) {
		return (value != null && !value.isEmpty() && isInteger(value));
	}

	static boolean isValidDouble(String value) {
		return (value != null && !value.isEmpty() && isDouble(value));
	}

}
