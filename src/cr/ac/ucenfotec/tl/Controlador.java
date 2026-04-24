package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.logic.GestorMaterial;
import cr.ac.ucenfotec.bl.logic.GestorPrestamo;
import cr.ac.ucenfotec.bl.logic.GestorUsuario;
import cr.ac.ucenfotec.bl.model.Cliente;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controlador {

    private GestorUsuario gestorUsuario;
    private GestorMaterial gestorMaterial;
    private GestorPrestamo gestorPrestamo;

    public Controlador() {
        gestorUsuario = new GestorUsuario();
        gestorMaterial = new GestorMaterial();
        gestorPrestamo = new GestorPrestamo();
    }

    public String registrarCliente(String nombre, String email)
            throws SQLException, IOException, ClassNotFoundException {
        return gestorUsuario.registrarCliente(nombre, email);
    }

    public String registrarEmpleado(String nombre, String puesto)
            throws SQLException, IOException, ClassNotFoundException {
        return gestorUsuario.registrarEmpleado(nombre, puesto);
    }

    public ArrayList<String> listarClientes()
            throws SQLException, IOException, ClassNotFoundException {
        return gestorUsuario.listarClientes();
    }

    public Cliente buscarClientePorId(int id)
            throws SQLException, IOException, ClassNotFoundException {
        return gestorUsuario.buscarClientePorId(id);
    }

    public String registrarVHS(String titulo, int year, int duracionMin)
            throws SQLException, IOException, ClassNotFoundException {
        return gestorMaterial.registrarVHS(titulo, year, duracionMin);
    }

    public String registrarDVD(String titulo, int year, int regionCode)
            throws SQLException, IOException, ClassNotFoundException {
        return gestorMaterial.registrarDVD(titulo, year, regionCode);
    }

    public String registrarBluRay(String titulo, int year, String resolucion)
            throws SQLException, IOException, ClassNotFoundException {
        return gestorMaterial.registrarBluRay(titulo, year, resolucion);
    }

    public ArrayList<String> listarMateriales()
            throws SQLException, IOException, ClassNotFoundException {
        return gestorMaterial.listarMateriales();
    }

    public String registrarPrestamo(int idCliente, int idMaterial)
            throws SQLException, IOException, ClassNotFoundException {
        return gestorPrestamo.registrarPrestamo(idCliente, idMaterial);
    }

    public String devolverPrestamo(int idCliente, int idMaterial)
            throws SQLException, IOException, ClassNotFoundException {
        return gestorPrestamo.devolverPrestamo(idCliente, idMaterial);
    }

    public ArrayList<String> listarPrestamos()
            throws SQLException, IOException, ClassNotFoundException {
        return gestorPrestamo.listarPrestamos();
    }

    public ArrayList<String> listarPrestamosPorCliente(int idCliente)
        throws SQLException,IOException,ClassNotFoundException{
        return gestorPrestamo.listarPrestamosPorCliente(idCliente);
    }
}