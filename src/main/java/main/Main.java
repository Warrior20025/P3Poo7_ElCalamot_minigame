package main;

import classes.Personatge;
import java.util.ArrayList;

public class Main {
    private static AskData ask;
    private static ArrayList<Personatge> personajes;

    public static void main(String[] args) {
        boolean engine = true;
        while (engine) {
            System.out.println("1. Crear personaje\n2. Modificar personaje\n3. Ranking\n4. Eliminar personatje\n5. Mejor personaje\n6. JUGAR\n7. SALIR");
            int opcion = ask.askInt("Dime una opción: ", "Dime una opción correcta: ", 1, 7);
            switch (opcion) {
                case 1:
                    String nombre = ask.askString("Dime el nombre del personaje: ");
                    int nombreRepetido = 0;
                    for (Personatge i : personajes) {
                        if (i.getNombre().equalsIgnoreCase(nombre)) {
                            nombreRepetido += 1;
                        }
                    }
                    if (nombreRepetido == 0) {
                        String tipo = ask.askString("Dime que tipo de personaje es " + nombre + ": ");
                        Personatge nuevoPersonage = new Personatge(nombre, tipo);
                    }else {
                        System.out.println("Ya hay un personaje con ese nombre.");
                    }

                case 2:

            }

        }
    }
}