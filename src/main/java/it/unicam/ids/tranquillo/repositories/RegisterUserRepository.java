package it.unicam.ids.tranquillo.repositories;

import it.unicam.ids.tranquillo.entities.Cliente;
import it.unicam.ids.tranquillo.entities.RegisterUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RegisterUserRepository extends CrudRepository<RegisterUser, Integer> {



    boolean existsByEmailAndAndPassword(String email,String password);

    List<RegisterUser> findByEmail(String email);

    boolean existsByEmail(String email);
    boolean findByPassword(String password);
}
