package entities.prodotto.alcolico;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Champagne")
public class Champagne extends Vino {

    @Column(name = "dosaggio", length = 50)
    private String dosaggio;

    @Column(name = "affinamento", length = 50)
    private String affinamento;

    public String getDosaggio() {
        return dosaggio;
    }

    public void setDosaggio(String dosaggio) {
        this.dosaggio = dosaggio;
    }

    public String getAffinamento() {
        return affinamento;
    }

    public void setAffinamento(String affinamento) {
        this.affinamento = affinamento;
    }

    @Override
    public String toString() {
        return "Champagne{" + "dosaggio='" + dosaggio + '\'' + ", affinamento='" + affinamento + '\'' + "} " + super.toString();
    }
}
