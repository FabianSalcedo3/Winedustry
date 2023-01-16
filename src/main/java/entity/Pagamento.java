package entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "carta", length = 16, nullable = false)
    private String carta;

    @Column(name = "circuito", length = 20, nullable = false)
    private String circuito;

    @Column(name = "proprietario", length = 50, nullable = false)
    private String proprietario;

    @Column(name = "data_scadenza", nullable = false)
    private LocalDate dataScadenza;

    @Column(name = "ccv", nullable = false)
    private int ccv;

    @OneToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

}
