package entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "informazioni")
public class Informazioni {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;

	@Column(name = "nome", length = 50)
	String nome;

	@Column(name = "cognome", length = 50)
	String cognome;

	@Column(name = "codice_fiscale", length = 16, unique = true)
	String codiceFiscale;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascita")
	LocalDate dataNascita;

	@Column(name = "telefono", length = 10)
	String telefono;

	@OneToOne
	@JoinColumn(name = "utente_id")
	Utente utente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "Informazioni [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale + ", dataNascita=" + dataNascita
				+ ", telefono=" + telefono + "]";
	}
}
