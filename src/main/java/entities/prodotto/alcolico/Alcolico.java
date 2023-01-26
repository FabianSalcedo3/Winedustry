package entities.prodotto.alcolico;

import entities.prodotto.Prodotto;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Alcolico")
public class Alcolico extends Prodotto {

    @Column(name = "gradazione")
    private int gradazione;

    @Column(name = "temp_servizio")
    private int tempServizio;

    @Column(name = "temp_max_servizio")
    private int tempMaxServizio;

    public int getGradazione() {
        return gradazione;
    }

    public void setGradazione(int gradazione) {
        this.gradazione = gradazione;
    }

    public int getTempServizio() {
        return tempServizio;
    }

    public void setTempServizio(int tempServizio) {
        this.tempServizio = tempServizio;
    }

    public int getTempMaxServizio() {
        return tempMaxServizio;
    }

    public void setTempMaxServizio(int tempMaxServizio) {
        this.tempMaxServizio = tempMaxServizio;
    }

    @Override
    public String toString() {
        return "Alcolico{" + "gradazione=" + gradazione + ", tempServizio=" + tempServizio + ", tempMaxServizio=" + tempMaxServizio + "} " + super.toString();
    }
}
