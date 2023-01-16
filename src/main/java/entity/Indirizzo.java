package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "indirizzo")
public class Indirizzo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "via", length = 50, nullable = false)
    private String via;

    @Column(name = "civico", length = 8, nullable = false)
    private String civico;

    @Column(name = "cap", nullable = false)
    private int cap;

    @Column(name = "comune", length = 50, nullable = false)
    private String comune;

    @Column(name = "citta", length = 50, nullable = false)
    private String citta;

    @Column(name = "provincia", length = 2, nullable = false)
    private String provincia;

    @Column(name = "paese", nullable = false)
    private String paese;

    @OneToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

}
