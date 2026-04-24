package cr.ac.ucenfotec.bl.model;

public class VHS extends Material{

    private int duracionMin;

    //constructor
    public VHS(String titulo, int year, int duracionMin) {
        super(titulo, year);
        this.duracionMin = duracionMin;
    }

    public int getDuracionMin() {
        return duracionMin;
    }

    //toString
    public String toString(){
        return super.toString() + " | Duración: " + duracionMin + " min";
    }

}
