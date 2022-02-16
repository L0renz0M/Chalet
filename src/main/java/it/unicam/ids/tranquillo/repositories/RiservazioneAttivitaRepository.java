package it.unicam.ids.tranquillo.repositories;

import it.unicam.ids.tranquillo.entities.RiservazioneAttivita;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RiservazioneAttivitaRepository extends CrudRepository<RiservazioneAttivita, Integer> {
    List<RiservazioneAttivita> findAllByCliente_Id(int id);

}
