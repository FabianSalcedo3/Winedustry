package entities.ordine;

import entities.Utente;
import jakarta.persistence.*;

@Entity
@Table(name = "ordine")
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "codice", nullable = false, unique = true, length = 12)
    private String codice;

    @Column(name = "totale", nullable = false)
    private double totale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrello_id", nullable = false)
    private Carrello carrello;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spedizione_id")
    private Spedizione spedizione;

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

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
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
