package entities.prodotto;

import jakarta.persistence.*;

@Entity(name = "prodotto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "produttore", length = 50)
    private String produttore;

    @Column(name = "formato")
    private double formato;

    @Column(name = "prezzo", nullable = false)
    private double prezzo;

    @Column(name = "valutazione")
    private int valutazione;

    @Column(name = "nazione", length = 50)
    private String nazione;

    @Column(name = "immagine", length = 500)
    private String immagine;

    @Column(name = "descrizione", length = 5000)
    private String descrizione;

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

    public double getFormato() {
        return formato;
    }

    public void setFormato(double formato) {
        this.formato = formato;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getValutazione() {
        return valutazione;
    }

    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
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

    public String getProduttore() {
        return produttore;
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    @Override
    public String toString() {
        return "Prodotto{" + "id=" + id + ", nome='" + nome + '\'' + ", formato=" + formato + ", prezzo=" + prezzo + ", valutazione=" + valutazione + ", nazione='" + nazione + '\'' + ", immagine='" + immagine + '\'' + ", descrizione='" + descrizione + '\'' + ", produttore='" + produttore + '\'' + '}';
    }
}
