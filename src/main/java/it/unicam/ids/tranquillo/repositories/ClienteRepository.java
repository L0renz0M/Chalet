package it.unicam.ids.tranquillo.repositories;

import it.unicam.ids.tranquillo.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente,Integer> {

}
