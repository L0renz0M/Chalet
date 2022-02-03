package it.unicam.ids.tranquillo.views;

import it.unicam.ids.tranquillo.services.AttrezzaturaService;
import it.unicam.ids.tranquillo.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DipendentiView {
    @Autowired
    PrenotazioneService prenotazioneService;
    @Autowired
    AttrezzaturaService attrezzaturaService;

    public void start(){
        int b;
        do{
        System.out.println("seleziona il tipo di attrezzatura da aggiungere"+
                "\n digita:" +
                "\n 1- per inserire un OMBRELLONE " +
                "\n 2- per inserire una SDRAIA" +
                "\n 3- per inserire un PARASOLE" +
                "\n 4- per inserire un LETTINO" +
                "\n 0- per uscire dal menu");
        Scanner in= new Scanner(System.in);
        b = in.nextInt();
        switch (b){
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
        }
     }
        while (b!=0);
    }
}
