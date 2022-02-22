package it.unicam.ids.tranquillo.services;

import it.unicam.ids.tranquillo.entities.Attrezzatura;

import it.unicam.ids.tranquillo.entities.Prenotazione;
import it.unicam.ids.tranquillo.repositories.AttrezzaturaRepository;
import it.unicam.ids.tranquillo.repositories.PrenotazioneRepository;
import it.unicam.ids.tranquillo.repositories.Tipo_AttrezzaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Component
public class PrenotazioneService {
    @Autowired
    PrenotazioneRepository prenotazioneRepository;
    @Autowired
    AttrezzaturaRepository attrezzaturaRepository;
    @Autowired
    Tipo_AttrezzaturaRepository tipo_attrezzaturaRepository;

     public void createPrenotazione(Attrezzatura attrezzatura, Date checkin,Date checkout,boolean checkInAtMorning, boolean checkOutAtMorning) {
            Prenotazione prenotazione = new Prenotazione(checkin,checkout,checkInAtMorning, checkOutAtMorning,attrezzatura);
            attrezzatura.setPrenotato(true);
            SessioneService sessione = SessioneService.getInstance(); //CI DA UN' ISTANZA SESSIONE SU CUI LAVORARE
            prenotazione.setCliente(sessione.getCliente());
            this.attrezzaturaRepository.save(attrezzatura);
            this.prenotazioneRepository.save(prenotazione);

    }

    public List<Prenotazione> getListaPrenotazioni(){
        return this.prenotazioneRepository.findAll();
    }

 public boolean puoPrenotare() throws ParseException {
     SessioneService sessione = SessioneService.getInstance();
     int id = sessione.getCliente().getId();

     DateFormat formatoDataNow = new SimpleDateFormat("dd/MM/yyyy");
     Date data = new Date();
     Date dataSenzaOra=formatoDataNow.parse(formatoDataNow.format(data));


     List<Prenotazione> listaPrenotazioni = this.prenotazioneRepository.findAll();
     for (Prenotazione prenotazione : listaPrenotazioni) {
         if (prenotazione.getCliente().getId() != id) {
             continue;
         }
         if ( prenotazione.getCheckIn().compareTo(dataSenzaOra) <= 0  && prenotazione.getCheckOut().compareTo(dataSenzaOra) >=0) {
             return true;

         }
     }
     return false;

     }


     public List<Prenotazione> getSommarioPrenot(){
         SessioneService sessione = SessioneService.getInstance();
         int id = sessione.getCliente().getId();
         List<Prenotazione> listaPrenotazioniCliente = this.prenotazioneRepository.findAllByCliente_IdAndPagatoFalse(id);
         return listaPrenotazioniCliente;
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

