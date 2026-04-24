package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.bl.model.*;
import cr.ac.ucenfotec.tl.Controlador;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private Controlador controlador;
    private Scanner sc;

    public Menu(){
        controlador = new Controlador();
        this.sc = new Scanner(System.in);
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
                case 3 -> registrarMaterialUI();
                case 4 -> listarMaterialesUI();
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
        try {
            System.out.println("\n===== REGISTRO USUARIO =====");
            String nombre = userInput("\nIngrese nombre del cliente:");
            String email = userInput("\nIngrese email del cliente:");

            String resultado = controlador.registrarCliente(nombre, email);
            System.out.println("\n" + resultado);

        } catch (Exception e) {
            System.out.println("Ocurrió un error al registrar el cliente.");
        }
    }

    public void registrarEmpleadoUI(){
        try {
            System.out.println("\n===== REGISTRO EMPLEADO =====");
            String nombre = userInput("\nIngrese nombre del empleado:");
            String puesto = userInput("\nIngrese el puesto:");

            String resultado = controlador.registrarEmpleado(nombre, puesto);
            System.out.println("\n" + resultado);

        } catch (Exception e) {
            System.out.println("Ocurrió un error al registrar el empleado.");
        }
    }

    public void registrarMaterialUI(){
        try {
            System.out.println("\n===== REGISTRO MATERIAL =====");
            System.out.println("\nTipo de material:");
            System.out.println("1. VHS");
            System.out.println("2. DVD");
            System.out.println("3. Bluray");
            System.out.println("4. Volver");

            int seleccion = leerEnteroMensj("\nIngrese su selección:");

            if (seleccion == 4) {
                System.out.println("Regresando al menú principal.");
                return;
            }

            if (seleccion < 1 || seleccion > 4) {
                opcionInvalida();
                return;
            }

            System.out.println("\nIngrese la información que se le solicita");
            String titulo = userInput("Título:");

            String resultado;

            switch (seleccion) {
                case 1 -> {
                    int year = leerEnteroMensj("Año de release:");
                    int duracion = leerEnteroMensj("Duración:");
                    resultado = controlador.registrarVHS(titulo, year, duracion);
                    System.out.println(resultado);
                }
                case 2 -> {
                    int year = leerEnteroMensj("Año de release:");
                    int region = leerEnteroMensj("Código de región:");
                    resultado = controlador.registrarDVD(titulo, year, region);
                    System.out.println(resultado);
                }
                case 3 -> {
                    int year = leerEnteroMensj("Año de release:");
                    String resolucion = userInput("Resolución:");
                    resultado = controlador.registrarBluRay(titulo, year, resolucion);
                    System.out.println(resultado);
                }
                default -> opcionInvalida();
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error al registrar el material.");
        }
    }

    //metodos varios
    public void rentarMaterialUI(){
        try {
            System.out.println("\n==== Rentar material ====\n");
            ArrayList<String> materiales = controlador.listarMateriales();

            if (materiales.isEmpty()) {
                System.out.println("No hay material registrado aún");
                System.out.println("Regresando al menú principal");
                return;
            }

            ArrayList<String> clientes = controlador.listarClientes();
            if (clientes.isEmpty()) {
                System.out.println("No hay clientes registrados aún.");
                System.out.println("Registre al cliente primero.");
                System.out.println("Regresando al menú principal");
                return;
            }

            //primero selecciona al cliente que rentará el material
            System.out.println("Seleccione por su índice al cliente " +
                    "que rentará el material.");
            listarClientesUI();

            int idCliente = leerEnteroMensj("Elija:");

            //buscar al cliente
            Cliente cliente = controlador.buscarClientePorId(idCliente);
            if (cliente == null) {
                System.out.println("Cliente no encontrado.");
                return;
            }
            System.out.println("Cliente seleccionado: " + cliente.getNombre());

            //Seleccionar el material a rentar
            System.out.println("\nAhora seleccione por su índice el material " +
                    "que rentará " + cliente.getNombre());
            listarMaterialesUI();
            int idMaterial = leerEnteroMensj("Elija:");

            //Realizar renta
            String resultado = controlador.registrarPrestamo(idCliente, idMaterial);
            System.out.println("\n" + resultado);

        } catch (Exception e) {
            System.out.println("Ocurrió un error al rentar el material: " + e.getMessage());
        }

    }

    public void devolverMaterialUI(){

        try {
            System.out.println("\n==== Devolución de material ====\n");

            ArrayList<String> clientes = controlador.listarClientes();

            if (clientes.isEmpty()){
                System.out.println("No hay clientes registrados aún.");
                System.out.println("Regresando al menú principal.");
                return;
            }

            System.out.println("Seleccione un cliente por su ID para validar " +
                    "si tiene préstamos activos:");
            listarClientesUI();

            int idCliente = leerEnteroMensj("Ingrese el ID del cliente:");

            Cliente cliente = controlador.buscarClientePorId(idCliente);

            if (cliente == null) {
                System.out.println("Cliente no encontrado.");
                return;
            }

            ArrayList<String> prestamos = controlador.listarPrestamosPorCliente(idCliente);

            if (prestamos.isEmpty()){
                System.out.println(cliente.getNombre() + " no tiene préstamos activos.");
                return;
            }

            //a continuacion se listan los prestamos activos del usuario
            System.out.println("\nA continuación se muestran los préstamos activos " +
                    "de " + cliente.getNombre() + ":");

            for (String p : prestamos){
                System.out.println(p);
            }

            int idMaterial = leerEnteroMensj("\nIngrese el ID del material a devolver:");

            String resultado = controlador.devolverPrestamo(idCliente,idMaterial);
            System.out.println("\n" + resultado);

        } catch (Exception e){
            System.out.println("Ocurrió un error al devolver el material: " + e.getMessage());
        }
    }

    //listas UI
    public void listarPrestamosUI() {
        try{
            System.out.println("\n==== Préstamos activos ====\n");

            ArrayList<String> prestamos = controlador.listarPrestamos();
            if (prestamos.isEmpty()){
                System.out.println("No hay préstamos activos.\n");
                return;
            }

            int contador = 1;

            for (String p : prestamos){
                System.out.println(contador + ". " + p);
                contador++;
            }
            System.out.println("\nRegresando al menú principal.\n");

        } catch (Exception e){
            System.out.println("Ocurrió un error al listar los préstamos: " + e.getMessage());
        }
    }

    public void listarMaterialesUI(){
        try {
            System.out.println("\n==== Catálogo ====\n");
            ArrayList<String> materiales = controlador.listarMateriales();
            if (materiales.isEmpty()){
                System.out.println("\nNo hay material registardo aún.\n");
                return;
            }
            for (String m : materiales){
                System.out.println(m);
            }

        } catch (Exception e){
            System.out.println("Ocurrió un error al listar materiales: " + e.getMessage());
        }
    }

    public void listarClientesUI(){
        try {
            ArrayList<String> clientes = controlador.listarClientes();
            if (clientes.isEmpty()){
                System.out.println("\nNo hay clientes registrados aún.\n");
                return;
            }

            for (String c : clientes){
                System.out.println(c);
            }

        } catch (Exception e){
            System.out.println("Ocurrió un error al listar los clientes: " + e.getMessage());
        }
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
