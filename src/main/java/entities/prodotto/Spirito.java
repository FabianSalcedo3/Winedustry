package entities.prodotto;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Spirito")
public class Spirito extends Prodotto {

    @Column(name = "spirito", length = 50)
    private String spirito;

    @Column(name = "varieta", length = 50)
    private String varieta;

    public String getSpirito() {
        return spirito;
    }

    public void setSpirito(String spirito) {
        this.spirito = spirito;
    }

    public String getVarieta() {
        return varieta;
    }

    public void setVarieta(String varieta) {
        this.varieta = varieta;
    }

    @Override
    public String toString() {
        return "Spirito{" + "spirito='" + spirito + '\'' + ", varieta='" + varieta + '\'' + "} " + super.toString();
    }
}
