package it.generationitaly.winedustryofficial.entity;

import entity.Utente;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carrello")
public class Carrello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "vino_id")
    private Utente utente;

    @OneToMany(mappedBy = "carrello", fetch = FetchType.EAGER)
    private List<CarrelloItem> carrelloItems = new ArrayList<>();

}
