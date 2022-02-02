package it.unicam.ids.tranquillo.views;

import it.unicam.ids.tranquillo.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DipendentiView {
    @Autowired
    PrenotazioneService prenotazioneService;

}
