package it.unicam.ids.tranquillo.views;

import it.unicam.ids.tranquillo.entities.AttivitaSportiva;
import it.unicam.ids.tranquillo.entities.Attrezzatura;
import it.unicam.ids.tranquillo.entities.ProdottoBar;
import it.unicam.ids.tranquillo.services.*;
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
    @Autowired
    OrdinazioneService ordinazioneService;
    @Autowired
    ProdottoBarService prodottoBarService;
    @Autowired
    RegisterUserService logUserService;
    @Autowired
    RiservazioneAttivitaService riservazioneAttivitaService;
    @Autowired
    AttivitaSportivaService attivitaSportivaService;

    public void start(){
      int a;
    do{
    System.out.println("\n"+"MENU PER PRENOTAZIONE ATTREZZATURA SPIAGGIA"+
            "\n digita:" +
            "\n 1- per prenotare un'attrezzatura " +//prenotare per noi=creazione ombrellone
            "\n 2- per prenotare un prodotto del bar" +
            "\n 3- per prenotare un'attivita sportiva" +
            "\n 4- per ricapitolare le prorpie prenotazioni" +
            "\n 0- per uscire dal menu");
    Scanner input= new Scanner(System.in);
    a = input.nextInt();
    switch (a){
        case 1:
            System.out.println("proseguire con la prenotazione di un'attrezzatura?");
            Scanner inputBack= new Scanner(System.in);
            String back=inputBack.next();
            if(back.startsWith("i")) {
                break;
            }
            List<Attrezzatura> listaAttrezzatura = this.attrezzaturaService.getAttrezzaturaNonPrenotaate();
            System.out.println("Lista attrezzatura disponibili" + "\n" +listaAttrezzatura);
            System.out.println("inserisci il numero dell'attrezzatura da selezionare"+listaAttrezzatura.size());//controllo personale
            Scanner selezioneNumero = new Scanner(System.in);
            int inpNum = selezioneNumero.nextInt()-1;
            Attrezzatura attrezzatura = listaAttrezzatura.get(inpNum);
            this.prenotazioneService.createPrenotazioneMod(attrezzatura);
            System.out.println("Attrezzatura prenotata");
            break;

        case 2:
            System.out.println("proseguire con la prenotazione di un prodotto del bar?");
             inputBack= new Scanner(System.in);
             back=inputBack.next();
            if(back.startsWith("no")) {
                break;
            }
            List<ProdottoBar> listaProdottiBar = this.prodottoBarService.getProdottiBar();
            System.out.println("Lista prodotti bar disponibili nello chalet" + "\n" + listaProdottiBar);

            System.out.println("inserisci il numero del prodotto da selezionare" + listaProdottiBar.size());
            Scanner selezioneProd = new Scanner(System.in);
            int inpProd = selezioneProd.nextInt() - 1;
            ProdottoBar prodottoBar = listaProdottiBar.get(inpProd);
            System.out.println("inserisci la quantita per il prodotto  selezionato");
            Scanner qtaProd = new Scanner(System.in);
            int qta = qtaProd.nextInt();
            this.ordinazioneService.createOridnazioneProdotti(prodottoBar, qta);
            System.out.println("prodotto" + prodottoBar + "prenotato");
            break;


        case 3:
            listaAttrezzatura = this.attrezzaturaService.getAttrezzaturaNonPrenotaate();
            listaProdottiBar = this.prodottoBarService.getProdottiBar();
            List<AttivitaSportiva>listaAttivita= this.attivitaSportivaService.getAttivitaSportiva();
            System.out.println("Lista prodotti bar disponibili nello chalet" + "\n" + listaProdottiBar);
            System.out.println("Lista attrezzatura disponibili" + "\n" +listaAttrezzatura);
            System.out.println("Lista aattivita disponibili" + "\n" +listaAttrezzatura);

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