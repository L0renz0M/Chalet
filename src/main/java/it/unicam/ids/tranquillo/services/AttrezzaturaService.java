package it.unicam.ids.tranquillo.services;

import it.unicam.ids.tranquillo.entities.Attrezzatura;
import it.unicam.ids.tranquillo.entities.Tipo_Attrezzatura;
import it.unicam.ids.tranquillo.repositories.AttrezzaturaRepository;
import it.unicam.ids.tranquillo.repositories.PrenotazioneRepository;
import it.unicam.ids.tranquillo.repositories.Tipo_AttrezzaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AttrezzaturaService {

    @Autowired
    AttrezzaturaRepository attrezzaturaRepository;
    @Autowired
    Tipo_AttrezzaturaRepository tipo_attrezzaturaRepository;



    public void createAttrezzatura(String id) throws IllegalArgumentException{
        Tipo_Attrezzatura tipo;
        try {
         tipo = tipo_attrezzaturaRepository.findById(id)
                                 .orElseThrow();
        }
        catch (NoSuchElementException e){
            throw new IllegalArgumentException();

        }
        this.createAttrezzatura(tipo);
    }

    public void createAttrezzatura(Tipo_Attrezzatura tipo_attrezzatura){
        Attrezzatura attrezzatura = new Attrezzatura(tipo_attrezzatura);
        this.attrezzaturaRepository.save(attrezzatura);
    }

    public List<Attrezzatura> getAttrezzature() {
        List<Attrezzatura> attr = new ArrayList<>();
        this.attrezzaturaRepository.findAll().forEach((a) -> {
            attr.add(a);
        });
        return attr ;

        }





}
