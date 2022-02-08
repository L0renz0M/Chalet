package it.unicam.ids.tranquillo.services;

import it.unicam.ids.tranquillo.entities.RegisterUser;
import it.unicam.ids.tranquillo.repositories.RegisterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class RegisterUserService {

    @Autowired
    RegisterUserRepository logUserRepository;


    public void createUser(String email,String password) {
        RegisterUser user = new RegisterUser(email,password);
        this.logUserRepository.save(user);
    }

    public boolean checkCredenziali(String em, String pass) {

        if (this.logUserRepository.existsByEmailAndAndPassword(em,pass))
            System.out.print("LOGIN AVVENUTO CON SUCCESSO");
        return true;
    }
}