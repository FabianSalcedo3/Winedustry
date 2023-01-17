package entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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

	@Column(name = "descrizione", nullable = false, length = 6000)
	private String descrizione;

	@Column(name = "immagine", nullable = false, length = 2000)
	private String immagine;

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

	@Override
	public String toString() {
		return "Regione{" + "id=" + id + ", nome='" + nome + '\'' + ", capoluogo='" + capoluogo + '\'' + '}';
	}

}
