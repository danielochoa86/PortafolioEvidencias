package cr.ac.ucenfotec.bl.model;

public class DVD extends Material {

    private int regionCode;

    public DVD(String titulo, int year, int regionCode) {
        super(titulo, year);
        this.regionCode = regionCode;
    }

    public int getRegionCode() {
        return regionCode;
    }

    //toString
    public String toString(){
        return super.toString() + " | Región: " + regionCode;
    }

}
