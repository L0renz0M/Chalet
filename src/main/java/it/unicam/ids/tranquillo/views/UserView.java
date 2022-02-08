package it.unicam.ids.tranquillo.views;

import it.unicam.ids.tranquillo.entities.Cliente;
import it.unicam.ids.tranquillo.repositories.ClienteRepository;
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
    @Autowired
    ClienteRepository clienteRepository;

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
            if(this.logUserService.checkCredenziali(em, pass)==true);
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
        System.out.println("\n" +"BENEVENUTO NELLO CHALET 'TRANQUILLO' " + "\n" +
                "DA QUI POTRAI REGISTRARTI AI NOSTRI SERVIZI:" );

        do {
            System.out.println("INSERISCI UNA MAIL PER LA REGISTRAZIONE: ");
            Scanner emInp = new Scanner(System.in);
            String email = emInp.next();

            if (this.registerUserRepository.existsByEmail(email) == true) {
                System.out.println("\n"+"---EMAIL INSERITA GIA' PRESENTE PROVARE CON UNA DIFFERENTE");
                Scanner in = new Scanner(System.in);
                a = 1;

            } else{

                System.out.println("\n"+"INSERISCI UNA PASSSWORD PER LA REGISTRAZIONE: ");
                Scanner passInp = new Scanner(System.in);
                String pass = passInp.next();
                this.logUserService.createUser(email, pass);
                System.out.println("\n"+"INSERISCI I TUOI DATI: ");
                System.out.println("\n"+"INSERISCI NOME: ");
                Scanner nomeInp = new Scanner(System.in);
                String nome= nomeInp.next();
                System.out.println("\n"+"INSERISCI COGNOME: ");
                Scanner cognomeInp = new Scanner(System.in);
                String cognome= cognomeInp.next();

                Cliente cliente = new Cliente(nome,cognome,email);
                this.clienteRepository.save(cliente);

                a=0;
                    }
        } while (a != 0);

    }


    public void benevenuto (){
        System.out.println("\n" +"BENEVENUTO NELLO CHALET 'TRANQUILLO' " + "\n" +
                "DA QUI POTRAI REGISTRARTI AI NOSTRI SERVIZI O ACCEDERVI SE SI E' GIA REGISTRATI:" );
        System.out.println("SCEGLIERE :"+
                "\n"+ "1- PER EFFETTUARE IL LOGIN"+
                "\n"+"2- PER EFFETTUARE LA REGISTRAZIONE");
        Scanner inp= new Scanner(System.in);
        int a = inp.nextInt();
        switch (a){
            case 1: login();break;
            case 2: registrazione();break;
        }
    }

}