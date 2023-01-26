package entities.ordine;

import entities.Utente;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordine")
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "codice", nullable = false, unique = true, length = 12)
    private String codice;

    @Column(name = "totale")
    private double totale;

    @Column(name = "evaso", nullable = false)
    private boolean evaso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pagamento_id")
    private Pagamento pagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spedizione_id")
    private Spedizione spedizione;

    @OneToMany(mappedBy = "ordine", fetch = FetchType.LAZY)
    private List<OrdineItem> ordineItems = new ArrayList<>();

    public Ordine() {
        super();
    }

    public Ordine(String codice, boolean evaso, Utente utente) {
        this.codice = codice;
        this.evaso = evaso;
        this.utente = utente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public boolean isEvaso() {
        return evaso;
    }

    public void setEvaso(boolean evaso) {
        this.evaso = evaso;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public List<OrdineItem> getOrdineItems() {
        return ordineItems;
    }

    public void setOrdineItems(List<OrdineItem> ordineItems) {
        this.ordineItems = ordineItems;
    }

    public Spedizione getSpedizione() {
        return spedizione;
    }

    public void setSpedizione(Spedizione spedizione) {
        this.spedizione = spedizione;
    }

    @Override
    public String toString() {
        return "Ordine{" + "id=" + id + ", codice='" + codice + '\'' + ", totale=" + totale + '}';
    }
}
