package it.unicam.ids.tranquillo.services;


import it.unicam.ids.tranquillo.entities.Ordinazione;
import it.unicam.ids.tranquillo.entities.ProdottoBar;
import it.unicam.ids.tranquillo.repositories.OridinazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrdinazioneService {

    @Autowired
    OridinazioneRepository ordinazioneRepository;


    public void createOridnazioneProdotti(ProdottoBar prodottoBar, int quantita) { //da non toccare
            Ordinazione ordinazione = new Ordinazione(prodottoBar,quantita);
            SessioneService sessione = SessioneService.getInstance(); //CI DA UN' ISTANZA SESSIONE SU CUI LAVORARE
            ordinazione.setCliente(sessione.getCliente());
            this.ordinazioneRepository.save(ordinazione);
    }





}
