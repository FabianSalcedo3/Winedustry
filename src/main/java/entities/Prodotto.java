package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prodotto")
public class Prodotto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nome", length = 50, nullable = false)
	private String nome;

	@Column(name = "categoria", length = 50)
	private String categoria;

	@Column(name = "vitigno", length = 50, nullable = false)
	private String vitigno;

	@Column(name = "annata")
	private int annata;

	@Column(name = "formato")
	private double formato;

	@Column(name = "gradazione")
	private int gradazione;

	@Column(name = "prezzo", nullable = false)
	private double prezzo;

	@Column(name = "denominazione", length = 50)
	private String denominazione;

	@Column(name = "valutazione")
	private int valutazione;

	@Column(name = "immagine", length = 500)
	private String immagine;

	@Column(name = "descrizione", length = 5000)
	private String descrizione;

	@OneToOne
	@JoinColumn(name = "regione_id")
	private Regione regione;

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

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public int getValutazione() {
		return valutazione;
	}

	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Regione getRegione() {
		return regione;
	}

	public void setRegione(Regione regione) {
		this.regione = regione;
	}

	@Override
	public String toString() {
		return "Prodotto{" + "id=" + id + ", nome='" + nome + '\'' + ", categoria='" + categoria + '\'' + ", vitigno='" + vitigno + '\'' + ", annata=" + annata + ", formato=" + formato + ", gradazione=" + gradazione + ", prezzo=" + prezzo + ", denominazione='" + denominazione + '\'' + ", valutazione=" + valutazione + ", immagine='" + immagine + '\'' + ", descrizione='" + descrizione + '\'' + '}';
	}
}
