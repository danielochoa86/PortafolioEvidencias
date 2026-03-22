package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.model.*;
import cr.ac.ucenfotec.system.VideoRentalSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private VideoRentalSystem vrs;
    private Scanner sc;
    private int u_counter;
    private int m_counter;

    public Menu(VideoRentalSystem vrs){
        this.sc = new Scanner(System.in);
        this.vrs = vrs;
        u_counter = 0;
        m_counter = 0;
    }

    public void ejecutar(){

        while (true){
            System.out.println("\n\n==== VIDEO RENTAL SYSTEM AWESOME =====");
            System.out.println("1. Registrar Empleado");
            System.out.println("2. Registrar Cliente");
            System.out.println("3. Agregar material");
            System.out.println("4. Mostrar Catalogo");
            System.out.println("5. Rentar Material");
            System.out.println("6. Devolver Material");
            System.out.println("7. Mostrar Préstamos activos");
            System.out.println("8. Salir");

            int opcion = leerEnteroMensj("\nElija:");
            switch (opcion){
                case 1 -> registrarEmpleadoUI();
                case 2 -> registrarClienteUI();
                case 3 -> registrarMarterialUI();
                case 4 -> mostrarCatalogoUI();
                case 5 -> rentarMaterialUI();
                case 6 -> devolverMaterialUI();
                case 7 -> listarPrestamosUI();
                case 8 -> {
                    System.out.println("\nSaliendo del sistema. ¡Adiós!");
                    return;
                }
                default -> opcionInvalida();
            }
        }
    }

    //metodos de registro
    public void registrarClienteUI(){
        System.out.println("\n===== REGISTRO USUARIO =====");
        String nombre = userInput("\nIngrese nombre del cliente:");
        String email = userInput("\nIngrese email del cliente:");
        Cliente user = new Cliente(u_counter++,nombre,email);
        vrs.registrarCliente(user);
        System.out.println("\nUsuario registrado: " + user.getNombre());
    }

    public void registrarEmpleadoUI(){
        System.out.println("\n===== REGISTRO EMPLEADO =====");
        String nombre = userInput("\nIngrese nombre del empleado:");
        String puesto = userInput("\nIngrese el puesto:");
        Empleado emp = new Empleado(u_counter++,nombre,puesto);
        vrs.registrarEmpleados(emp);
        System.out.println("\nUsuario registrado: " + emp.getNombre());
    }

    public void registrarMarterialUI(){
        System.out.println("\n===== REGISTRO MATERIAL =====");
        System.out.println("\nTipo de material:");
        System.out.println("1. VHS");
        System.out.println("2. DVD");
        System.out.println("3. Bluray");
        System.out.println("4. Volver");

        int seleccion = leerEnteroMensj("\nIngrese su selección:");
        System.out.println("\nIngrese la información que se le solicita");
        String titulo = userInput("Título:");

        switch (seleccion){
            case 1 -> {
                int year = leerEnteroMensj("Año de release");
                int duracion = leerEnteroMensj("Duración:");
                VHS vhs = new VHS(m_counter++,titulo,year,duracion);
                vrs.registrarMaterial(vhs);
                System.out.println("VHS Registrado: " + vhs);
            }
            case 2 -> {
                int year = leerEnteroMensj("Año de release: ");
                int region = leerEnteroMensj("Código de región:" );
                DVD dvd = new DVD(m_counter++,titulo,year,region);
                vrs.registrarMaterial(dvd);
                System.out.println("DVD Registrado: " + dvd);
            }
            case 3 -> {
                int year = leerEnteroMensj("Año de release: ");
                String resolucion = userInput("Resolución:" );
                BluRay br = new BluRay(m_counter++,titulo,year,resolucion);
                vrs.registrarMaterial(br);
                System.out.println("DVD Registrado: " + br);
            }
            case 4 -> {
                System.out.println("Regresando al menú principal.");
                return;}
            default -> opcionInvalida();
        }
    }

    //metodos varios
    public void mostrarCatalogoUI(){
        System.out.println("\n==== Catálogo ====\n");
        listarMaterialesUI();
        System.out.println("\nRegresando al menú principal.\n");
    }

    void rentarMaterialUI(){
        System.out.println("\n==== Rentar material ====\n");
        List<Material> catalogo = vrs.mostrarCatalogo();
        if (catalogo.isEmpty()){
            System.out.println("No hay material registrado aún");
            System.out.println("Regresando al menú principal");
            return;
        }
        List<Cliente> clientes = vrs.listarClientes();
        if (clientes.isEmpty()){
            System.out.println("No hay clientes registrados aún.");
            System.out.println("Registre al cliente primero.");
            System.out.println("Regresando al menú principal");
            return;
        }

        //primero selecciona al cliente que rentará el material
            System.out.println("Seleccione por su índice al cliente " +
                    "que rentará el material.");
            listarClientesUI();
            int seleccion = leerEnteroMensj("Elija:");

            //buscar al cliente
            Cliente cliente = vrs.buscarCliente(seleccion - 1);
            if (cliente == null){return;}
            System.out.println("Cliente seleccionado: " + cliente.getNombre());

        //Seleccionar el material a rentar
            System.out.println("Ahora seleccione por su índice el materioal " +
                    "que rentará " + cliente.getNombre());
            listarMaterialesUI();
            seleccion = leerEnteroMensj("Elija:");
            Material material = vrs.buscarMaterial(seleccion -1);
            if (material == null){return;}

        //Finalmente, realizamos la renta
        cliente.rentarMaterial(material);
    }

    public void devolverMaterialUI(){
        System.out.println("\n==== Devolución de material ====\n");
        System.out.println("Seleccione un cliente por su índice " +
                "para validar si tiene préstamos activos.");
        List<Cliente> clientes = listarClientesUI();
        if (clientes == null){return;}

        int seleccion = leerEnteroMensj("Elija:");

        if (seleccion <= 0 || seleccion > clientes.size()){
            opcionInvalida();
            return;
        }

        Cliente user = vrs.buscarCliente(seleccion - 1);
        if (user == null){return;}

        List<Material> prestamos = user.getPrestamos();
        if (prestamos.isEmpty()){
            System.out.println(user.getNombre() + " no tiene préstmos activos.");
            return;
        }

        //a continuacion se listan los prestamos activos del usuario
        System.out.println("A continuación se muestran los préstamos activos " +
                "de " + user.getNombre() + ". \nSeleccione un material " +
                "por su número de índice:");

        for (int i = 0; i < prestamos.size() ; i++){
            System.out.println((i+1) + " - " + prestamos.get(i).getTitulo() +
                    " - " + prestamos.get(i).getClass().getSimpleName());
        }
        //se da a elegir el material a devolver
        seleccion = leerEnteroMensj("Elija:");
        if (seleccion <= 0 || seleccion > prestamos.size()){
            opcionInvalida();
            return;
        }
        user.devolverMaterial(seleccion-1);
    }

    public void listarPrestamosUI() {
        System.out.println("\n==== Préstamos activos ====\n");
        List<Cliente> clientes = vrs.listarClientes();
        if (clientes.isEmpty()){
            System.out.println("No hay clientes registrados aún");
            return;
        }
        List<Material> prestamos;
        int contador = 1;

        for (Cliente c : clientes) {
            prestamos = c.getPrestamos();
            if (prestamos.isEmpty()) {
                continue;
            }
            for (Material m : prestamos){
                System.out.println(contador + ". " +
                        m.getTitulo() + " | " +
                        m.getClass().getSimpleName() + " | " +
                        c.getNombre());
                contador++;
            }
        }

        if (contador == 1){
            System.out.println("No hay préstamos activos.\n");
        }
        System.out.println("----------------------");
    }


    //listas UI
    public List<Material> listarMaterialesUI(){
        List<Material> catagolo = vrs.mostrarCatalogo();
        if (catagolo.isEmpty()){
            System.out.println("\nNo hay material registrado aún\n");
            return null;
        }
        for (int i = 0; i < catagolo.size() ; i++){
            System.out.println((i+1) + " - " + catagolo.get(i).getTitulo() +
                    " - " + catagolo.get(i).getClass().getSimpleName() +
                    " - " + (catagolo.get(i).estaDisponible() ? "Disponible" : "No disponible"));
        }
        return catagolo;
    }

    public List<Cliente> listarClientesUI(){
        List<Cliente> clientes = vrs.listarClientes();
        if (clientes.isEmpty()){
            System.out.println("\nNo hay clientes registrados aún\n");
            return null;
        }
        for (int i = 0; i < clientes.size() ; i++){
            System.out.println((i+1) + " - " + clientes.get(i).getNombre());
        }
        return clientes;
    }

    //lectores
    public String userInput(String p) {
        while (true) {
            System.out.println(p);
            String s = sc.nextLine();
            if (!s.isEmpty()){
                return s;
            } else
                System.out.println("Por favor, ingrese un valor.");
        }
    }

    public int leerEnteroMensj (String p){
        while (true) {
            System.out.print(p);

            try {
                String input = sc.nextLine();
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }

    public void opcionInvalida(){
        System.out.println("Opción inválida.");
    }

}
