package it.unicam.ids.tranquillo.services;

import it.unicam.ids.tranquillo.entities.Ombrellone;
import it.unicam.ids.tranquillo.repositories.OmbrelloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OmbrelloneService {
    @Autowired // fa una pseudo creazione di una classe con i propri valori(DependencyIngection)
    OmbrelloneRepository ombrelloneRepository ;

    public OmbrelloneService (){

    }
public void createOmbrellone(Ombrellone ombrellone){
        this.ombrelloneRepository.save(ombrellone);
}

}
