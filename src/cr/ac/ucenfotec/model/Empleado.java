package cr.ac.ucenfotec.model;

import cr.ac.ucenfotec.system.VideoRentalSystem;

public class Empleado extends Usuario {

    private String puesto;

    public Empleado(int id, String nombre, String puesto) {
        super(id, nombre);
        this.puesto = puesto;
    }

    public String getPuesto() {return puesto;}

    //metodos
    public void registrarMaterial(VideoRentalSystem vrs, Material material){

    }

}
