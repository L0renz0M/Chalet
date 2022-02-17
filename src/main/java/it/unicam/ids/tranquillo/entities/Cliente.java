package it.unicam.ids.tranquillo.entities;

import javax.persistence.*;



@Entity
public class Cliente {
    @Id @GeneratedValue(strategy= GenerationType.TABLE) private int id;
    private String nome;
    private String cognome;
    private String email;

    public Cliente(String nome, String cognome,String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.email=email;
    }

    public Cliente() {   }

    public Integer getId() {return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCognome() { return cognome; }

    public void setCognome(String cognome) { this.cognome = cognome; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return      "\n" +"CLIENTE" +
                       " id= " + id +
                "\n" + " nome= " + nome +
                "\n" + " cognome= " + cognome +
                "\n" + " email= " + email +
                "\n" + " prenotazione= " + prenotazione +
               "\n" + " ordinazione= " + ordinazione ;
    }

    @OneToOne
    private Prenotazione prenotazione;


    @OneToOne
    private Ordinazione ordinazione;

}
