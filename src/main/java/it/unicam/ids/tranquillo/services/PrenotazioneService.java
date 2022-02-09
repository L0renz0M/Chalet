package it.unicam.ids.tranquillo.services;

import it.unicam.ids.tranquillo.entities.Attrezzatura;
import it.unicam.ids.tranquillo.entities.Cliente;
import it.unicam.ids.tranquillo.entities.Prenotazione;
import it.unicam.ids.tranquillo.repositories.AttrezzaturaRepository;
import it.unicam.ids.tranquillo.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Component
public class PrenotazioneService {
    @Autowired
    PrenotazioneRepository prenotazioneRepository;
    @Autowired
    AttrezzaturaRepository attrezzaturaRepository;

    public void createPrenotazione(Attrezzatura attrezzatura) {
        if (attrezzatura.isPrenotato() == false) {
            Prenotazione prenotazione = new Prenotazione(attrezzatura);
            attrezzatura.setPrenotato(true);
            SessioneService sessione = SessioneService.getInstance(); //CI DA UN' ISTANZA SESSIONE SU CUI LAVORARE
            prenotazione.setCliente(sessione.getCliente());
            this.attrezzaturaRepository.save(attrezzatura);
            this.prenotazioneRepository.save(prenotazione);
        }
    }
}

 /* public void createPrenotazione(Prenotazione prenotazione){
        this.prenotazioneRepository.save(prenotazione);
    }

    public void createPrenotazione(Attrezzatura attrezzatura) { //da non toccare
        Prenotazione prenotazione = new Prenotazione(attrezzatura);
        this.prenotazioneRepository.save(prenotazione);
    }
*/

