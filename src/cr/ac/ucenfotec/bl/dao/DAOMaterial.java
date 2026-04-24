package cr.ac.ucenfotec.bl.dao;

import cr.ac.ucenfotec.bl.model.BluRay;
import cr.ac.ucenfotec.bl.model.DVD;
import cr.ac.ucenfotec.bl.model.VHS;
import cr.ac.ucenfotec.dl.Connector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOMaterial {

    private static String statement;

    public static String insertarVHS(VHS vhs)
            throws SQLException, IOException, ClassNotFoundException {

        statement = "INSERT INTO material (titulo, year, tipo, disponible, region_code, resolucion, duracion_min) VALUES ('" +
                vhs.getTitulo() + "', " +
                vhs.getYear() + ", 'VHS', " +
                vhs.estaDisponible() + ", null, null, " +
                vhs.getDuracionMin() + ")";

        Connector.getConexion().ejecutarStatement(statement);

        return "El VHS se registró correctamente.";
    }

    public static String insertarDVD(DVD dvd)
            throws SQLException, IOException, ClassNotFoundException {

        statement = "INSERT INTO material (titulo, year, tipo, disponible, region_code, resolucion, duracion_min) VALUES ('" +
                dvd.getTitulo() + "', " +
                dvd.getYear() + ", 'DVD', " +
                dvd.estaDisponible() + ", " +
                dvd.getRegionCode() + ", null, null)";

        Connector.getConexion().ejecutarStatement(statement);

        return "El DVD se registró correctamente.";
    }

    public static String insertarBluRay(BluRay bluRay)
            throws SQLException, IOException, ClassNotFoundException {

        statement = "INSERT INTO material (titulo, year, tipo, disponible, region_code, resolucion, duracion_min) VALUES ('" +
                bluRay.getTitulo() + "', " +
                bluRay.getYear() + ", 'BLURAY', " +
                bluRay.estaDisponible() + ", null, '" +
                bluRay.getResolucion() + "', null)";

        Connector.getConexion().ejecutarStatement(statement);

        return "El BluRay se registró correctamente.";
    }

    public static String actualizarDisponibilidad(int id, boolean disponible)
            throws SQLException, IOException, ClassNotFoundException {

        statement = "UPDATE material SET disponible = " + disponible +
                " WHERE id = " + id;

        Connector.getConexion().ejecutarStatement(statement);

        return "La disponibilidad del material fue actualizada.";
    }

    public static boolean materialExiste(int id)
            throws SQLException, IOException, ClassNotFoundException {

        String statement = "SELECT id FROM material WHERE id = " + id;
        ResultSet rs = Connector.getConexion().ejecutarQuery(statement);

        return rs.next();
    }

    public static boolean consultarDisponibilidad(int id)
            throws SQLException, IOException, ClassNotFoundException {

        String statement = "SELECT disponible FROM material WHERE id = " + id;
        ResultSet rs = Connector.getConexion().ejecutarQuery(statement);

        if (rs.next()) {
            return rs.getBoolean("disponible");
        }

        return false;
    }

    public static ArrayList<String> listarMateriales()
            throws SQLException, IOException, ClassNotFoundException {

        ArrayList<String> materiales = new ArrayList<>();

        statement = "SELECT id, titulo, year, tipo, disponible FROM material";
        ResultSet rs = Connector.getConexion().ejecutarQuery(statement);

        while (rs.next()) {
            int id = rs.getInt("id");
            String titulo = rs.getString("titulo");
            int year = rs.getInt("year");
            String tipo = rs.getString("tipo");
            boolean disponible = rs.getBoolean("disponible");

            String estado = disponible ? "Disponible" : "No disponible";

            materiales.add(id + " | " + titulo + " | " + year + " | " + tipo + " | " + estado);
        }

        return materiales;
    }
}