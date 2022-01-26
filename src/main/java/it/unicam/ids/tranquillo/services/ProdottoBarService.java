package it.unicam.ids.tranquillo.services;

import it.unicam.ids.tranquillo.entities.ProdottoBar;
import it.unicam.ids.tranquillo.repositories.ProdottoBarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdottoBarService {
    @Autowired
    ProdottoBarRepository prodottoBarRepository;

    public ProdottoBarService(){

    }

    public void createProdottoBar(ProdottoBar prodottoBar){

        this.prodottoBarRepository.save(prodottoBar);

    }
}
