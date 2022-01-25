package it.unicam.ids.tranquillo;

import it.unicam.ids.tranquillo.entities.Ombrellone;
import it.unicam.ids.tranquillo.services.OmbrelloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TranquilloApplication implements CommandLineRunner {

	@Autowired
	OmbrelloneService ombrelloneService;



	public static void main(String[] args) {
		SpringApplication.run(TranquilloApplication.class, args);
	}

	@Override//main.... run con install
	public void run(String... args) throws Exception {
		Ombrellone ombrellone = new Ombrellone("prima");

		this.ombrelloneService.createOmbrellone(ombrellone);



	}
}
