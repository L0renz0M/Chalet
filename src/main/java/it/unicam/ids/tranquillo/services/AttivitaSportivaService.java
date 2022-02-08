package it.unicam.ids.tranquillo.services;

import it.unicam.ids.tranquillo.entities.AttivitaSportiva;
import it.unicam.ids.tranquillo.repositories.AttivitaSportivaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class AttivitaSportivaService {

    @Autowired
    AttivitaSportivaRepository attivitaSportivaRepository;

    public void createAttivitaSportiva(){
        System.out.println("CREAZIONE DI UNA NUOVA ATTIVITA SPORTIVA");
        System.out.println("\n"+"INSERIRE NOME ATTIVITA");
        Scanner nomeIn = new Scanner (System.in);
        String nome= nomeIn.next();
        System.out.println("\n"+"INSERIRE DESCRIZIONE PER L' ATTIVITA");
        Scanner descrIn = new Scanner (System.in);
        String descr= descrIn.next();
        System.out.println("\n"+"INSERIRE NUMERO POSTI TOTALI PER L' ATTIVITA");
        Scanner numIn = new Scanner (System.in);
        int num= numIn.nextInt();
        System.out.println("\n"+"INSERIRE LA DATA DI SVOLGIMENTO DELL' ATTIVITA");
        Scanner dateIn = new Scanner (System.in);
        String date= dateIn.next();
        AttivitaSportiva attivita = new AttivitaSportiva(nome,num,descr,date);
        this.attivitaSportivaRepository.save(attivita);
    }

    public List<AttivitaSportiva> getAttivitaSportiva(){
        List<AttivitaSportiva> attivita= new ArrayList<>();
        this.attivitaSportivaRepository.findAll().forEach((attivitaSportiva -> {
            if(attivitaSportiva.getNumeroPosti()>0){
                attivita.add(attivitaSportiva);
            }
        }));
        return attivita;
    }


}
