package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "utente")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email", length = 100, unique = true, nullable = false)
    private String email;

    @Column(name = "username", length = 50, unique = true, nullable = false)
    private String username;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @OneToOne(mappedBy = "utente", fetch = FetchType.EAGER)
    private Indirizzo indirizzo;

    @OneToOne(mappedBy = "utente", fetch = FetchType.EAGER)
    private Informazioni informazioni;

}