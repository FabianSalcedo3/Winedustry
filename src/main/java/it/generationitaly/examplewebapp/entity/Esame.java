package it.generationitaly.examplewebapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "esame")
public class Esame {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "studente_id", nullable = false) // JOIN esame.studente_id = studente.id
	private Studente studente;

	@ManyToOne
	@JoinColumn(name = "corso_id", nullable = false)
	private Corso corso;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_esame", nullable = false)
	private Date dataEsame;

	@Column(name = "voto", nullable = false)
	private int voto;

	@Column(name = "lode", nullable = false)
	private boolean lode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Studente getStudente() {
		return studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

	public Date getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(Date dataEsame) {
		this.dataEsame = dataEsame;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public boolean isLode() {
		return lode;
	}

	public void setLode(boolean lode) {
		this.lode = lode;
	}

	@Override
	public String toString() {
		return "Esame [id=" + id + ", dataEsame=" + dataEsame + ", voto=" + voto + ", lode=" + lode + "]";
	}

}
