package cr.ac.ucenfotec.bl.model;

public class Empleado extends Usuario {

    private String puesto;

    public Empleado(String nombre, String puesto) {
        super(nombre);
        this.puesto = puesto;
    }

    public String getPuesto() {return puesto;}

}
