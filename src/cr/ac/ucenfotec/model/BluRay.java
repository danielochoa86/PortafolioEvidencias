package cr.ac.ucenfotec.model;

public class BluRay extends Material {

    private String resolucion;

    public BluRay(int id, String titulo, int year, String resolucion) {
        super(id, titulo, year);
        this.resolucion = resolucion;
    }

    public String toString(){
        return super.toString() + " | Resolución: " + resolucion;
    }

}
