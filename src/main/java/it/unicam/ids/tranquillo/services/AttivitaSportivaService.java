package it.unicam.ids.tranquillo.services;

import it.unicam.ids.tranquillo.entities.AttivitaSportiva;
import it.unicam.ids.tranquillo.entities.ProdottoBar;
import it.unicam.ids.tranquillo.repositories.AttivitaSportivaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

@Component
public class AttivitaSportivaService {

    @Autowired
    AttivitaSportivaRepository attivitaSportivaRepository;

    public void createAttivitaSportiva(){
        System.out.println("CREAZIONE DI UNA NUOVA ATTIVITA SPORTIVA");

        System.out.println("\n"+"INSERIRE NOME ATTIVITA");
        Scanner nomeIn = new Scanner (System.in);
        String nome= nomeIn.next();

        System.out.println("\n"+"INSERIRE NUMERO POSTI TOTALI PER L' ATTIVITA");
        Scanner numIn = new Scanner (System.in);
        int num= numIn.nextInt();

        System.out.println("\n"+"INSERIRE DESCRIZIONE PER L' ATTIVITA");
        Scanner descrIn = new Scanner (System.in);
        String descr= descrIn.next();
        Date dataNow = new Date();
        Date dataD = null;
        do{
        System.out.println("\n"+"INSERIRE LA DATA DI SVOLGIMENTO DELL' ATTIVITA [gg/mm/yyyy]");
            Scanner dateIn = new Scanner(System.in);
            String data = dateIn.next();
            try {
                DateFormat formatoData = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
                //imposta che i calcoli di conversione della data siano rigorosi
                formatoData.setLenient(false);
                dataD = formatoData.parse(data);
                if (dataD.compareTo(dataNow) < -1) {
                    System.out.print("Errore! Non si può creare una attività sportiva per una data antecedente a quella odierna");

                }

            } catch (ParseException e) {
                System.out.println("Formato data non valido.");
            }

        } while (dataD.compareTo(dataNow) < -1);

        AttivitaSportiva attivita = new AttivitaSportiva(nome,num,descr,dataD);
        this.attivitaSportivaRepository.save(attivita);
        System.out.println("Attivita: "+nome+ " aggiunta");
    }

    public List<AttivitaSportiva> getAttivitaSportiva(){
        List<AttivitaSportiva> attivita= new ArrayList<>();
        this.attivitaSportivaRepository.findAll().forEach((attivitaSportiva -> {
            if(attivitaSportiva.getNumeroPosti()>0  ){
                attivita.add(attivitaSportiva);
            }
        }));
        return attivita;
    }
    public AttivitaSportiva selectAttivitaSportiva(int codiceAttivita){
        AttivitaSportiva attivitaSportiva = this.attivitaSportivaRepository.findByCodiceAttivita(codiceAttivita);
        return attivitaSportiva;
    }

}
