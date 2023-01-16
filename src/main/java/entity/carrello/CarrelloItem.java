package entity.carrello;

import entity.Prodotto;
import jakarta.persistence.*;

@Entity
@Table(name = "carrello_item")
public class CarrelloItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "quantita", nullable = false)
    private int quantita;

    @OneToOne
    @JoinColumn(name = "prodotto_id")
    private Prodotto prodotto;

    @OneToOne
    @JoinColumn(name = "prodotto_id")
    private Carrello carrello;

}
