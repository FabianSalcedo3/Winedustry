package entities;

import entities.carrello.Carrello;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utente")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email", length = 100, unique = true, nullable = false)
    private String email;

    @Column(name = "username", length = 50, unique = true, nullable = false)
    private String username;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @OneToOne(mappedBy = "utente", fetch = FetchType.EAGER)
    private Indirizzo indirizzo;

    @OneToOne(mappedBy = "utente", fetch = FetchType.EAGER)
    private Informazioni informazioni;

    @OneToOne(mappedBy = "utente", fetch = FetchType.EAGER)
    private Carrello carrello;

    @OneToMany(mappedBy = "utente", fetch = FetchType.EAGER)
    private List<Ordine> ordini = new ArrayList<>();

    @OneToMany(mappedBy = "utente", fetch = FetchType.EAGER)
    private List<Pagamento> pagamenti = new ArrayList<>();

    public Utente() {
        super();
    }

    public Utente(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Informazioni getInformazioni() {
        return informazioni;
    }

    public void setInformazioni(Informazioni informazioni) {
        this.informazioni = informazioni;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }

    public List<Ordine> getOrdini() {
        return ordini;
    }

    public void setOrdini(List<Ordine> ordini) {
        this.ordini = ordini;
    }

    public List<Pagamento> getPagamenti() {
        return pagamenti;
    }

    public void setPagamenti(List<Pagamento> pagamenti) {
        this.pagamenti = pagamenti;
    }

    @Override
    public String toString() {
        return "Utente{" + "id=" + id + ", email='" + email + '\'' + ", username='" + username + '\'' + ", password='" + password + '\'' + '}';
    }
}