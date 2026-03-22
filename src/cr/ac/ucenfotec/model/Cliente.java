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
        if (material == null){
            System.out.println("Material inválido");
            return;
        }
        if (!material.estaDisponible()){
            System.out.println("Material no disponible.");
            return;
        }
        material.rentar(this);
        prestamos.add(material);

        System.out.println("\n" + nombre + " ha rentado " + material.getTitulo() +
                " en formato " + material.getClass().getSimpleName());

    }

    public void devolverMaterial(int indice){
        Material material = prestamos.get(indice);
        material.devolver();
        prestamos.remove(indice);
        System.out.println(nombre + ", ¡" + material.getTitulo() + " devuelto correctamente!");
    }

}
