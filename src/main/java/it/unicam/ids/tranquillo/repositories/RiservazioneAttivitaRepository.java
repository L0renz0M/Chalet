package it.unicam.ids.tranquillo.repositories;

import it.unicam.ids.tranquillo.entities.Prenotazione;
import it.unicam.ids.tranquillo.entities.RiservazioneAttivita;
import org.springframework.data.repository.CrudRepository;

public interface RiservazioneAttivitaRepository extends CrudRepository<RiservazioneAttivita, Integer> {
}
