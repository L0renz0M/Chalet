package it.unicam.ids.tranquillo.services;

import it.unicam.ids.tranquillo.entities.AttivitaSportiva;
import it.unicam.ids.tranquillo.entities.RiservazioneAttivita;
import it.unicam.ids.tranquillo.repositories.AttivitaSportivaRepository;
import it.unicam.ids.tranquillo.repositories.RiservazioneAttivitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RiservazioneAttivitaService {
    @Autowired
    RiservazioneAttivitaRepository riservazioneAttivitaRepository;
    @Autowired
    AttivitaSportivaRepository attivitaSportivaRepository;

    public void createRiservazioneAttivita(AttivitaSportiva attivitaSportiva, int posti){
        if(attivitaSportiva.getNumeroPosti() < posti){
            System.out.println("NON CI SONO ABBASTANZA POSTI PER QUESTA ATTIVITA'");
        }else {
            RiservazioneAttivita riservazione= new RiservazioneAttivita(posti,attivitaSportiva);
            int postiAgg= attivitaSportiva.getNumeroPosti()-posti;
            attivitaSportiva.setNumeroPosti(postiAgg);
            this.attivitaSportivaRepository.save(attivitaSportiva);
            SessioneService sessione = SessioneService.getInstance(); //CI DA UN' ISTANZA SESSIONE SU CUI LAVORARE
            riservazione.setCliente(sessione.getCliente());
            this.riservazioneAttivitaRepository.save(riservazione);
        }
    }




}
