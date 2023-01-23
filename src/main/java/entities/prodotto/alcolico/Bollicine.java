package entities.prodotto.alcolico;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Bollicine")
public class Bollicine extends Champagne {

    @Column(name = "metodo", length = 50)
    private String metodo;

}
