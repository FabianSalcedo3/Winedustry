package entities.ordine;

import jakarta.persistence.*;

@Entity
@Table(name = "spedizione")
public class Spedizione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "codice", nullable = false, unique = true, length = 12)
    private String codice;

    @Column(name = "colli", nullable = false)
    private int colli;

    @Column(name = "peso", nullable = false)
    private int peso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public int getColli() {
        return colli;
    }

    public void setColli(int colli) {
        this.colli = colli;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Spedizione{" + "id=" + id + ", codice='" + codice + '\'' + ", colli=" + colli + ", peso=" + peso + '}';
    }
}
