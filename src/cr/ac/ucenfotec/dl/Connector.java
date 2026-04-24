package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.utils.Utilidades;
import java.io.IOException;
import java.sql.SQLException;

public class Connector {

    private static AccesoBD conexionBD = null;

    public static AccesoBD getConexion() throws IOException, SQLException, ClassNotFoundException {
        if (conexionBD != null) return conexionBD;
        String[] propiedades = Utilidades.getProperties();
        String address = propiedades[0] + "//" + propiedades[1] + "/" + propiedades[2];
        String user = propiedades[3];
        String pw = propiedades[4];
        return conexionBD = new AccesoBD(address,user,pw);
    }
}
