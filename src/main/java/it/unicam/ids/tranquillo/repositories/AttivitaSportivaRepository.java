package it.unicam.ids.tranquillo.repositories;

import it.unicam.ids.tranquillo.entities.AttivitaSportiva;
import org.springframework.data.repository.CrudRepository;

public interface AttivitaSportivaRepository extends CrudRepository<AttivitaSportiva,Integer> {

AttivitaSportiva findByCodiceAttivita(int codiceA);

}
