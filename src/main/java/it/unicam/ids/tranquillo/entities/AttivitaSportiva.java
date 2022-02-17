package it.unicam.ids.tranquillo.entities;


import javax.persistence.*;
import java.util.Date;


@Entity
public class AttivitaSportiva {
    @Id @GeneratedValue(strategy= GenerationType.TABLE) private int codiceAttivita;
    private String nomeAttvita;
    private int numeroPosti;
    private String descrizione;
    private Date dataOraAttiva;


    public AttivitaSportiva() { }

    public AttivitaSportiva(String nomeAttvita, int numeroPosti, String descrizione, Date dataOraAttiva) {
        this.nomeAttvita = nomeAttvita;
        this.numeroPosti = numeroPosti;
        this.descrizione = descrizione;
        this.dataOraAttiva = dataOraAttiva;
    }

    public int getCodiceAttivita() {
        return codiceAttivita;
    }

    public void setCodiceAttivita(int codiceAttivita) {
        this.codiceAttivita = codiceAttivita;
    }

    public String getNomeAttvita() {
        return nomeAttvita;
    }

    public void setNomeAttvita(String nomeAttvita) {
        this.nomeAttvita = nomeAttvita;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getDataOraAttiva() {
        return dataOraAttiva;
    }

    public void setDataOraAttiva(Date dataOraAttiva) {
        this.dataOraAttiva = dataOraAttiva;
    }

    @Override
    public String toString() {
        return      "\n" +"ATTIVITA' SPORTIVA" +
                       " numeroAttvita= " + codiceAttivita+
                "\n" + " nomeAttvita= " + nomeAttvita +
                "\n" + " numeroPosti= " + numeroPosti +
                "\n" + " descrizione= " + descrizione +
                "\n" + " dataOraAttiva= " + dataOraAttiva ;
    }
}
