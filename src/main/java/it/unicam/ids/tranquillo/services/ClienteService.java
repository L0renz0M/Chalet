package it.unicam.ids.tranquillo.services;

import it.unicam.ids.tranquillo.entities.Cliente;
import it.unicam.ids.tranquillo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;


    public void createCliente(Cliente cliente){

        this.clienteRepository.save(cliente);
    }




}
