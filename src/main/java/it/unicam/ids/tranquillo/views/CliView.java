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
    RegisterUserService registerUserService;
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
    String back;
    switch (a){
        case 1:
           do {
               List<Attrezzatura> listaAttrezzatura = this.attrezzaturaService.getAttrezzaturaNonPrenotaate();
               System.out.println("Lista attrezzatura disponibili" + "\n" + listaAttrezzatura);
               if (listaAttrezzatura.size() <= 0) {
                   System.out.println("Lista attrezzatura vuota");
                   break;
               }
               System.out.println("inserisci il numero dell'attrezzatura da selezionare" + listaAttrezzatura.size());//controllo personale
               Scanner selezioneNumero = new Scanner(System.in);
               int inpNum = selezioneNumero.nextInt() - 1;
               Attrezzatura attrezzatura = listaAttrezzatura.get(inpNum);
               this.prenotazioneService.createPrenotazione(attrezzatura);
               System.out.println("Attrezzatura prenotata");
               System.out.println("proseguire con la prenotazione di un'attrezzatura?");
               Scanner inputBack = new Scanner(System.in);
               back = inputBack.next();

           }while(!back.startsWith("no"));
            break;
        case 2:
           do{
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
            System.out.println("\n"+"prodotto" + prodottoBar + "prenotato");
            System.out.println("proseguire con la prenotazione di un prodotto del bar?");
            Scanner inputBack= new Scanner(System.in);
            back = inputBack.next();
        }while(!back.startsWith("no"));
            break;

        case 3:
            do{
                List<AttivitaSportiva> listaAttivitaSportiva = this.attivitaSportivaService.getAttivitaSportiva();
                System.out.println("Lista attivita sportive disponibili" + "\n" + listaAttivitaSportiva);
                if (listaAttivitaSportiva.size() <= 0) {
                    System.out.println("Lista attività vuota");
                    break;
                }
                System.out.println("inserisci il numero dell'attivitao da selezionare" + listaAttivitaSportiva.size());
                Scanner selezioneAtt = new Scanner(System.in);
                int inpAtt = selezioneAtt.nextInt() - 1;
                AttivitaSportiva attivitaSportiva = listaAttivitaSportiva.get(inpAtt);
                System.out.println("inserisci il numero di posti da riservare per l'attivita");
                Scanner qtaPosti = new Scanner(System.in);
                int qta = qtaPosti.nextInt();
                this.riservazioneAttivitaService.createRiservazioneAttivita(attivitaSportiva, qta);
                System.out.println("\n"+"attivita" + attivitaSportiva + "prenotata");
                System.out.println("proseguire con la prenotazione di un'altra attivita?");
                Scanner inputBack= new Scanner(System.in);
                back = inputBack.next();
            }while(!back.startsWith("no"));
            break;
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