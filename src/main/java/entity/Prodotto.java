package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vino")
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "produttore", length = 50, nullable = false)
    private String produttore;

    @Column(name = "categoria", length = 50, nullable = false)
    private String categoria;

    @Column(name = "vitigno", length = 50, nullable = false)
    private String vitigno;

    @Column(name = "annata", nullable = false)
    private int annata;

    @Column(name = "formato", nullable = false)
    private double formato;

    @Column(name = "gradazione", nullable = false)
    private int gradazione;

    @OneToOne
    @JoinColumn(name = "regione_id")
    private Regione regione;

}
