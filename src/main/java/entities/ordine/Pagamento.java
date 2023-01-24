package entities.ordine;

import entities.Utente;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "carta", length = 19, nullable = false)
    private String carta;

    @Column(name = "circuito", length = 20, nullable = false)
    private String circuito;

    @Column(name = "proprietario", length = 50, nullable = false)
    private String proprietario;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_scadenza", nullable = false)
    private LocalDate dataScadenza;

    @Column(name = "cvv", nullable = false)
    private int cvv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    public Pagamento() {
        super();
    }

    public Pagamento(String carta, String circuito, String proprietario, LocalDate dataScadenza, int cvv, Utente utente) {
        this.carta = carta;
        this.circuito = circuito;
        this.proprietario = proprietario;
        this.dataScadenza = dataScadenza;
        this.cvv = cvv;
        this.utente = utente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarta() {
        return carta;
    }

    public void setCarta(String carta) {
        this.carta = carta;
    }

    public String getCircuito() {
        return circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "id=" + id + ", carta='" + carta + '\'' + ", circuito='" + circuito + '\'' + ", proprietario='" + proprietario + '\'' + ", dataScadenza=" + dataScadenza + ", cvv=" + cvv + '}';
    }
}
