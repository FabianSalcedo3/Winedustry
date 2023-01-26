package entities.ordine;

import jakarta.persistence.*;

@Entity
@Table(name = "corriere")
public class Corriere {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "codice", nullable = false, unique = true, length = 12)
    private String codice;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "p_iva", nullable = false, unique = true, length = 11)
    private String pIva;

    @Column(name = "capitale")
    private double capitale;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getpIva() {
        return pIva;
    }

    public void setpIva(String pIva) {
        this.pIva = pIva;
    }

    public double getCapitale() {
        return capitale;
    }

    public void setCapitale(double capitale) {
        this.capitale = capitale;
    }

    @Override
    public String toString() {
        return "Corriere{" + "id=" + id + ", codice='" + codice + '\'' + ", nome='" + nome + '\'' + ", pIva='" + pIva + '\'' + ", capitale=" + capitale + '}';
    }
}
