package cr.ac.ucenfotec.model;

public interface Rentable {

    void rentar(Usuario usuario);
    void devolver();
    boolean estaDisponible();


}
