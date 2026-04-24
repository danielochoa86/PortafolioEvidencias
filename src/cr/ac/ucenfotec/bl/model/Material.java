package cr.ac.ucenfotec.bl.model;

public abstract class Material implements Rentable{

    protected String titulo;
    protected int year;
    protected boolean disponible;

    //constructor
    public Material(String titulo, int year) {
        this.titulo = titulo;
        this.year = year;
        this.disponible = true;
    }

    //getters
    public String getTitulo() {return titulo;}
    public int getYear() {return year;}

    //setters
    public void devolver(){disponible = true;}

    //métodos
    public void rentar(Cliente cliente){
        if (disponible){
            disponible = false;
        }else {
            System.out.println("El material no está disponible.");
        }
    }

    public boolean estaDisponible(){return disponible;}

    public String toString(){
        return "Título: " + titulo +
                " | Año: " + year +
                " | Disponible: " + disponible;
    }

}
