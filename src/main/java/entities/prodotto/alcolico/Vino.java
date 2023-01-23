package entities.prodotto.alcolico;

import entities.Regione;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Vino")
public class Vino extends Alcolico {

    @Column(name = "categoria", length = 50)
    private String categoria;

    @Column(name = "vitigno", length = 50)
    private String vitigno;

    @Column(name = "denominazione", length = 50)
    private String denominazione;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regione_id")
    private Regione regione;

    @Column(name = "annata")
    private int annata;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getVitigno() {
        return vitigno;
    }

    public void setVitigno(String vitigno) {
        this.vitigno = vitigno;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public Regione getRegione() {
        return regione;
    }

    public void setRegione(Regione regione) {
        this.regione = regione;
    }

    public int getAnnata() {
        return annata;
    }

    public void setAnnata(int annata) {
        this.annata = annata;
    }

    @Override
    public String toString() {
        return "Vino{" + "categoria='" + categoria + '\'' + ", vitigno='" + vitigno + '\'' + ", denominazione='" + denominazione + '\'' + ", annata=" + annata + "} " + super.toString();
    }
}
