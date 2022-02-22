package it.unicam.ids.tranquillo.services;

import it.unicam.ids.tranquillo.entities.Dipendente;
import it.unicam.ids.tranquillo.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DipendenteService {
    @Autowired
    DipendenteRepository dipendenteRepository;

    public void createDipendente(Dipendente dipendente){
        this.dipendenteRepository.save(dipendente);
    }





}
