package it.unicam.ids.tranquillo.services;

import it.unicam.ids.tranquillo.entities.Ordinazione;
import it.unicam.ids.tranquillo.entities.Prenotazione;
import it.unicam.ids.tranquillo.repositories.AttrezzaturaRepository;
import it.unicam.ids.tranquillo.repositories.OrdinazioneRepository;
import it.unicam.ids.tranquillo.repositories.PrenotazioneRepository;
import it.unicam.ids.tranquillo.repositories.Tipo_AttrezzaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class PagamentoService {

    @Autowired
    PrenotazioneRepository prenotazioneRepository;
    @Autowired
    AttrezzaturaRepository attrezzaturaRepository;
    @Autowired
    Tipo_AttrezzaturaRepository tipo_attrezzaturaRepository;
    @Autowired
    OrdinazioneRepository ordinazioneRepository;

    public double getImportoPrenotazioni(){
        SessioneService sessione = SessioneService.getInstance();
        int id = sessione.getCliente().getId();
        double importo =0.0;
        double countGiorni=0;
        List<Prenotazione> listaPrenotazioniCliente = this.prenotazioneRepository.findAllByCliente_IdAndPagatoFalse(id);
        for(Prenotazione prenotazioni : listaPrenotazioniCliente){
            if(!prenotazioni.getCheckIn().equals(prenotazioni.getCheckOut())){
                countGiorni=   prenotazioni.getCheckOut().getTime()-prenotazioni.getCheckIn().getTime();
                TimeUnit time = TimeUnit.DAYS;
                countGiorni= time.convert((long) countGiorni, TimeUnit.MILLISECONDS);

            }else if((prenotazioni.getCheckIn().equals(prenotazioni.getCheckOut()))&&(prenotazioni.isCheckInAtMorning()==true&&prenotazioni.isCheckOutAtMorning()==false) ) {
                countGiorni=1;
            } else if ((prenotazioni.isCheckInAtMorning()==true && prenotazioni.isCheckOutAtMorning()==true||(prenotazioni.isCheckOutAtMorning()==false && prenotazioni.isCheckOutAtMorning()==false))){
                 countGiorni=0.5;
            }
         importo +=  prenotazioni.getAttrezzatura().getTipo_attrezzatura().getPrezzoBase()*countGiorni;
        }
        return importo;
    }

    public void setPrenotazioniPagate() {
        SessioneService sessione = SessioneService.getInstance();
        int id = sessione.getCliente().getId();
        List<Prenotazione> listaPrenotazioniCliente = this.prenotazioneRepository.findAllByCliente_IdAndPagatoFalse(id);
        for (Prenotazione prenotazioni : listaPrenotazioniCliente) {
            prenotazioni.setPagato(true);
            this.prenotazioneRepository.save(prenotazioni);
        }
    }

    public double getImportoOrdinazioni() {
        SessioneService sessione = SessioneService.getInstance();
        int id = sessione.getCliente().getId();
        double importo = 0.0;
        List<Ordinazione> listaOrdinazioniCliente = this.ordinazioneRepository.findAllByCliente_IdAndPagatoFalse(id);
        for (Ordinazione ordinazione : listaOrdinazioniCliente) {
            importo += ordinazione.getProdottoBar().getPrezzo()*ordinazione.getQuantita();
        }
        return importo;
    }

    public void setOrdinazioniPagate(){
        SessioneService sessione = SessioneService.getInstance();
        int id = sessione.getCliente().getId();
        List<Ordinazione> listaOrdinazioniCliente = this.ordinazioneRepository.findAllByCliente_IdAndPagatoFalse(id);
        for (Ordinazione ordinazione : listaOrdinazioniCliente) {
            ordinazione.setPagato(true);
            this.ordinazioneRepository.save(ordinazione);
        }
    }

}
