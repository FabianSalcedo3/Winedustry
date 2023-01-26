package entities.ordine;

import entities.Utente;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "carrello")
public class Carrello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @OneToMany(mappedBy = "carrello", fetch = FetchType.LAZY)
    private List<CarrelloItem> carrelloItems;

    public Carrello() {
        super();
    }

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
        return "Carrello{" + "id=" + id + '}';
    }

}
