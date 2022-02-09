package it.unicam.ids.tranquillo.services;

import it.unicam.ids.tranquillo.entities.Cliente;

public class SessioneService {

    private static SessioneService instance;
    private Cliente cliente; //sostituire con generic user con cui poi attraverso il ruolo definisco la view


    public static SessioneService getInstance() {
        if (SessioneService.instance == null) {
            SessioneService.instance = new SessioneService();
        }
        return SessioneService.instance;
    }


    public SessioneService() {}

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

}
