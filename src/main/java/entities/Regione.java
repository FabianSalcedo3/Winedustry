package entities;

import entities.prodotto.alcolico.Vino;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "regione")
public class Regione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "capoluogo", length = 50)
    private String capoluogo;

    @Column(name = "descrizione", length = 5000)
    private String descrizione;

    @Column(name = "immagine", length = 500)
    private String immagine;

    @OneToMany(mappedBy = "regione", fetch = FetchType.LAZY)
    private List<Vino> vini;

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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public List<Vino> getVini() {
        return vini;
    }

    public void setVini(List<Vino> vini) {
        this.vini = vini;
    }

    @Override
    public String toString() {
        return "Regione{" + "id=" + id + ", nome='" + nome + '\'' + ", capoluogo='" + capoluogo + '\'' + ", descrizione='" + descrizione + '\'' + ", immagine='" + immagine + '\'' + '}';
    }
}

