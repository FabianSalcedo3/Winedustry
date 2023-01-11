package it.generationitaly.examplewebapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contatti")
public class Contatti {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "email", length = 45, nullable = false)
	private String email;

	@Column(name = "telefono", length = 45, nullable = false)
	private String telefono;

	@Column(name = "domicilio", length = 45, nullable = false)
	private String domicilio;

	@OneToOne
	@JoinColumn(name = "studente_id")
	private Studente studente;

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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Studente getStudente() {
		return studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}

	@Override
	public String toString() {
		return "Contatti [id=" + id + ", email=" + email + ", telefono=" + telefono + ", domicilio=" + domicilio + "]";
	}

}
