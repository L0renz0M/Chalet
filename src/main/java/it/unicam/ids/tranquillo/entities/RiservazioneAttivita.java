package it.unicam.ids.tranquillo.entities;

import javax.persistence.*;

@Entity
public class RiservazioneAttivita {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE) private int numeroRiservazione;
    private int postiPrenotati;

    public RiservazioneAttivita(int postiPrenotati,AttivitaSportiva attivitaSportiva) {
        this.numeroRiservazione = numeroRiservazione;
        this.postiPrenotati = postiPrenotati;
        this.cliente = cliente;
        this.attivitaSportiva = attivitaSportiva;
    }

    public RiservazioneAttivita() {    }

    public int getNumeroRiservazione() {
        return numeroRiservazione;
    }

    public void setNumeroRiservazione(int numeroRiservazione) {
        this.numeroRiservazione = numeroRiservazione;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    public void setPostiPrenotati(int postiPrenotati) {
        this.postiPrenotati = postiPrenotati;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public AttivitaSportiva getAttivitaSportiva() {
        return attivitaSportiva;
    }

    public void setAttivitaSportiva(AttivitaSportiva attivitaSportiva) {
        this.attivitaSportiva = attivitaSportiva;
    }

    @OneToOne
    @JoinColumn(name="iD_Cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name="attivita")
    private AttivitaSportiva attivitaSportiva;

}
