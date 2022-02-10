package it.unicam.ids.tranquillo.views;

import it.unicam.ids.tranquillo.entities.Ordinazione;
import it.unicam.ids.tranquillo.services.AttivitaSportivaService;
import it.unicam.ids.tranquillo.services.AttrezzaturaService;
import it.unicam.ids.tranquillo.services.OrdinazioneService;
import it.unicam.ids.tranquillo.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class DipendentiView {
    @Autowired
    PrenotazioneService prenotazioneService;
    @Autowired
    AttrezzaturaService attrezzaturaService;
    @Autowired
    AttivitaSportivaService attivitaSportivaService;
    @Autowired
    OrdinazioneService ordinazioneService;
    public void caricamentoAttrezzaturaSpiaggia() {
        int b;
        do {
            System.out.println("\n"+"seleziona azione da svolgere come dipendete" +
                    "\n digita: " +
                    "\n 1- per inserire un OMBRELLONE  " +
                    "\n 2- per inserire una SDRAIA" +
                    "\n 3- per inserire un PARASOLE " +
                    "\n 4- per inserire un LETTINO" +
                    "\n 0- per uscire dal menu");
            Scanner in = new Scanner(System.in);
            b = in.nextInt();
            switch (b) {
                case 1:

                    try {
                        this.attrezzaturaService.createAttrezzatura("Ombrellone");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Tipo non presente");
                        break;
                    }
                    System.out.println("Ombrellone inserito");
                    break;

                case 2:
                    try {
                        this.attrezzaturaService.createAttrezzatura("Sdraia");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Tipo non presente");
                        break;
                    }
                    System.out.println("Sdraia inserito");
                    break;

                case 3:


            }
        }
        while (b != 0);
    }

    public void start() {
        int b;
        do {
            System.out.println("seleziona azione da svolgere come dipendente" +
                    "\n digita: " +
                    "\n 1- per inserire un'attrezzatura per la spiaggia " +
                    "\n 2-  per creare una nuova ATTIVITA' SPORTIVA" +
                    "\n 3- per GESTIRE ORDINAZIONI BAR CLIENTI " +
                    "\n 4- per CONSEGNARE L'ORDINAZIONE AL CLIENTE" +
                    "\n 0- per uscire dal menu");
            Scanner in = new Scanner(System.in);
            b = in.nextInt();
            switch (b) {
                case 1:
                    caricamentoAttrezzaturaSpiaggia();

                case 2:
                    this.attivitaSportivaService.createAttivitaSportiva();


                case 3:
                    List<Ordinazione> ordinazioneList=this.ordinazioneService.getListaOrdinazioni();
                    System.out.println("Elenco ordinazioni da eseguire:"+ordinazioneList);
                    System.out.println("selezionare ordinazione da eseguire");
                    Scanner numOrdInp= new Scanner(System.in);
                    int numeroOrd= numOrdInp.nextInt();
                    this.ordinazioneService.selectOrdinazione(numeroOrd);
                    break;
                case 4:
                    List<Ordinazione> ordinazioniCompletate = this.ordinazioneService.getListaOrdinazioniConsegnare();
                    System.out.println("Elenco ordinazioni pronte per essere consegnate:"+ordinazioniCompletate);
                    System.out.println("selezionare ordinazione da consegnare");
                    numOrdInp= new Scanner(System.in);
                    numeroOrd= numOrdInp.nextInt();
                    this.ordinazioneService.consegnaOrdinazione(numeroOrd);
                    break;
            }
    }while (b != 0);

    }




}