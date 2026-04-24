package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.dao.DAOUsuario;
import cr.ac.ucenfotec.bl.model.Cliente;
import cr.ac.ucenfotec.bl.model.Empleado;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorUsuario {

    public String registrarCliente(String nombre, String email)
            throws SQLException, IOException, ClassNotFoundException {

        Cliente cliente = new Cliente(nombre, email);
        return DAOUsuario.insertarCliente(cliente);
    }

    public String registrarEmpleado(String nombre, String puesto)
            throws SQLException, IOException, ClassNotFoundException {

        Empleado empleado = new Empleado(nombre, puesto);
        return DAOUsuario.insertarEmpleado(empleado);
    }

    public ArrayList<String> listarClientes()
            throws SQLException, IOException, ClassNotFoundException {

        return DAOUsuario.listarClientes();
    }

    public Cliente buscarClientePorId(int id)
            throws SQLException, IOException, ClassNotFoundException {

        return DAOUsuario.buscarClientePorId(id);
    }

    public boolean usuarioExiste(int id)
            throws SQLException, IOException, ClassNotFoundException {

        return DAOUsuario.usuarioExiste(id);
    }
}