package entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "informazioni")
public class Informazioni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "cognome", length = 50, nullable = false)
    private String cognome;

    @Column(name = "codice_fiscale", length = 16, unique = true, nullable = false)
    private String codiceFiscale;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascita", nullable = false)
    private LocalDate dataNascita;

    @Column(name = "telefono", nullable = false)
    private long telefono;

    @OneToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

}
