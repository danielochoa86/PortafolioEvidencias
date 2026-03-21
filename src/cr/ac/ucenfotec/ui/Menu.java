package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.system.VideoRentalSystem;

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

        int opcion = 0;
        while (opcion != 5){
            System.out.println("==== BLOCKBUSTER WANNABE =====");
            System.out.println("1. Registrar Empleado");
            System.out.println("2. Registrar Cliente");
            System.out.println("3. Agregar material");
            System.out.println("4. Mostrar Catalogo");
            System.out.println("5. Rentar Material");
            System.out.println("6. Devolver Material");
            System.out.println("7. Ver prestamos activos");
            System.out.println("8. Salir");
        }
    }

}
