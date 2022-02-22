package it.unicam.ids.tranquillo.services;

import it.unicam.ids.tranquillo.entities.AttivitaSportiva;
import it.unicam.ids.tranquillo.entities.Ordinazione;
import it.unicam.ids.tranquillo.entities.Prenotazione;
import it.unicam.ids.tranquillo.entities.RiservazioneAttivita;
import it.unicam.ids.tranquillo.repositories.AttivitaSportivaRepository;
import it.unicam.ids.tranquillo.repositories.PrenotazioneRepository;
import it.unicam.ids.tranquillo.repositories.RiservazioneAttivitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class RiservazioneAttivitaService {
    @Autowired
    RiservazioneAttivitaRepository riservazioneAttivitaRepository;
    @Autowired
    AttivitaSportivaRepository attivitaSportivaRepository;
    @Autowired
    PrenotazioneRepository prenotazioneRepository;

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


    public List<RiservazioneAttivita> getSommarioRiseerv(){
        SessioneService sessione = SessioneService.getInstance();
        int id = sessione.getCliente().getId();
        List<RiservazioneAttivita> listaRiservazioniCliente = this.riservazioneAttivitaRepository.findAllByCliente_Id(id);
        return listaRiservazioniCliente;
    }




}
