package it.unicam.ids.tranquillo.repositories;

import it.unicam.ids.tranquillo.entities.Cliente;
import it.unicam.ids.tranquillo.entities.RegisterUser;
import org.springframework.data.repository.CrudRepository;


public interface RegisterUserRepository extends CrudRepository<RegisterUser, Integer> {



    boolean existsByEmail(String email);



    boolean existsByPassword(String password);
}
