package it.unicam.ids.tranquillo.entities;

import javax.persistence.*;


@Entity
public class Ordinazione {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE) private int numeroOrdinazione;
    private boolean consegnato;
    private boolean completato;
    private int quantita;


    public Ordinazione (ProdottoBar prodottoBar,int quantita) {
        this.consegnato=false;
        this.completato=false;
        this.prodottoBar=prodottoBar;
        this.quantita=quantita;
    }


    public Ordinazione() {

    }

    public int getNumeroOrdinazione() {
        return numeroOrdinazione;
    }

    public void setNumeroOrdinazione(int numeroOrdinazione) {
        this.numeroOrdinazione = numeroOrdinazione;
    }

    public boolean isConsegnato() {
        return consegnato;
    }

    public void setConsegnato(boolean consegnato) {
        this.consegnato = consegnato;
    }

    public boolean isCompletato() {
        return completato;
    }

    public void setCompletato(boolean completato) {
        this.completato = completato;
    }

    @ManyToOne
    @JoinColumn(name="codice_prodotto")
    private ProdottoBar prodottoBar;

    @ManyToOne
    @JoinColumn(name="iD_Cliente")
    private Cliente cliente;

}
