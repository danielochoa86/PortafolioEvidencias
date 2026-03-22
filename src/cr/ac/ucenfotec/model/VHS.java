package cr.ac.ucenfotec.model;

public class VHS extends Material{

    private int duracionMin;

    //constructor
    public VHS(int id, String titulo, int year, int duracionMin) {
        super(id, titulo, year);
        this.duracionMin = duracionMin;
    }

    //toString
    public String toString(){
        return super.toString() + " | Duración: " + duracionMin + " min";
    }

}
