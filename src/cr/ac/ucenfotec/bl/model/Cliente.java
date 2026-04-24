package cr.ac.ucenfotec.bl.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private String email;

    public Cliente(String nombre, String email) {
        super(nombre);
        this.email = email;
    }

    //getters
    public String getEmail() {return email;}

    public String toString() {
        return getNombre() + " | " + email;
    }

}
