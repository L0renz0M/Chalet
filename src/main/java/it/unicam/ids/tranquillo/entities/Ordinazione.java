package it.unicam.ids.tranquillo.entities;

import javax.persistence.*;


@Entity
public class Ordinazione {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE) private int numeroOrdinazione;
    private boolean consegnato;
    private boolean completato;
    private int quantita;
    private double prezzoTot;
    private boolean pagato;

    public Ordinazione (ProdottoBar prodottoBar,int quantita, double prezzoTot) {
        this.consegnato=false;
        this.completato=false;
        this.prodottoBar=prodottoBar;
        this.quantita=quantita;
        this.prezzoTot = prezzoTot;
        this.pagato=false;
    }


    public Ordinazione() {

    }

    public int getNumeroOrdinazione() {
        return numeroOrdinazione;
    }

    public void setNumeroOrdinazione(int numeroOrdinazione) {
        this.numeroOrdinazione = numeroOrdinazione;
    }

    public double getPrezzoTot() {
        return prezzoTot;
    }

    public void setPrezzoTot(double prezzoTot) {
        this.prezzoTot = prezzoTot;
    }

    public boolean isPagato() {
        return pagato;
    }

    public void setPagato(boolean pagato) {
        this.pagato = pagato;
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

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public ProdottoBar getProdottoBar() {
        return prodottoBar;
    }

    public void setProdottoBar(ProdottoBar prodottoBar) {
        this.prodottoBar = prodottoBar;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @ManyToOne
    private ProdottoBar prodottoBar;

    @ManyToOne
    private Cliente cliente;

    @Override
    public String toString() {
        return          "\n" +"ORDINAZIONE" +
                       " numeroOrdinazione= " + numeroOrdinazione +
                "\n" + " consegnato= " + consegnato +
                "\n" + " completato= " + completato +
                "\n" + " quantita= " + quantita +
                "\n" + " prodottoBar= " + prodottoBar +
                "\n" + " cliente= " + cliente+
                "\n" + "prezzoTotale= " + prezzoTot ;
    }


}
