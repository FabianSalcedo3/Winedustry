package it.generationitaly.winedustryofficial.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "indirizzo")
public class Indirizzo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "via", length = 50, nullable = false)
    private String via;

    @Column(name = "civico", length = 8, nullable = false)
    private String civico;

    @Column(name = "cap", nullable = false)
    private int cap;

    @Column(name = "citta", length = 50, nullable = false)
    private String citta;

    @Column(name = "provincia", length = 2, nullable = false)
    private String provincia;

    @Column(name = "paese", nullable = false)
    private String paese;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }

    @Override
    public String toString() {
        return "Indirizzo{" + "id=" + id + ", via='" + via + '\'' + ", civico='" + civico + '\'' + ", cap=" + cap + ", citta='" + citta + '\'' + ", provincia='" + provincia + '\'' + ", paese='" + paese + '\'' + '}';
    }
}
