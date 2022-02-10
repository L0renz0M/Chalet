package it.unicam.ids.tranquillo.services;


import it.unicam.ids.tranquillo.entities.Attrezzatura;
import it.unicam.ids.tranquillo.entities.ProdottoBar;
import it.unicam.ids.tranquillo.repositories.ProdottoBarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

}
