package it.unicam.ids.tranquillo.views;

import it.unicam.ids.tranquillo.repositories.RegisterUserRepository;
import it.unicam.ids.tranquillo.services.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserView {

    @Autowired
    RegisterUserService logUserService;
    @Autowired
    RegisterUserRepository registerUserRepository;

    public int login() {
        int c;

        System.out.println("\n" + "BENEVENUTO NELLO CHALET 'TRANQUILLO'" +
                "\n" + "-->PER USUFRUIRE DEI SERVIZI OFFERTI IDENTIFICARSI" +
                "\n\n" + "1-->PER IDENTIFICARSI COME CLIENTI " +
                "\n"   + "2-->PER IDENTIFICARSI COME DIPENDENTI");
        Scanner inpRuolo = new Scanner(System.in);
        int ruolo = inpRuolo.nextInt();

        if (ruolo == 1) {
            System.out.println("LOGIN UTENTE");
            System.out.println("inserisci email:");
            Scanner emailInp = new Scanner(System.in);
            String em = emailInp.next();
            System.out.println("inserisci password:");
            Scanner passInp = new Scanner(System.in);
            String pass = passInp.next();
            this.logUserService.checkCredenziali(em, pass);
            return 1; // cliente
        }
        System.out.println("LOGIN DIPENDENTE");
        System.out.println("inserisci email:");
        Scanner emailInp = new Scanner(System.in);
        String em = emailInp.next();
        System.out.println("inserisci password:");
        Scanner passInp = new Scanner(System.in);
        String pass = passInp.next();
        this.logUserService.checkCredenziali(em, pass);
        return c = 2;//dipendente

    }

    public void registrazione() {
        int a = 0;
        System.out.println("BENEVENUTO NELLO CHALET 'TRANQUILLO' " + "\n" +
                "DA QUI POTRAI REGISTRARTI AI NOSTRI SERVIZI:" );

        do {
            System.out.println("INSERISCI UNA MAIL PER LA REGISTRAZIONE: ");
            Scanner emInp = new Scanner(System.in);
            String email = emInp.next();

            if (this.registerUserRepository.existsByEmail(email) == true) {
                System.out.println("\n"+"---EMAIL INSERITA GIA' PRESENTE PROVARE CON UNA DIFFERENTE--- ");
                a = 1;

            } else{
                System.out.println("INSERISCI UNA PASSSWORD PER LA REGISTRAZIONE: ");
                Scanner passInp = new Scanner(System.in);
                String pass = passInp.next();
                this.logUserService.createUser(email, pass);
                a=0;
                    }
        } while (a != 0);

    }

}