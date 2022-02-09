package it.unicam.ids.tranquillo.services;

import it.unicam.ids.tranquillo.entities.Cliente;
import it.unicam.ids.tranquillo.entities.RegisterUser;
import it.unicam.ids.tranquillo.repositories.RegisterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class RegisterUserService {

    @Autowired
    RegisterUserRepository registerUserRepository;

    public void createUser(String email,String password, Cliente cliente) {
        RegisterUser user = new RegisterUser(email,password, cliente);
        this.registerUserRepository.save(user);
    }

    public boolean checkCredenziali(String em, String pass) {
        List<RegisterUser> users = this.registerUserRepository.findByEmail(em);
        if (users.size()==0){
            return false;
        }
        RegisterUser user = users.get(0);
        if(user.getPassword()==pass) {
            System.out.print("LOGIN AVVENUTO CON SUCCESSO");
            return true;
        }
    return false;
    }

    public RegisterUser getUserByEmail(String email) {
        List<RegisterUser> users = this.registerUserRepository.findByEmail(email);
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }





}