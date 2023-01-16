package it.generationitaly.winedustryofficial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vino")
public class Prodotto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "produttore", length = 50, nullable = false)
	private String produttore;

	@Column(name = "categoria", length = 50, nullable = false)
	private String categoria;

	@Column(name = "vitigno", length = 50, nullable = false)
	private String vitigno;

	@Column(name = "annata", nullable = false)
	private int annata;

	@Column(name = "formato", nullable = false)
	private double formato;

	@Column(name = "gradazione", nullable = false)
	private int gradazione;

	@OneToOne
	@JoinColumn(name = "regione_id")
	private Regione regione;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduttore() {
		return produttore;
	}

	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getVitigno() {
		return vitigno;
	}

	public void setVitigno(String vitigno) {
		this.vitigno = vitigno;
	}

	public int getAnnata() {
		return annata;
	}

	public void setAnnata(int annata) {
		this.annata = annata;
	}

	public double getFormato() {
		return formato;
	}

	public void setFormato(double formato) {
		this.formato = formato;
	}

	public int getGradazione() {
		return gradazione;
	}

	public void setGradazione(int gradazione) {
		this.gradazione = gradazione;
	}

	public Regione getRegione() {
		return regione;
	}

	public void setRegione(Regione regione) {
		this.regione = regione;
	}

}
