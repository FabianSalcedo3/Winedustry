package entities.prodotto;

import entities.Regione;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Vino")
public class Vino extends Prodotto {

    @Column(name = "categoria", length = 50)
    private String categoria;

    @Column(name = "vitigno", length = 50)
    private String vitigno;

    @Column(name = "denominazione", length = 50)
    private String denominazione;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regione_id")
    private Regione regione;

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

    @Override
    public String toString() {
        return "Vino{" + "categoria='" + categoria + '\'' + ", vitigno='" + vitigno + '\'' + ", denominazione='" + denominazione + '\'' + "} " + super.toString();
    }
}
