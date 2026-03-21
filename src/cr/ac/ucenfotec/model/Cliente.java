package cr.ac.ucenfotec.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private String email;
    private List<Material> prestamos;

    public Cliente(int id, String nombre, String email) {
        super(id, nombre);
        this.email = email;
        this.prestamos = new ArrayList<>();
    }

    //getters
    public String getEmail() {return email;}
    public List<Material> getPrestamos() { return List.copyOf(prestamos);}

    public void rentarMaterial(Material material){
        if (material.estaDisponible()){
            material.rentar(this);
            prestamos.add(material);
        }else {
            System.out.println("Material no disponible.");
        }
    }

    public void devolverMaterial(int indice){
        if (indice >0 && indice < prestamos.size()){
            Material material = prestamos.get(indice);
            material.devolver();
            prestamos.remove(indice);
        }else {
            System.out.println("¡Índice inválido!");
        }

    }

    public Material buscarPrestamo(int indice){
        if (indice >= 0 && indice < prestamos.size()){
            return prestamos.get(indice);
        }
        return null;
    }


}
