package it.unicam.ids.tranquillo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dipendente {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE) private Integer id;
    private String nome;
    private String cognome;
    private String email="dipendenti@chalet.com";

    public Dipendente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        this.email=email;
    }

    public Dipendente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return      "\n" +"DIPENDENTE"+
                       " id= " + id +
                "\n" + " nome= " + nome +
                "\n" + " cognome= " + cognome +
                "\n" + " email= " + email ;
    }
}
