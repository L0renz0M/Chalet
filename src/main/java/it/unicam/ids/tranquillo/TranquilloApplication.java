package it.unicam.ids.tranquillo;



import it.unicam.ids.tranquillo.views.CliView;
import it.unicam.ids.tranquillo.views.DipendentiView;
import it.unicam.ids.tranquillo.views.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class TranquilloApplication implements CommandLineRunner {

	@Autowired
	CliView cliView;
	@Autowired
	UserView userView;
	@Autowired
	DipendentiView dipendentiView;


	public static void main(String[] args) {
		SpringApplication.run(TranquilloApplication.class, args);
	}

	@Override//main.... run con install
	public void run(String... args) throws Exception {


		System.out.println("\n" + "BENEVENUTO NELLO CHALET 'TRANQUILLO' " + "\n" +
				"DA QUI POTRAI REGISTRARTI AI NOSTRI SERVIZI O ACCEDERVI SE SI E' GIA REGISTRATI:");
		System.out.println("SCEGLIERE :" +
				"\n" + "1- PER EFFETTUARE IL LOGIN" +
				"\n" + "2- PER EFFETTUARE LA REGISTRAZIONE"+
				"\n" + "3- PER GESTIONE PROFILI DIPENDENTE");
		Scanner inp = new Scanner(System.in);
		int a = inp.nextInt();
		switch (a) {
			case 1:
				if (userView.login() == 1) {
					cliView.start();
					break;
				} else {
					dipendentiView.start();
					break;
				}


			case 2:
				if (userView.registrazione() == true) {
					if (userView.login() == 1) {
						cliView.start();
					} else if (userView.login()== 2){
						dipendentiView.start();
					}
					break;
				}
			case 3:
				if(userView.loginTitolare()==true){
				userView.creazioneDip();
				}
				break;
		}

		}

	}

