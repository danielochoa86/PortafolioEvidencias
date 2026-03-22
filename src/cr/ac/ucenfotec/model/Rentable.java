package cr.ac.ucenfotec.model;

public interface Rentable {

    void rentar(Cliente cliente);
    void devolver();
    boolean estaDisponible();


}
