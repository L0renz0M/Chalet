package it.unicam.ids.tranquillo.views;

import it.unicam.ids.tranquillo.entities.Ordinazione;
import it.unicam.ids.tranquillo.entities.Prenotazione;
import it.unicam.ids.tranquillo.entities.ProdottoBar;
import it.unicam.ids.tranquillo.entities.Tipo_Attrezzatura;
import it.unicam.ids.tranquillo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
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
    @Autowired
    ProdottoBarService prodottoBarService;


    public void caricamentoAttrezzaturaSpiaggia() {
        String id = null;
                    try {
                        List<Tipo_Attrezzatura> listaTipi = this.attrezzaturaService.getTipi();
                        System.out.println(listaTipi);
                        System.out.println("inserisci il tipo");
                        Scanner idIn=new Scanner(System.in);
                        id=idIn.next().toLowerCase(Locale.ROOT);
                        this.attrezzaturaService.createAttrezzatura(id);
                        System.out.println(id + " inserito");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Tipo non presente");
                    }
    }

    public void caricamentoProdottiBar() {

        String descr = null;
        Double prezzo = null;
            System.out.println("inserisci la descrizione del prodotto");
            Scanner descrizione = new Scanner(System.in);
            descr = descrizione.next();
            System.out.println("inserisci il prezzo del prodotto");
            Scanner prezzoProdotto = new Scanner(System.in);
            prezzo = Double.valueOf(prezzoProdotto.next());
            this.prodottoBarService.createProdottoBar(descr,prezzo);
            System.out.println("Prodotto inserito");

    }

    public void start() {
        int b;
        do {
            System.out.println("\n"+"Seleziona azione da svolgere come dipendente" +
                    "\n digita: " +
                    "\n 1- per INSERIRE ATTREZZATURA SPIAGGIA " +
                    "\n 2- per INSERIRE UN PRODOTTO BAR " +
                    "\n 3- per CREARE ATTIVITA' SPORTIVA" +
                    "\n 4- per GESTIRE ORDINAZIONI BAR CLIENTI " +
                    "\n 5- per CONSEGNARE L'ORDINAZIONE AL CLIENTE" +
                    "\n 6- per VISUALIZZARE LE PRENOTAZIONI"+
                    "\n 7- per APPLICARE SCONTI SU PRODOTTI BAR"+
                    "\n 0- per uscire dal menu");
            Scanner in = new Scanner(System.in);
            b = in.nextInt();
            switch (b) {
                case 1:
                    caricamentoAttrezzaturaSpiaggia();
                    break;
                case 2:
                    caricamentoProdottiBar();
                    break;

                case 3:
                    this.attivitaSportivaService.createAttivitaSportiva();
                    break;

                case 4:
                    List<Ordinazione> ordinazioneList=this.ordinazioneService.getListaOrdinazioni();
                    System.out.println("Elenco ordinazioni da eseguire:"+ordinazioneList);
                    if(ordinazioneList.size()==0){
                        break;
                    }
                    System.out.println("selezionare ordinazione da eseguire");
                    Scanner numOrdInp= new Scanner(System.in);
                    int numeroOrd= numOrdInp.nextInt();
                    this.ordinazioneService.selectOrdinazione(numeroOrd);
                    break;
                case 5:
                    List<Ordinazione> ordinazioniCompletate = this.ordinazioneService.getListaOrdinazioniConsegnare();
                    System.out.println("Elenco ordinazioni pronte per essere consegnate:"+ordinazioniCompletate);
                    if(ordinazioniCompletate.size()==0){
                        break;
                    }
                    System.out.println("selezionare ordinazione da consegnare");
                    numOrdInp= new Scanner(System.in);
                    numeroOrd= numOrdInp.nextInt();
                    this.ordinazioneService.consegnaOrdinazione(numeroOrd);
                    break;

                case 6:
                    List<Prenotazione>elencoPrenotazioniClienti = this.prenotazioneService.getListaPrenotazioni();
                    System.out.println("Elenco prenotazioni effettuate"+"\n" +elencoPrenotazioniClienti);
                    break;
                case 7:
                    this.prodottoBarService.createPromozioneProdotti();
                    break;

            }
    }while (b != 0);

    }




}