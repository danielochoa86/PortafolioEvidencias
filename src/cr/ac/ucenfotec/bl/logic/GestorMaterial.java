package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.dao.DAOMaterial;
import cr.ac.ucenfotec.bl.model.BluRay;
import cr.ac.ucenfotec.bl.model.DVD;
import cr.ac.ucenfotec.bl.model.VHS;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorMaterial {

    public String registrarVHS(String titulo, int year, int duracionMin)
            throws SQLException, IOException, ClassNotFoundException {

        VHS vhs = new VHS(titulo, year, duracionMin);
        return DAOMaterial.insertarVHS(vhs);
    }

    public String registrarDVD(String titulo, int year, int regionCode)
            throws SQLException, IOException, ClassNotFoundException {

        DVD dvd = new DVD(titulo, year, regionCode);
        return DAOMaterial.insertarDVD(dvd);
    }

    public String registrarBluRay(String titulo, int year, String resolucion)
            throws SQLException, IOException, ClassNotFoundException {

        BluRay bluRay = new BluRay(titulo, year, resolucion);
        return DAOMaterial.insertarBluRay(bluRay);
    }

    public ArrayList<String> listarMateriales()
            throws SQLException, IOException, ClassNotFoundException {

        return DAOMaterial.listarMateriales();
    }

    public boolean materialExiste(int id)
            throws SQLException, IOException, ClassNotFoundException {

        return DAOMaterial.materialExiste(id);
    }

    public boolean consultarDisponibilidad(int id)
            throws SQLException, IOException, ClassNotFoundException {

        return DAOMaterial.consultarDisponibilidad(id);
    }
}