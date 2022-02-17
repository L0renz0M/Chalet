package it.unicam.ids.tranquillo.entities;

import javax.persistence.*;

@Entity
public class Attrezzatura {
    @Id @GeneratedValue (strategy=GenerationType.TABLE) private int id;
    private boolean prenotato;

    public Attrezzatura() {}

    public Attrezzatura(Tipo_Attrezzatura tipo_attrezzatura) {
        this.tipo_attrezzatura = tipo_attrezzatura;
        this.prenotato=false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tipo_Attrezzatura getTipo_attrezzatura() {
        return tipo_attrezzatura;
    }

    public void setTipo_attrezzatura(Tipo_Attrezzatura tipo_attrezzatura) {
        this.tipo_attrezzatura = tipo_attrezzatura;
    }

    public boolean isPrenotato() {
        return prenotato;
    }

    public void setPrenotato(boolean prenotato) {
        this.prenotato = prenotato;
    }

    @ManyToOne
    @JoinColumn(name="id_tipoAttrezzatura")
    private Tipo_Attrezzatura tipo_attrezzatura;

    @Override
    public String toString() {
        return       "\n" +"ATTREZZATURA SPIAGGIA" +
                       "id= "+ id +
                "\n" + "tipo_attrezzatura= "+ tipo_attrezzatura +
                "\n" + "prenotato= "+prenotato;
    }
    @Override//cambiato il modo di confrontare l'attrezzatura
    public boolean equals(Object o){
        if (o instanceof Attrezzatura) {
        return    ((Attrezzatura) o).id==this.id;
        }
        return false;
    }
}
