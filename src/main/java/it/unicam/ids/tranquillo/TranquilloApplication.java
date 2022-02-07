package it.unicam.ids.tranquillo;



import it.unicam.ids.tranquillo.views.CliView;
import it.unicam.ids.tranquillo.views.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class TranquilloApplication implements CommandLineRunner {

	@Autowired
	CliView cliView;
	@Autowired
	UserView userView;


	public static void main(String[] args) {
		SpringApplication.run(TranquilloApplication.class, args);
	}

	@Override//main.... run con install
	public void run(String... args) throws Exception {

		userView.registrazione();

			if (userView.login()== 1) {
				cliView.start();
			}

	}

	}