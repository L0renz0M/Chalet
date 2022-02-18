package it.unicam.ids.tranquillo.repositories;


import it.unicam.ids.tranquillo.entities.Tipo_Attrezzatura;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Tipo_AttrezzaturaRepository extends CrudRepository<Tipo_Attrezzatura,String> {

List<Tipo_Attrezzatura>  findAll();

}
