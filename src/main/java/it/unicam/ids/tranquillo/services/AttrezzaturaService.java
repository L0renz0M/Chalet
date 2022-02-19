package it.unicam.ids.tranquillo.services;

import it.unicam.ids.tranquillo.entities.Attrezzatura;
import it.unicam.ids.tranquillo.entities.Prenotazione;
import it.unicam.ids.tranquillo.entities.Tipo_Attrezzatura;
import it.unicam.ids.tranquillo.repositories.AttrezzaturaRepository;
import it.unicam.ids.tranquillo.repositories.PrenotazioneRepository;
import it.unicam.ids.tranquillo.repositories.Tipo_AttrezzaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class AttrezzaturaService {

    @Autowired
    AttrezzaturaRepository attrezzaturaRepository;
    @Autowired
    Tipo_AttrezzaturaRepository tipo_attrezzaturaRepository;
    @Autowired
    PrenotazioneRepository prenotazioneRepository;

    public List<Tipo_Attrezzatura> getTipi(){
        return this.tipo_attrezzaturaRepository.findAll();
    }

    public void createAttrezzatura(String id) throws IllegalArgumentException{
        Tipo_Attrezzatura tipo;
        try {
         tipo = tipo_attrezzaturaRepository.findById(id)
                                 .orElseThrow();
        }
        catch (NoSuchElementException e){
            throw new IllegalArgumentException();

        }
        this.createAttrezzatura(tipo);
    }

    public void createAttrezzatura(Tipo_Attrezzatura tipo_attrezzatura){
        Attrezzatura attrezzatura = new Attrezzatura(tipo_attrezzatura);
        this.attrezzaturaRepository.save(attrezzatura);
    }

    public List<Attrezzatura> getAttrezzaturaNonPrenotateAtDate(Date checkIn,Date checkOut,boolean checkInAtMorning, boolean checkOutAtMorning) {
        List<Prenotazione> listaPrenotazioni = this.prenotazioneRepository.findAll();
        List<Attrezzatura> listaAttrezzature = this.attrezzaturaRepository.findAll();
        List<Attrezzatura> attrezzatureNonPrenotate = this.attrezzaturaRepository.findAll();

        for(Prenotazione prenotazione : listaPrenotazioni) {
            Date dataPrenotazioneI = prenotazione.getCheckIn();
            Date dataPrenotazioneO = prenotazione.getCheckOut();
            Attrezzatura atrzToRemove = prenotazione.getAttrezzatura(); //atrz che potrebbe non andare bene per la prentoaz

            if(checkIn.compareTo(dataPrenotazioneI)<0 && checkOut.compareTo(dataPrenotazioneI)<0){
                return listaAttrezzature;
            }
            if(checkIn.compareTo(dataPrenotazioneO)>0 && checkOut.compareTo(dataPrenotazioneO)>0){
                return listaAttrezzature;
            }


            if (checkIn.compareTo(dataPrenotazioneI) > 0 || checkIn.compareTo(dataPrenotazioneO) <= 0){
                    if (checkIn.compareTo(dataPrenotazioneO) == 0) {
                        if (!prenotazione.isCheckOutAtMorning() && checkInAtMorning) { //prima or
                            attrezzatureNonPrenotate.remove(atrzToRemove);
                        } //nel blocco degli if manca controllo per checkin è< della data e out>data

                    } else {
                        attrezzatureNonPrenotate.remove(atrzToRemove);

                    }
                }



                    if (checkOut.compareTo(dataPrenotazioneI) >= 0 && checkOut.compareTo(dataPrenotazioneO) < 0) {
                        if (checkOut.compareTo(dataPrenotazioneI) == 0) {
                            if (prenotazione.isCheckInAtMorning() && !checkOutAtMorning) {
                                attrezzatureNonPrenotate.remove(atrzToRemove);

                            }
                        } else {
                            attrezzatureNonPrenotate.remove(atrzToRemove);

                        }
                    }
                }
        return attrezzatureNonPrenotate;
        }



public Attrezzatura selectAttrezzatura(int id){
      Attrezzatura attrezzatura = this.attrezzaturaRepository.findById(id);
      return attrezzatura;
}

}
