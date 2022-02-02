package it.unicam.ids.tranquillo.entities;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Prenotazione {

    @Id @GeneratedValue(strategy=GenerationType.TABLE) private int numeroPrenotazione;
    private Date checkIn;
    private Date checkOut;


    public Prenotazione() {
    }

    public Prenotazione(Attrezzatura attrezzatura) {
        this.checkIn = new Date();
        this.checkOut = new Date();
        this.attrezzatura = attrezzatura;
    }


    public int  getNumeroPrenotazione() {
        return numeroPrenotazione;
    }

    public void setNumeroPrenotazione(int numeroPrenotazione) {
        this.numeroPrenotazione = numeroPrenotazione;
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


    @ManyToOne
    @JoinColumn()
    private Attrezzatura attrezzatura;
}


