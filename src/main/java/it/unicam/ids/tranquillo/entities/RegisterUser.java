package it.unicam.ids.tranquillo.entities;



import javax.persistence.*;


@Entity
public class RegisterUser {

   @Id @GeneratedValue(strategy=GenerationType.TABLE) private int id;
    private String email;;
    private String password;


    public RegisterUser(String email,String password) {
        this.email = email;
        this.password = password;
    }

    public RegisterUser() {
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne
    @JoinColumn()
    private Cliente cliente;
}
