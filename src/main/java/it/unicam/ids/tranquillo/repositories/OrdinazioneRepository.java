package it.unicam.ids.tranquillo.repositories;

import it.unicam.ids.tranquillo.entities.Ordinazione;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface OrdinazioneRepository extends CrudRepository<Ordinazione, Integer> {

    List<Ordinazione> findAllByCompletatoIsFalse();
    Ordinazione findByNumeroOrdinazione(int numeroOrd);
    List<Ordinazione> findAllByCompletatoIsTrueAndAndConsegnatoIsFalse();

    List<Ordinazione> findAllByCliente_Id(int id);
}
