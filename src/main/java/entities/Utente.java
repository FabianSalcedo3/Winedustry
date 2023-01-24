package entities;

import entities.ordine.Carrello;
import entities.ordine.Ordine;
import entities.ordine.Pagamento;
import jakarta.persistence.*;

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

    @OneToMany(mappedBy = "utente", fetch = FetchType.LAZY)
    private List<Informazioni> informazioni;

    @OneToMany(mappedBy = "utente", fetch = FetchType.LAZY)
    private List<Indirizzo> indirizzi;

    @OneToMany(mappedBy = "utente", fetch = FetchType.LAZY)
    private List<Pagamento> pagamenti;

    @OneToMany(mappedBy = "utente", fetch = FetchType.LAZY)
    private List<Ordine> ordini;

    @OneToMany(mappedBy = "utente", fetch = FetchType.LAZY)
    private List<Carrello> carrello;

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

    public List<Informazioni> getInformazioni() {
        return informazioni;
    }

    public void setInformazioni(List<Informazioni> informazioni) {
        this.informazioni = informazioni;
    }

    public List<Indirizzo> getIndirizzi() {
        return indirizzi;
    }

    public void setIndirizzi(List<Indirizzo> indirizzi) {
        this.indirizzi = indirizzi;
    }

    public List<Pagamento> getPagamenti() {
        return pagamenti;
    }

    public void setPagamenti(List<Pagamento> pagamenti) {
        this.pagamenti = pagamenti;
    }

    public List<Ordine> getOrdini() {
        return ordini;
    }

    public void setOrdini(List<Ordine> ordini) {
        this.ordini = ordini;
    }

    public List<Carrello> getCarrello() {
        return carrello;
    }

    public void setCarrello(List<Carrello> carrello) {
        this.carrello = carrello;
    }

    @Override
    public String toString() {
        return "Utente{" + "id=" + id + ", email='" + email + '\'' + ", username='" + username + '\'' + ", password='" + password + '\'' + '}';
    }
}

