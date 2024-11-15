package it.unicam.ids.tranquillo.views;

import it.unicam.ids.tranquillo.entities.Cliente;
import it.unicam.ids.tranquillo.entities.Dipendente;
import it.unicam.ids.tranquillo.entities.RegisterUser;
import it.unicam.ids.tranquillo.repositories.ClienteRepository;
import it.unicam.ids.tranquillo.repositories.DipendenteRepository;
import it.unicam.ids.tranquillo.repositories.RegisterUserRepository;
import it.unicam.ids.tranquillo.services.DipendenteService;
import it.unicam.ids.tranquillo.services.RegisterUserService;
import it.unicam.ids.tranquillo.services.SessioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class UserView {

    @Autowired
    RegisterUserService registerUserService;
    @Autowired
    RegisterUserRepository registerUserRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    DipendenteRepository dipendenteRepository;
    @Autowired
    DipendenteService dipendenteService;

    public int login() {
        int c;
        while (true) {
            System.out.println("\n" + "BENEVENUTO NELLO CHALET 'TRANQUILLO'" +
                    "\n" + "-->PER USUFRUIRE DEI SERVIZI OFFERTI IDENTIFICARSI" +
                    "\n\n" + "1-->PER IDENTIFICARSI COME CLIENTE " +
                    "\n" + "2-->PER IDENTIFICARSI COME DIPENDENTE"
                    );
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
                if(this.registerUserService.checkCredenziali(em, pass) == true){
                    RegisterUser user = this.registerUserService.getUserByEmail(em);
                    SessioneService sessione = SessioneService.getInstance(); //CI DA UN' ISTANZA SESSIONE SU CUI LAVORARE
                    sessione.setCliente(user.getCliente());
                    return 1;
                }
                else{
                    System.out.println("\n"+"LOGIN ERRATO");
                    continue;
                }
            }else {
                System.out.println("LOGIN DIPENDENTE");
                System.out.println("inserisci email:");
                Scanner emailInp = new Scanner(System.in);
                String em = emailInp.next();
                System.out.println("inserisci password:");
                Scanner passInp = new Scanner(System.in);
                String pass = passInp.next();
                if (this.registerUserService.checkCredenzialiDipendenti(em, pass) == true) {
                    return 2;//dipendente
                } else {
                    System.out.println("\n" + "login DIPENDENTE errato");
                    continue;
                }
            }

        }
    }
    public boolean registrazione() {
        int a = 0;
        System.out.println("\n" +"BENEVENUTO NELLO CHALET 'TRANQUILLO' " + "\n" +
                "DA QUI POTRAI REGISTRARTI AI NOSTRI SERVIZI:" );

        do {
            System.out.println("INSERISCI UNA MAIL PER LA REGISTRAZIONE: ");
            Scanner emInp = new Scanner(System.in);
            String email = emInp.next();

            if (this.registerUserRepository.existsByEmail(email)) {
                System.out.println("\n"+"---EMAIL INSERITA GIA' PRESENTE PROVARE CON UNA DIFFERENTE");
                Scanner in = new Scanner(System.in);
                a = 1;

            } else{

                System.out.println("\n"+"INSERISCI UNA PASSSWORD PER LA REGISTRAZIONE: ");
                Scanner passInp = new Scanner(System.in);
                String pass = passInp.next();
                System.out.println("\n"+"INSERISCI I TUOI DATI: ");
                System.out.println("\n"+"INSERISCI NOME: ");
                Scanner nomeInp = new Scanner(System.in);
                String nome= nomeInp.next();
                System.out.println("\n"+"INSERISCI COGNOME: ");
                Scanner cognomeInp = new Scanner(System.in);
                String cognome= cognomeInp.next();
                Cliente cliente = new Cliente(nome,cognome,email);
                this.clienteRepository.save(cliente);
                this.registerUserService.createUser(email, pass, cliente);

                a=0;

            }
        } while (a != 0);
        return true;
    }


public void creazioneDip() {

    System.out.println("\n"+"INSERISCI I DATI DEL DIPENDENTE: ");
    System.out.println("\n"+"INSERISCI NOME: ");
    Scanner nomeInp = new Scanner(System.in);
    String nome= nomeInp.next();
    System.out.println("\n"+"INSERISCI COGNOME: ");
    Scanner cognomeInp = new Scanner(System.in);
    String cognome= cognomeInp.next();
    Dipendente dipendente = new Dipendente(nome,cognome);
    this.dipendenteRepository.save(dipendente);
    this.registerUserService.createdip("dipendenti@chalet.it", "dipendente1", dipendente);
    System.out.println("\n" + "DIPENDENTE CREATO: " +
            "\n" + dipendente +
            "\n");


}





public boolean loginTitolare() {
    System.out.println("ACCESSO CONSENTITO SOLO CON CREDENZIALI AMMINISTRATORE");
    int a = 4;
    do {
        System.out.println("Inserisci email: ");
        Scanner emailIn = new Scanner(System.in);
        String email = emailIn.next();
        System.out.println("Inserisci password: ");
        Scanner passIn = new Scanner(System.in);
        String pass = passIn.next();
        if (email.equals("titolare@chalet.it") && pass.equals("titolare1")) {
            System.out.println("login avveenuto con successo");
            System.out.print("BENVENUTO AMMINISTRATORE" + "\n");
            return true;
        } else {
            System.out.println("LOGIN ERRATO,RIPROVARE");
            a = 0;
            continue;
        }

    } while (a == 0);
    return false;
}

}
