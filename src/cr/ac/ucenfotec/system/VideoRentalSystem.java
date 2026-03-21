package cr.ac.ucenfotec.system;

import cr.ac.ucenfotec.model.Cliente;
import cr.ac.ucenfotec.model.Empleado;
import cr.ac.ucenfotec.model.Material;
import cr.ac.ucenfotec.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class VideoRentalSystem {

    private List<Cliente> clientes;
    private List<Material> catalogo;
    private List<Empleado> staff;

    public VideoRentalSystem(){
        this.clientes = new ArrayList<>();
        this.catalogo = new ArrayList<>();
        this.staff = new ArrayList<>();
    }

    //getter
    public List<Material> mostrarCatalogo(){ return List.copyOf(catalogo);}

    //metodos de registro
    public void registrarCliente(Cliente user){clientes.add(user);}
    public void registrarMaterial(Material material){catalogo.add(material);}
    public void registrarEmpleados(Empleado empleado){staff.add(empleado);}

    //metodos de busqueda
    public Cliente buscarCliente(int id){
        for (Cliente c : clientes){
            if (c.getId() == id){
                return c;
            }
        } return null;
    }

    public Empleado buscarStaff(int id){
        for (Empleado e : staff){
            if (e.getId() == id){
                return e;
            }
        } return null;
    }

    public Material buscarMaterial(int id){
        for (Material m : catalogo){
            if (m.getId() == id){
                return m;
            }
        }
        return null;
    }

    //otros metodos
    public void rentarMaterial(int idCliente, int idMaterial){
        Cliente cliente = buscarCliente(idCliente);
        Material material = buscarMaterial(idMaterial);

        if (cliente == null){
            System.out.println("Cliente no encontrado.");
            return;
        }

        if (material == null){
            System.out.println("Material no encontrado.");
            return;
        }

        cliente.rentarMaterial(material);

    }

    public void devolverMaterial(int idCliente, int idMaterial){
        Cliente cliente = buscarCliente(idCliente);

        if (cliente == null){
            System.out.println("Cliente no encontrado.");
            return;
        }
        cliente.devolverMaterial(idMaterial);

    }



}
