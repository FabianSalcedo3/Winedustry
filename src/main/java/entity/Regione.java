package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "regione")
public class Regione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "capoluogo", length = 50, nullable = false)
    private String capoluogo;

    @OneToMany(mappedBy = "regione", fetch = FetchType.EAGER)
    private List<Prodotto> vini = new ArrayList<>();

}
