package entities.carrello;

import java.util.ArrayList;
import java.util.List;

import entities.Utente;
import jakarta.persistence.*;

@Entity
@Table(name = "carrello")
public class Carrello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @OneToMany(mappedBy = "carrello", fetch = FetchType.EAGER)
    private List<CarrelloItem> carrelloItems = new ArrayList<>();

    public Carrello(Utente utente) {
        this.utente = utente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<CarrelloItem> getCarrelloItems() {
        return carrelloItems;
    }

    public void setCarrelloItems(List<CarrelloItem> carrelloItems) {
        this.carrelloItems = carrelloItems;
    }

    @Override
    public String toString() {
        return "Carrello{" + "id=" + id + ", carrelloItems=" + carrelloItems + '}';
    }
}
