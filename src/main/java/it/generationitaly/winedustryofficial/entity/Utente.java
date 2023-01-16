package it.generationitaly.winedustryofficial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "utente")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "email", length = 100, unique = true, nullable = false)
	private String email;

	@Column(name = "username", length = 50, unique = true, nullable = false)
	private String username;

	@Column(name = "password", length = 20, nullable = false)
	private String password;

	@OneToOne(mappedBy = "utente", fetch = FetchType.EAGER)
	private Indirizzo indirizzo;

	@OneToOne(mappedBy = "utente", fetch = FetchType.EAGER)
	private Informazioni informazioni;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Informazioni getInformazioni() {
		return informazioni;
	}

	public void setInformazioni(Informazioni informazioni) {
		this.informazioni = informazioni;
	}

}