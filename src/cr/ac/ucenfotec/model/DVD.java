package cr.ac.ucenfotec.model;

public class DVD extends Material {

    private int regionCode;

    public DVD(int id, String titulo, int year, int regionCode) {
        super(id, titulo, year);
        this.regionCode = regionCode;
    }

    //toString
    public String toString(){
        return super.toString() + " | Región: " + regionCode;
    }

}
