package entities.prodotto.alcolico;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Spirito")
public class Spirito extends Alcolico {

    @Column(name = "tipo_spirito", length = 50)
    private String tipoSpirito;

    @Column(name = "varieta", length = 50)
    private String varieta;

    public String getTipoSpirito() {
        return tipoSpirito;
    }

    public void setTipoSpirito(String tipoSpirito) {
        this.tipoSpirito = tipoSpirito;
    }

    public String getVarieta() {
        return varieta;
    }

    public void setVarieta(String varieta) {
        this.varieta = varieta;
    }

    @Override
    public String toString() {
        return "Spirito{" + "tipoSpirito='" + tipoSpirito + '\'' + ", varieta='" + varieta + '\'' + "} " + super.toString();
    }
}
