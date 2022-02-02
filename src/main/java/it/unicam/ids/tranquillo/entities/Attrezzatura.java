package it.unicam.ids.tranquillo.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Attrezzatura {
    @Id @GeneratedValue(strategy=GenerationType.TABLE) private int id;


    public Attrezzatura() {}
    public Attrezzatura(Tipo_Attrezzatura tipo_attrezzatura) {
        this.tipo_attrezzatura = tipo_attrezzatura;
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

    @ManyToOne
@JoinColumn(name="id_tipoAttrezzatura")
private Tipo_Attrezzatura tipo_attrezzatura;

    @Override
    public String toString() {
        return "Attrezzatura:"+
        "\n" + "id=" + id +
                "\n"+" tipo_attrezzatura=" + tipo_attrezzatura +
                '}';
    }
}
