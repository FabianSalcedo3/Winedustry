package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "indirizzo")
public class Indirizzo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "via", length = 50)
    private String via;

    @Column(name = "civico", length = 8)
    private String civico;

    @Column(name = "cap")
    private int cap;

    @Column(name = "citta", length = 50)
    private String citta;

    @Column(name = "provincia", length = 2)
    private String provincia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utente_id")
    private Utente utente;

    public Indirizzo() {
        super();
    }

    public Indirizzo(String via, String civico, int cap, String citta, String provincia, Utente utente) {
        this.via = via;
        this.civico = civico;
        this.cap = cap;
        this.citta = citta;
        this.provincia = provincia;
        this.utente = utente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Indirizzo{" + "id=" + id + ", via='" + via + '\'' + ", civico='" + civico + '\'' + ", cap=" + cap + ", citta='" + citta + '\'' + ", provincia='" + provincia + '\'' + '}';
    }
}
