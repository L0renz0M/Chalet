package it.unicam.ids.tranquillo.views;

import it.unicam.ids.tranquillo.entities.Ombrellone;
import it.unicam.ids.tranquillo.services.OmbrelloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CliView {

    @Autowired
    OmbrelloneService ombrelloneService;

    public void start(){
      int a;
    do{
    System.out.println("MENU PER PRENOTAZIONE ATTREZZATURA SPIAGGIA"+
            "\n digita:" +
            "\n 1- per prenotare un ombrellone " +//prenotare per noi=creazione ombrellone
            "\n 2- per prenotare un parsole" +
            "\n 3- per prenotare una sdraia" +
            "\n 4- per prenotare un lettino" +
            "\n 0- per uscire dal menu");
    Scanner input= new Scanner(System.in);
    a = input.nextInt();
    switch (a){
        case 1:
            /*System.out.println("inserisci fascia desiderata");
            Scanner inputFascia = new Scanner(System.in);
            String b = inputFascia.nextLine();*/ //utente inserisce fascia da comando
            ombrelloneService.createOmbrellone(new Ombrellone("quarta"));
        case 2:
        case 3:
        case 4:
    }
    }
    while (a!=0);
    }





}
