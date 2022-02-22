package it.unicam.ids.tranquillo.services;

import it.unicam.ids.tranquillo.entities.Cliente;
import it.unicam.ids.tranquillo.entities.Dipendente;
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
    public void createdip(String email,String password, Dipendente dipendente) {
        email="dipendenti@chalet.it";
        password="dipendente1";
        RegisterUser dip = new RegisterUser(email,password, dipendente);
        this.registerUserRepository.save(dip);
    }

    public boolean checkCredenziali(String em, String pass) {
        List<RegisterUser> users = this.registerUserRepository.findByEmail(em);
        if (users.size()==0){
            return false;
        }
        else{
        RegisterUser user = users.get(0);
        if(user.getPassword().equals(pass)) {
            System.out.print("LOGIN AVVENUTO CON SUCCESSO");
            return true;
        }}
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


    public boolean checkCredenzialiDipendenti(String em, String pass) {
        if ((em.equals("dipendenti@chalet.com") || em.equals("dipendenti@chalet.it"))&& pass.equals("dipendente1")){
            System.out.print("LOGIN DIPENDENTE AVVENUTO  CON SUCCESSO");
                return true;
        }else{
            System.out.print("LOGIN NON AVVENUTO, CREDENZIALI DIPENDENTE ERRATE");
            return false;
        }
    }




    /*public boolean checkCredenzialiTitolare(String em, String pass) {
        if(em.equals("titolare@chalet.it") && pass.equals("titolare1")){
            System.out.print("LOGIN TITOLARE AVVENUTO CON SUCCESSO");
            return true;
        }else{
            System.out.print("LOGIN NON AVVENUTO, CREDENZIALI TITOLARE ERRATE");
            return false;
        }
    }*/


}