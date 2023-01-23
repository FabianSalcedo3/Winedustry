package entities.prodotto.alcolico;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Bollicine")
public class Bollicine extends Champagne {

    @Column(name = "metodo", length = 50)
    private String metodo;

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    @Override
    public String toString() {
        return "Bollicine{" + "metodo='" + metodo + '\'' + "} " + super.toString();
    }
}
