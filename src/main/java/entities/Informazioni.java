package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "informazioni")
public class Informazioni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "cognome", length = 50)
    private String cognome;

    @Column(name = "codice_fiscale", length = 16, unique = true)
    private String codiceFiscale;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    @Column(name = "telefono", length = 10)
    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utente_id")
    private Utente utente;

    public Informazioni() {
        super();
    }

    public Informazioni(String nome, String cognome, String codiceFiscale, LocalDate dataNascita, String telefono, Utente utente) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.dataNascita = dataNascita;
        this.telefono = telefono;
        this.utente = utente;
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Informazioni{" + "id=" + id + ", nome='" + nome + '\'' + ", cognome='" + cognome + '\'' + ", codiceFiscale='" + codiceFiscale + '\'' + ", dataNascita=" + dataNascita + ", telefono='" + telefono + '\'' + '}';
    }
}
