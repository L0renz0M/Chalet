package it.unicam.ids.tranquillo.views;

import it.unicam.ids.tranquillo.entities.*;
import it.unicam.ids.tranquillo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
    @Autowired
    PagamentoService pagamentoService;


    public void start(){
      int a;
    do{
        SessioneService sessione = SessioneService.getInstance(); //CI DA UN' ISTANZA SESSIONE SU CUI LAVORARE
        sessione.getCliente();
    System.out.println("\n"+"BENVENUTO "+sessione.getCliente().getNome()+" " + sessione.getCliente().getCognome()+
            "\n"+"MENU PER PRENOTAZIONE ATTREZZATURA SPIAGGIA"+
            "\n digita:" +
            "\n 1- per prenotare un'attrezzatura " +
            "\n 2- per prenotare un prodotto del bar" +
            "\n 3- per prenotare un'attivita sportiva" +
            "\n 4- per ricapitolare le proprie prenotazioni" +
            "\n 5- per pagare le prenotazioni/ordinazioni"+
            "\n 0- per uscire dal menu");
    Scanner input= new Scanner(System.in);
    a = input.nextInt();
    String back = null;
    boolean checkInAtMorning = true ;
    boolean checkOutAtMorning = false ;
    Date checkinDate = null;
    Date checkOutDate = null;
    Date data=new Date();
    switch (a){
        case 1:
           do {
               do {
                   System.out.println("Inserire le date per la prenotazione: checkin -- checkout [gg/mm/yyyy] :");
                   Scanner checkinInp = new Scanner(System.in);
                   String checkin = checkinInp.next();
                   try {
                       DateFormat formatoData = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
                       //imposta che i calcoli di conversione della data siano rigorosi
                       formatoData.setLenient(false);
                       checkinDate = formatoData.parse(checkin);

                   } catch (ParseException e) {
                       System.out.println("Formato data non valido.");
                   }
                   Scanner checkOutInp = new Scanner(System.in);
                   String checkout = checkOutInp.next();
                   try {
                       DateFormat formatoData = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
                       //imposta che i calcoli di conversione della data siano rigorosi
                       formatoData.setLenient(false);
                       checkOutDate = formatoData.parse(checkout);
                   } catch (ParseException e) {
                       System.out.println("Formato data non valido.");
                   }
                   if (checkinDate.compareTo(checkOutDate) > 0) {
                       System.out.print("Errore! Data checkin successiva al checkout");
                   }
                   if (checkinDate.compareTo(data)<-1){
                       System.out.print("Errore! La data del checkin deve essere uguale o maggiore alla data odierna"+"\n");

                   }
            }while(checkinDate.compareTo(checkOutDate)>0 || checkinDate.compareTo(data)<-1);

               if(checkinDate.compareTo(checkOutDate) == 0) {
                   System.out.println("il checkin e il checkout corrispondono: prenotare per tutta la giornata o solo per mezza ?");
                   Scanner inputScelta = new Scanner(System.in);
                   String scelta = inputScelta.next();
                   if (scelta.startsWith("mezza")) {
                       System.out.println("Mattina o pomeriggio");
                       Scanner inputOra = new Scanner(System.in);
                       String ora = inputScelta.next();
                       if (ora.startsWith("mattina")) {
                           checkInAtMorning = true;
                           checkOutAtMorning = true;

                       }else {
                           checkInAtMorning = false;
                           checkOutAtMorning = false;
                       }
                       }
                   }
               List<Attrezzatura> listaAttrezzatura = this.attrezzaturaService.getAttrezzaturaNonPrenotateAtDate(checkinDate,checkOutDate,checkInAtMorning,checkOutAtMorning);
               System.out.println("Lista attrezzatura disponibili" + "\n" + listaAttrezzatura);
               if (listaAttrezzatura.size() <= 0) {
                   System.out.println("Lista attrezzatura vuota");
                   break;
               }
               System.out.println("inserisci il numero dell'attrezzatura da selezionare");//controllo personale
               Scanner selezioneNumero = new Scanner(System.in);
               int inpNum = selezioneNumero.nextInt() ;
               Attrezzatura attrezzatura= this.attrezzaturaService.selectAttrezzatura(inpNum);
               this.prenotazioneService.createPrenotazione(attrezzatura,checkinDate,checkOutDate, checkInAtMorning, checkOutAtMorning);
               System.out.println("Attrezzatura prenotata");
               System.out.println("proseguire con la prenotazione di un'attrezzatura?");
               Scanner inputBack = new Scanner(System.in);
               back = inputBack.next();

           }while(!back.toLowerCase(Locale.ROOT).startsWith("no"));
            break;
        case 2:
            if(this.prenotazioneService.puoPrenotare()==true){
                do{
            List<ProdottoBar> listaProdottiBar = this.prodottoBarService.getProdottiBar();
            System.out.println("Lista prodotti bar disponibili nello chalet" + "\n" + listaProdottiBar);
            System.out.println("inserisci il numero del prodotto da selezionare" );
            Scanner selezioneProd = new Scanner(System.in);
            int inpProd = selezioneProd.nextInt();
            ProdottoBar prodottoBar = this.prodottoBarService.selectProdottoBar(inpProd);
            System.out.println("inserisci la quantita per il prodotto  selezionato");
            Scanner qtaProd = new Scanner(System.in);
            int qta = qtaProd.nextInt();
            double prezzoTotale=qta*prodottoBar.getPrezzo();
            this.ordinazioneService.createOrdinazioneProdotti(prodottoBar, qta, prezzoTotale);
            System.out.println("\n" + "prodotto" + prodottoBar + " prenotato");
            System.out.println("proseguire con la prenotazione di un prodotto del bar?");
            Scanner inputBack= new Scanner(System.in);
            back = inputBack.next();
                  }while(!back.toLowerCase(Locale.ROOT).startsWith("no"));
            }else{System.out.println("Per poter ordinare prodotti al bar bisogna avere un ombrellone/parasole nella giornata odierna");

            }

            break;
    
        case 3:
            if(this.prenotazioneService.puoPrenotare()==true){
            do{
                List<AttivitaSportiva> listaAttivitaSportiva = this.attivitaSportivaService.getAttivitaSportiva();
                System.out.println("Lista attivita sportive disponibili" + "\n" + listaAttivitaSportiva);
                if (listaAttivitaSportiva.size() <= 0) {
                    System.out.println("Lista attività vuota");
                    break;
                }
                System.out.println("inserisci il numero dell'attivitao da selezionare" );
                Scanner selezioneAtt = new Scanner(System.in);
                int inpAtt = selezioneAtt.nextInt();
                AttivitaSportiva attivitaSportiva = this.attivitaSportivaService.selectAttivitaSportiva(inpAtt);
                System.out.println("inserisci il numero di posti da riservare per l'attivita");
                Scanner qtaPosti = new Scanner(System.in);
                int qta = qtaPosti.nextInt();
                this.riservazioneAttivitaService.createRiservazioneAttivita(attivitaSportiva, qta);
                System.out.println("\n"+"attivita" + attivitaSportiva + "prenotata");
                System.out.println("proseguire con la prenotazione di un'altra attivita?");
                Scanner inputBack= new Scanner(System.in);
                back = inputBack.next();
            }while(!back.toLowerCase(Locale.ROOT).startsWith("no"));
            }else {
                System.out.println("Per potersi iscrivere ad un'attività sportiva bisogna avere un ombrellone/parasole nella giornata odierna");
            }
            break;
        case 4:
            sessione = SessioneService.getInstance(); //CI DA UN' ISTANZA SESSIONE SU CUI LAVORARE
            sessione.getCliente();

            List<Prenotazione>prenotazioniEffettuate =this.prenotazioneService.getSommarioPrenot();
            List<Ordinazione> ordinazioniEffettuate = this.ordinazioneService.getSommarioOrdin();
            List<RiservazioneAttivita>riservazioniEffettuate=this.riservazioneAttivitaService.getSommarioRiseerv();

            System.out.println(riservazioniEffettuate);
            System.out.println(ordinazioniEffettuate);
            System.out.println(prenotazioniEffettuate);
            break;


        case 5:
            System.out.println("importo PRENOTAZIONI: "+"€"+this.pagamentoService.getImportoPrenotazioni());
            System.out.println("importo ORDINAZIONI:  "+"€"+this.pagamentoService.getImportoOrdinazioni());
            double tot=0.0;
            tot=this.pagamentoService.getImportoPrenotazioni()+this.pagamentoService.getImportoOrdinazioni();
            if(tot==0){
                System.out.println("\n"+"Carrello vuoto");
                break;
            }
            System.out.println("L'importo totale da pagare è di :"+"€"+tot);
            System.out.println("Per confermare il pagamento digitare [1]");
            Scanner in = new Scanner(System.in);
            int i=in.nextInt();
            if(i==1) {
                String carta;
                String cvc;
                do {
                  System.out.println("Inserire numero carta");
                  Scanner cartaIn = new Scanner(System.in);
                  carta = cartaIn.next();
                  if (carta.length() != 16) {
                      System.out.println("Errore inserimento numero carta");
                  }
              }while (carta.length()!=16);

                do {
                    System.out.println("Inserire codice cvv");
                    Scanner cvcIn = new Scanner(System.in);
                    cvc = cvcIn.next();
                    if ((cvc.length() != 3)) {
                        System.out.println("Errore inserimento codice sicurezza");
                    }
                }while(cvc.length()!=3);
                    System.out.println("NUMERO CARTA: "+carta+"\n"
                                    +"CVV: " +cvc+
                                "\n"+"TOTALE: "+"€"+tot);
                System.out.println("Premere [1] per confermare il pagamento");
                Scanner confermaIn=new Scanner(System.in);
                int conferma= confermaIn.nextInt();
                if(conferma==1){
                    System.out.println("PAGAMENTO CONFERMATO"+"\n"
                    +"GRAZIE PER AVERCI SCELTO");
                    this.pagamentoService.setOrdinazioniPagate();
                    this.pagamentoService.setPrenotazioniPagate();
                }
            }
            break;
    }
    }
    while (a!=0);
    }



}

