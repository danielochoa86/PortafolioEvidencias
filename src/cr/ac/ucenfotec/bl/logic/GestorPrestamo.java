package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.dao.DAOMaterial;
import cr.ac.ucenfotec.bl.dao.DAOPrestamo;
import cr.ac.ucenfotec.bl.dao.DAOUsuario;
import cr.ac.ucenfotec.bl.model.Prestamo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorPrestamo {

    public String registrarPrestamo(int idCliente, int idMaterial)
            throws SQLException, IOException, ClassNotFoundException {

        if (!DAOUsuario.usuarioExiste(idCliente)) {
            return "No existe un usuario con ese ID.";
        }

        if (!DAOMaterial.materialExiste(idMaterial)) {
            return "No existe un material con ese ID.";
        }

        if (!DAOMaterial.consultarDisponibilidad(idMaterial)) {
            return "El material no está disponible.";
        }

        Prestamo prestamo = new Prestamo(idCliente, idMaterial);

        DAOPrestamo.registrarPrestamo(prestamo);
        DAOMaterial.actualizarDisponibilidad(idMaterial, false);

        return "El préstamo se registró correctamente.";
    }

    public String devolverPrestamo(int idCliente, int idMaterial)
            throws SQLException, IOException, ClassNotFoundException {

        if (!DAOUsuario.usuarioExiste(idCliente)) {
            return "No existe un usuario con ese ID.";
        }

        if (!DAOMaterial.materialExiste(idMaterial)) {
            return "No existe un material con ese ID.";
        }

        DAOPrestamo.eliminarPrestamo(idCliente, idMaterial);
        DAOMaterial.actualizarDisponibilidad(idMaterial, true);

        return "La devolución se realizó correctamente.";
    }

    public ArrayList<String> listarPrestamos()
            throws SQLException, IOException, ClassNotFoundException {

        return DAOPrestamo.listarPrestamos();
    }

    public ArrayList<String> listarPrestamosPorCliente(int idCliente)
        throws SQLException,IOException,ClassNotFoundException{
        return DAOPrestamo.listarPrestamosPorCliente(idCliente);
    }
}