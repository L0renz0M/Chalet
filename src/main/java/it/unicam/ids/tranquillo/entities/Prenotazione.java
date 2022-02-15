package it.unicam.ids.tranquillo.entities;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="prenotazione")
public class Prenotazione {

    @Id @GeneratedValue (strategy=GenerationType.TABLE) private int numeroPrenotazione;
    private Date checkIn;
    private Date checkOut;
    boolean checkInAtMorning;
    boolean checkOutAtMorning;


/*
    public Prenotazione(Attrezzatura attrezzatura,Date checkIn,Date checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.attrezzatura = attrezzatura;
        this.checkInAtMorning = true;
        this.checkOutAtMorning = false;
    }
*/

    public Prenotazione( Date checkIn, Date checkOut, boolean checkInAtMorning, boolean checkOutAtMorning, Attrezzatura attrezzatura) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.checkInAtMorning = checkInAtMorning;
        this.checkOutAtMorning = checkOutAtMorning;
        this.attrezzatura = attrezzatura;
    }

    public Prenotazione() {

    }


    public int  getNumeroPrenotazione() {
        return numeroPrenotazione;
    }

    public void setNumeroPrenotazione(int numeroPrenotazione) {
        this.numeroPrenotazione = numeroPrenotazione;
    }

    public boolean isCheckInAtMorning() {
        return checkInAtMorning;
    }

    public void setCheckInAtMorning(boolean checkInAtMorning) {
        this.checkInAtMorning = checkInAtMorning;
    }

    public boolean isCheckOutAtMorning() {
        return checkOutAtMorning;
    }

    public void setCheckOutAtMorning(boolean checkOutAtMorning) {
        this.checkOutAtMorning = checkOutAtMorning;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Attrezzatura getAttrezzatura() {
        return attrezzatura;
    }

    public void setAttrezzatura(Attrezzatura attrezzatura) {
        this.attrezzatura = attrezzatura;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @ManyToOne
    private Attrezzatura attrezzatura;

    @ManyToOne()
    private Cliente cliente;
    }



