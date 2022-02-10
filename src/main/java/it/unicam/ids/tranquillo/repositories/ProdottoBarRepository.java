package it.unicam.ids.tranquillo.repositories;


import it.unicam.ids.tranquillo.entities.ProdottoBar;
import org.springframework.data.repository.CrudRepository;

public interface ProdottoBarRepository extends CrudRepository<ProdottoBar, Integer> {

    ProdottoBar findByCodiceP(int codice);

}
