package entities.ordine;

import entities.prodotto.Prodotto;
import jakarta.persistence.*;

@Entity
@Table(name = "carrello_item")
public class CarrelloItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "quantita", nullable = false)
    private int quantita;

    @OneToOne
    @JoinColumn(name = "carrello_id", unique = true)
    private Carrello carrello;

    @OneToOne
    @JoinColumn(name = "prodotto_id")
    private Prodotto prodotto;

    public CarrelloItem() {
        super();
    }

    public CarrelloItem(int quantita, Carrello carrello, Prodotto prodotto) {
        this.quantita = quantita;
        this.carrello = carrello;
        this.prodotto = prodotto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    @Override
    public String toString() {
        return "CarrelloItem{" + "id=" + id + ", quantita=" + quantita + '}';
    }
}
