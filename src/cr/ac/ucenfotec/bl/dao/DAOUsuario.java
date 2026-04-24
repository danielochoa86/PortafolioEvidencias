package cr.ac.ucenfotec.bl.dao;

import cr.ac.ucenfotec.bl.model.Cliente;
import cr.ac.ucenfotec.bl.model.Empleado;
import cr.ac.ucenfotec.dl.Connector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOUsuario {

    private static String statement;

    public static String insertarCliente(Cliente cliente)
            throws SQLException, IOException, ClassNotFoundException {

        statement = "INSERT INTO usuario (nombre, tipo, email, puesto) VALUES ('" +
                cliente.getNombre() + "', 'CLIENTE', '" +
                cliente.getEmail() + "', null)";

        Connector.getConexion().ejecutarStatement(statement);

        return "Cliente registrado correctamente.";
    }

    public static String insertarEmpleado(Empleado empleado)
            throws SQLException, IOException, ClassNotFoundException {

        statement = "INSERT INTO usuario (nombre, tipo, email, puesto) VALUES ('" +
                empleado.getNombre() + "', 'EMPLEADO', null, '" +
                empleado.getPuesto() + "')";

        Connector.getConexion().ejecutarStatement(statement);

        return "Empleado registrado correctamente.";
    }

    public static boolean usuarioExiste(int id)
            throws SQLException, IOException, ClassNotFoundException {

        statement = "SELECT id FROM usuario WHERE id = " + id;
        ResultSet rs = Connector.getConexion().ejecutarQuery(statement);

        return rs.next();
    }

    public static ArrayList<String> listarClientes()
            throws SQLException, IOException, ClassNotFoundException {

        ArrayList<String> clientes = new ArrayList<>();

        statement = "SELECT id, nombre, email FROM usuario WHERE tipo = 'CLIENTE'";
        ResultSet rs = Connector.getConexion().ejecutarQuery(statement);

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String email = rs.getString("email");

            clientes.add(id + " | " + nombre + " | " + email);
        }

        return clientes;
    }

    public static Cliente buscarClientePorId(int id)
            throws SQLException, IOException, ClassNotFoundException {

        statement = "SELECT id, nombre, email FROM usuario WHERE id = " + id + " AND tipo = 'CLIENTE'";
        ResultSet rs = Connector.getConexion().ejecutarQuery(statement);

        if (rs.next()) {
            String nombre = rs.getString("nombre");
            String email = rs.getString("email");

            return new Cliente(nombre, email);
        }

        return null;
    }


}