package it.generationitaly.winedustryofficial.entity;

import entity.carrello.Carrello;
import jakarta.persistence.*;

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

    @OneToOne
    @JoinColumn(name = "carrello_id")
    private Carrello carello;

}
