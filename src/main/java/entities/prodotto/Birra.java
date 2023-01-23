package entities.prodotto;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Birra")
public class Birra extends Prodotto {

    @Column(name = "fermentazione", length = 50)
    private String fermentazione;

    @Column(name = "gusto", length = 50)
    private String gusto;

    @Column(name = "caratteristiche", length = 50)
    private String caratteristiche;

    public String getFermentazione() {
        return fermentazione;
    }

    public void setFermentazione(String fermentazione) {
        this.fermentazione = fermentazione;
    }

    public String getGusto() {
        return gusto;
    }

    public void setGusto(String gusto) {
        this.gusto = gusto;
    }

    public String getCaratteristiche() {
        return caratteristiche;
    }

    public void setCaratteristiche(String caratteristiche) {
        this.caratteristiche = caratteristiche;
    }

    @Override
    public String toString() {
        return "Birra{" + "fermentazione='" + fermentazione + '\'' + ", gusto='" + gusto + '\'' + ", caratteristiche='" + caratteristiche + '\'' + "} " + super.toString();
    }
}
