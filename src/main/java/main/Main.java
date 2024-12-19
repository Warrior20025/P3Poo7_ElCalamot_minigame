package main;


import classes.Personatge;

import java.util.ArrayList;

public class Main {
    private static AskData ask;
    private static ArrayList<Personatge> personajes;
    public static void main(String[] args) {
        boolean engine = true;
        while (engine) {
            System.out.println("1. Crear personaje \n2.Modificar personaje \n3. Ranking \n4.Eliminar personaje \n5. Mejor personaje \n6. Jugar \n7. SALIR");
            int opcion = ask.askInt("Dime una opción:", "Dime una opción correcta", 1, 7);
            switch (opcion) {
                case 1:
                    //todo validar que no haya dos personajes con el mismo nombre
                    String nombre = ask.askString("Dime el nombre del personaje: ");
                    for (Personatge i : personajes) {
                        if (i.getNombre().equalsIgnoreCase(nombre)) {

                        }
                    }

                    String tipo = ask.askString("Dime que tipo de personaje es " + nombre + ": ");
                    Personatge nuevoPersonaje = new Personatge(nombre, tipo);
            }

        }
    }
}