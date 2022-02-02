package it.unicam.ids.tranquillo.services;

import it.unicam.ids.tranquillo.entities.Attrezzatura;
import it.unicam.ids.tranquillo.entities.Prenotazione;
import it.unicam.ids.tranquillo.repositories.AttrezzaturaRepository;
import it.unicam.ids.tranquillo.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Component
public class PrenotazioneService {
    @Autowired
    PrenotazioneRepository prenotazioneRepository;

public PrenotazioneService(){

    }
  /* public void createPrenotazione(Prenotazione prenotazione){
        this.prenotazioneRepository.save(prenotazione);
    }
*/
    public void createPrenotazione(Attrezzatura attrezzatura) { //da non toccare
        Prenotazione prenotazione = new Prenotazione(attrezzatura);
        this.prenotazioneRepository.save(prenotazione);
    }


}
