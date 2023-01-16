package it.generationitaly.winedustryofficial.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "regione")
public class Regione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nome", length = 50, nullable = false)
	private String nome;

	@Column(name = "capoluogo", length = 50, nullable = false)
	private String capoluogo;

	@OneToMany(mappedBy = "regione", fetch = FetchType.EAGER)
	private List<Prodotto> vini = new ArrayList<>();

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

	public String getCapoluogo() {
		return capoluogo;
	}

	public void setCapoluogo(String capoluogo) {
		this.capoluogo = capoluogo;
	}

	public List<Prodotto> getVini() {
		return vini;
	}

	public void setVini(List<Prodotto> vini) {
		this.vini = vini;
	}

}
