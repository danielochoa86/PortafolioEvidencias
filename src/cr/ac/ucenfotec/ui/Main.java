package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.system.VideoRentalSystem;

public class Main {

    public static void main(String[] args){

        VideoRentalSystem vrs = new VideoRentalSystem();
        Menu menu = new Menu(vrs);
        menu.ejecutar();
}
}
