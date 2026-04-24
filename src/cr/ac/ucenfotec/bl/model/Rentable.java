package cr.ac.ucenfotec.bl.model;

public interface Rentable {

    void rentar(Cliente cliente);
    void devolver();
    boolean estaDisponible();


}
