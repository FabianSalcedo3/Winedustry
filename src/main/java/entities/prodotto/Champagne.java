package entities.prodotto;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Champagne")
public class Champagne extends Prodotto {

    @Column(name = "temp_servizio")
    private int tempServizio;

    @Column(name = "dosaggio", length = 50)
    private String dosaggio;

    public int getTempServizio() {
        return tempServizio;
    }

    public void setTempServizio(int tempServizio) {
        this.tempServizio = tempServizio;
    }

    public String getDosaggio() {
        return dosaggio;
    }

    public void setDosaggio(String dosaggio) {
        this.dosaggio = dosaggio;
    }

    @Override
    public String toString() {
        return "Champagne{" + "tempServizio=" + tempServizio + ", dosaggio='" + dosaggio + '\'' + "} " + super.toString();
    }
}
