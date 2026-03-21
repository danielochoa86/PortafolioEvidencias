package cr.ac.ucenfotec.model;

public abstract class Material implements Rentable{

    protected int id;
    protected String titulo;
    protected int year;
    protected boolean disponible;

    //constructor
    public Material(int id, String titulo, int year) {
        this.id = id;
        this.titulo = titulo;
        this.year = year;
        this.disponible = true;
    }

    //getters
    public int getId() {return id;}
    public String getTitulo() {return titulo;}
    public int getYear() {return year;}
    public boolean isDisponible() {return disponible;}

    //setters
    public void devolver(){disponible = true;}

    //métodos
    public void rentar(Usuario usuario){
        if (disponible){
            disponible = false;
        }else {
            System.out.println("El material no está disponible.");
        }
    }

    public boolean estaDisponible(){
        return disponible;
    }

    public String toString(){
        return "ID:" + id +
                " | Título: " + titulo +
                " | Año: " + year +
                " | Disponible: " + disponible;
    }

}
