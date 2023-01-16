package entity;

import entity.carrello.Carrello;
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

    @OneToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @OneToMany(mappedBy = "ordine", fetch = FetchType.EAGER)
    private List<Carrello> carelloItems = new ArrayList<>();

}
