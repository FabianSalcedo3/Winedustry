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
@Table(name = "ordine")
public class Ordine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne
	@JoinColumn(name = "utente_id")
	private Utente utente;

	@Column(name = "totale")
	private double totale;

	@OneToOne
	@JoinColumn(name = "carrello_id")
	private CarrelloItem carrelloItem;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}

	public CarrelloItem getCarrelloItem() {
		return carrelloItem;
	}

	public void setCarrelloItem(CarrelloItem carrelloItem) {
		this.carrelloItem = carrelloItem;
	}

}
