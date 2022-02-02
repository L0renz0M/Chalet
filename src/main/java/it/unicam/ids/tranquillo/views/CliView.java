package it.unicam.ids.tranquillo.views;

import it.unicam.ids.tranquillo.entities.Attrezzatura;
import it.unicam.ids.tranquillo.services.AttrezzaturaService;
import it.unicam.ids.tranquillo.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class CliView {

    @Autowired
    PrenotazioneService prenotazioneService;
    @Autowired
    AttrezzaturaService attrezzaturaService;


    public void start(){
      int a;
    do{
    System.out.println("MENU PER PRENOTAZIONE ATTREZZATURA SPIAGGIA"+
            "\n digita:" +
            "\n 1- per prenotare un ombrellone " +//prenotare per noi=creazione ombrellone
            "\n 2- per inserire ombrellone" +
            "\n 3- per prenotare una sdraia" +
            "\n 4- per prenotare un lettino" +
            "\n 0- per uscire dal menu");
    Scanner input= new Scanner(System.in);
    a = input.nextInt();
    switch (a){
        case 1:
            List<Attrezzatura> listaAttrezzatura = this.attrezzaturaService.getAttrezzature();
            System.out.println("Lista ombrelloni disponibili" + "\n" +listaAttrezzatura);
            System.out.println("inserisci il numero dell'ombrellone da selezionare"+listaAttrezzatura.size());//controllo personale
            Scanner selezioneNumero = new Scanner(System.in);
            int inpNum = selezioneNumero.nextInt()-1;
            Attrezzatura attrezzatura = listaAttrezzatura.get(inpNum);
            this.prenotazioneService.createPrenotazione(attrezzatura);
            break;


        case 2:

        case 3:

        case 4:
    }
    }
    while (a!=0);
    }




}
//aggiunta attrezzatura da parte del titolare
 /*try {
         this.attrezzaturaService.createAttrezzatura("Ombrellone");
         } catch (IllegalArgumentException e) {
         System.out.println("Tipo non presente");
         break;
         }
         System.out.println("Ombrellone inserito");
         break;*/