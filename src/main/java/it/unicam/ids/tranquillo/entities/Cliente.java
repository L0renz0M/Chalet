package it.unicam.ids.tranquillo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Integer id;
    private String nome;
    private String cognome;



    public Cliente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;

    }

    public Cliente() {   }

    public Integer getId() {return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCognome() { return cognome; }

    public void setCognome(String cognome) { this.cognome = cognome; }




@OneToOne
    @JoinColumn()
    private RegisterUser registerUser;


}