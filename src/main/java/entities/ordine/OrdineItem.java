package entities.ordine;

import entities.prodotto.Prodotto;
import jakarta.persistence.*;

@Entity
@Table(name = "shoplist")
public class OrdineItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "monopolio", nullable = false)
    private boolean monopolio;

    @Column(name = "quantita", nullable = false)
    private int quantita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordine_id", nullable = false)
    private Ordine ordine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prodotto_id", nullable = false)
    private Prodotto prodotto;

    public OrdineItem() {
        super();
    }

    public OrdineItem(boolean monopolio, int quantita, Ordine ordine, Prodotto prodotto) {
        this.monopolio = monopolio;
        this.quantita = quantita;
        this.ordine = ordine;
        this.prodotto = prodotto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMonopolio() {
        return monopolio;
    }

    public void setMonopolio(boolean monopolio) {
        this.monopolio = monopolio;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    @Override
    public String toString() {
        return "Shoplist{" + "monopolio=" + monopolio + '}';
    }
}
