package entities.prodotto;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Bollicine")
public class Bollicine extends Prodotto {

    @Column(name = "affinamento", length = 50)
    private String affinamento;

    @Column(name = "metodo", length = 50)
    private String metodo;

    @Column(name = "dosaggio", length = 50)
    private String dosaggio;

    public String getAffinamento() {
        return affinamento;
    }

    public void setAffinamento(String affinamento) {
        this.affinamento = affinamento;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getDosaggio() {
        return dosaggio;
    }

    public void setDosaggio(String dosaggio) {
        this.dosaggio = dosaggio;
    }

    @Override
    public String toString() {
        return "Bollicine{" + "affinamento='" + affinamento + '\'' + ", metodo='" + metodo + '\'' + ", dosaggio='" + dosaggio + '\'' + "} " + super.toString();
    }
}
