package it.unicam.ids.tranquillo.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Ombrellone {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Integer numeroO;
        private String fascia;
        private Boolean prenotato;

    public Ombrellone(String fascia) {
        this.fascia = fascia;
        this.prenotato = false;
    }

    public Ombrellone() {

    }


    public Integer getNumeroO() {
        return numeroO;
    }

    public void setNumeroO(Integer numeroO) {
        this.numeroO = numeroO;
    }

    public String getFascia() {
        return fascia;
    }

    public void setFascia(String fascia) {
        this.fascia = fascia;
    }

    public boolean isPrenotato() {
        return prenotato;
    }

    public void setPrenotato(boolean prenotato) {
        this.prenotato = prenotato;
    }
}
