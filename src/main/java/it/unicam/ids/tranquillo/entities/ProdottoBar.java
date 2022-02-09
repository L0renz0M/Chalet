package it.unicam.ids.tranquillo.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProdottoBar {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE) private Integer codiceP;
    private String descrizione;
    private double prezzo;
    //quantita?

    public ProdottoBar(String descrizione, Double prezzo){
        this.descrizione=descrizione;
        this.prezzo=prezzo;
    }

    public ProdottoBar(){ }

    public Integer getCodiceP() { return codiceP; }

    public void setCodiceP(Integer codiceP) { this.codiceP = codiceP; }

    public String getDescrizione() { return descrizione; }

    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public double getPrezzo() { return prezzo; }

    public void setPrezzo(double prezzo) { this.prezzo = prezzo; }


    @Override
    public String toString() {
        return
                "\n"+" NOME PRODOTTO=" + descrizione +"codiceP=" + codiceP +  " PREZZO=" + prezzo+"\n" ;}


    }

