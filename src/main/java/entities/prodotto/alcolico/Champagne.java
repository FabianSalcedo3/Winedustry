package entities.prodotto.alcolico;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Champagne")
public class Champagne extends Vino {

    @Column(name = "dosaggio", length = 50)
    private String dosaggio;

    @Column(name = "affinamento", length = 50)
    private String affinamento;

}
