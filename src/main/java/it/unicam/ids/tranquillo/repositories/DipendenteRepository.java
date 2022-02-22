package it.unicam.ids.tranquillo.repositories;

import it.unicam.ids.tranquillo.entities.Dipendente;
import it.unicam.ids.tranquillo.entities.Prenotazione;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DipendenteRepository extends CrudRepository<Dipendente,Integer> {
    List<Dipendente> findAll();


}
