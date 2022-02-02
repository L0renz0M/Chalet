package it.unicam.ids.tranquillo.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tipo_Attrezzatura {

    @Id
    private String id;
    private String descrizione;
    private String nome;
    private double prezzoBase;


    public Tipo_Attrezzatura(String id, String descrizione, String nome, double prezzoBase) {
        this.id = id;
        this.descrizione = descrizione;
        this.nome = nome;
        this.prezzoBase = prezzoBase;
    }

    public Tipo_Attrezzatura() {

    }

    public  String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzoBase() {
        return prezzoBase;
    }

    public void setPrezzoBase(double prezzoBase) {
        this.prezzoBase = prezzoBase;
    }

    @Override
    public String toString() {
        return
                "" + id + '\'' +
                "\n"+ "descrizione='" + descrizione + '\'' +
                "\n"+ " nome='" + nome + '\'' +
                "\n"+ " prezzoBase=" + prezzoBase +
                '}';
    }
}
