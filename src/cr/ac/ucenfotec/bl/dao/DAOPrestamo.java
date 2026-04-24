package cr.ac.ucenfotec.bl.dao;

import cr.ac.ucenfotec.bl.model.Prestamo;
import cr.ac.ucenfotec.dl.Connector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOPrestamo {

    private static String statement;

    public static String registrarPrestamo(Prestamo p)
            throws SQLException, IOException, ClassNotFoundException {

        statement = "INSERT INTO prestamo (usuario_id, material_id) VALUES (" +
                p.getUsuarioId() + ", " +
                p.getMaterialId() + ")";

        Connector.getConexion().ejecutarStatement(statement);

        return "El préstamo se registró correctamente.";
    }

    public static String eliminarPrestamo(int usuarioId, int materialId)
            throws SQLException, IOException, ClassNotFoundException {

        statement = "DELETE FROM prestamo WHERE usuario_id = " + usuarioId +
                " AND material_id = " + materialId;

        Connector.getConexion().ejecutarStatement(statement);

        return "El préstamo fue eliminado correctamente.";
    }

    public static ArrayList<String> listarPrestamos()
            throws SQLException, IOException, ClassNotFoundException {

        ArrayList<String> prestamos = new ArrayList<>();

        statement = "SELECT p.id, p.usuario_id, u.nombre, p.material_id, m.titulo " +
                "FROM prestamo p " +
                "INNER JOIN usuario u ON p.usuario_id = u.id " +
                "INNER JOIN material m ON p.material_id = m.id";

        ResultSet rs = Connector.getConexion().ejecutarQuery(statement);

        while (rs.next()) {
            int idPrestamo = rs.getInt("id");
            int idUsuario = rs.getInt("usuario_id");
            String nombreCliente = rs.getString("nombre");
            int idMaterial = rs.getInt("material_id");
            String tituloMaterial = rs.getString("titulo");

            prestamos.add(idPrestamo + " | Cliente: " + idUsuario + " - " + nombreCliente +
                    " | Material: " + idMaterial + " - " + tituloMaterial);
        }

        return prestamos;
    }

    public static ArrayList<String> listarPrestamosPorCliente(int idCliente)
        throws SQLException,IOException,ClassNotFoundException {
        ArrayList<String> prestamos = new ArrayList<>();
        statement = "SELECT p.material_id, m.titulo, m.tipo " +
            "FROM prestamo p " +
            "INNER JOIN material m ON p.material_id = m.id " +
            "WHERE p.usuario_id = " + idCliente;

        ResultSet rs = Connector.getConexion().ejecutarQuery(statement);

        while (rs.next()){
            int idMaterial = rs.getInt("material_id");
            String titulo = rs.getString("titulo");
            String tipo = rs.getString("tipo");

            prestamos.add(idMaterial + " | " + titulo + " | " + tipo);
        }

        return prestamos;
    }
}