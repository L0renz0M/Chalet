package it.unicam.ids.tranquillo.services;


import it.unicam.ids.tranquillo.entities.Attrezzatura;
import it.unicam.ids.tranquillo.entities.ProdottoBar;
import it.unicam.ids.tranquillo.repositories.ProdottoBarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ProdottoBarService {
    @Autowired
    ProdottoBarRepository prodottoBarRepository;

    public ProdottoBarService(){

    }

    public void createProdottoBar(ProdottoBar prodottoBar){
        this.prodottoBarRepository.save(prodottoBar);
    }


    public List<ProdottoBar> getProdottiBar() {
        List<ProdottoBar> prod = new ArrayList<>();
        this.prodottoBarRepository.findAll().forEach( (a) ->{
                        prod.add(a);
                }
        );
        return prod;
    }

    public ProdottoBar selectProdottoBar(int codice){
        ProdottoBar prodottoBar = this.prodottoBarRepository.findByCodiceP(codice);
        return prodottoBar;
    }

    public void createProdottoBar(String descr, Double prezzo) {
        ProdottoBar prodottoBar = new ProdottoBar(descr,prezzo);
        this.prodottoBarRepository.save(prodottoBar);
    }

    public void createPromozioneProdotti(){
        List<ProdottoBar> prod = new ArrayList<>();
        this.prodottoBarRepository.findAll().forEach( (a) ->{
                    prod.add(a);
                }
        );
        System.out.println("Selezionare un prodotto dalla lista:"+"\n"+prod);
        System.out.println("Inserisci il codice del prodotto da scontare");
        Scanner codIn=new Scanner(System.in);
        int codice= codIn.nextInt();
        ProdottoBar prodotto = this.prodottoBarRepository.findByCodiceP(codice);
        System.out.println("Inserisci la percentuale di sconto per " +prodotto);
        Scanner percentIn=new Scanner(System.in);
        double percent= percentIn.nextDouble();
        double nuovoPrezzo = prodotto.getPrezzo() - (prodotto.getPrezzo()*percent)/100;
        System.out.println("Percentuale di sconto applicata:"+percent +";"+"\n"+"Il nuovo prezzo è di:€"+nuovoPrezzo);
        prodotto.setPrezzo(nuovoPrezzo);
        this.prodottoBarRepository.save(prodotto);

    }



}
