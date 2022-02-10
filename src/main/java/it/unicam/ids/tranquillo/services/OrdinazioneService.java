package it.unicam.ids.tranquillo.services;


import it.unicam.ids.tranquillo.entities.Ordinazione;
import it.unicam.ids.tranquillo.entities.ProdottoBar;
import it.unicam.ids.tranquillo.repositories.OrdinazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdinazioneService {

    @Autowired
    OrdinazioneRepository ordinazioneRepository;


    public void createOrdinazioneProdotti(ProdottoBar prodottoBar, int quantita) { //da non toccare
            Ordinazione ordinazione = new Ordinazione(prodottoBar,quantita);
            SessioneService sessione = SessioneService.getInstance(); //CI DA UN' ISTANZA SESSIONE SU CUI LAVORARE
            ordinazione.setCliente(sessione.getCliente());
            this.ordinazioneRepository.save(ordinazione);
    }


public List<Ordinazione> getListaOrdinazioni(){
        return this.ordinazioneRepository.findAllByCompletatoIsFalse();
}

public void selectOrdinazione(int numeroOrd){
        Ordinazione ordinazione = this.ordinazioneRepository.findByNumeroOrdinazione(numeroOrd);
        ordinazione.setCompletato(true);
        this.ordinazioneRepository.save(ordinazione);
        System.out.println("oridnazione aggiornata ");
}


}
