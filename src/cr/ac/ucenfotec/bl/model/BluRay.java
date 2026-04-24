package cr.ac.ucenfotec.bl.model;

public class BluRay extends Material {

    private String resolucion;

    public BluRay(String titulo, int year, String resolucion) {
        super(titulo, year);
        this.resolucion = resolucion;
    }

    public String getResolucion() {
        return resolucion;
    }

    public String toString(){
        return super.toString() + " | Resolución: " + resolucion;
    }

}
