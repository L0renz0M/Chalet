package it.unicam.ids.tranquillo.repositories;

import it.unicam.ids.tranquillo.entities.Prenotazione;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Integer> {

List<Prenotazione> findAll();


    List<Prenotazione> findAllByCliente_IdAndPagatoFalse(int id);



}
