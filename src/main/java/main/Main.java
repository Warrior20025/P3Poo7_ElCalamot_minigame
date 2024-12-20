package main;

import classes.Personatge;
import java.util.ArrayList;

public class Main {
    private static AskData ask;
    private static ArrayList<Personatge> personajes;

    public static void main(String[] args) {
        ask = new AskData();
        personajes = new ArrayList<>();
        boolean engine = true;
        while (engine) {
            System.out.println("1. Crear personaje\n2. Modificar personaje\n3. Ranking\n4. Eliminar personatje\n5. Mejor personaje\n6. JUGAR\n7. SALIR");
            int opcion = ask.askInt("Dime una opción: ", "Dime una opción correcta: ", 1, 7);
            switch (opcion) {
                case 1:
                    crearPersonajeMethod();
                    break;
                case 2:
                    String nombreMod = ask.askString("Dime el nombre del personaje que quieres modificar: ");
                    int nombreRepetidoMod = comprobarPersonaje(nombreMod);
                    if (nombreRepetidoMod == 1) {
                        System.out.println("\n\n");
                        System.out.println("\t\tMODIFICAR PERSONAJE");
                        int opcionMod;
                        do {
                            System.out.println("1. Modificar nombre\n2. Modificar tipo\n3. Salir");
                            opcionMod = ask.askInt("Dime una opción: ", "Dime una opción correcta: ", 1, 3);
                            switch (opcionMod) {
                                case 1:
                                    System.out.println("\n");
                                    System.out.println("\t\tMODIFICAR NOMBRE");
                                    String nombreNuevo = ask.askString("Dime el nombre nuevo de tu personaje: ");
                                    for (Personatge i : personajes) {
                                        if (i.getNombre().equalsIgnoreCase(nombreMod)) {
                                            i.setNombre(nombreNuevo);
                                        }
                                    }
//                                    for (Personatge i : personajes) {
//                                        System.out.println("nombre: " + i.getNombre() + " tipo: " + i.getTipo());
//                                    }
                                    break;
                                case 2:
                                    System.out.println("\n");
                                    System.out.println("\t\tMODIFICAR TIPO");
                                    String tipoNuevo = ask.askString("Dime el tipo que quieres para tu personaje: ");
                                    for (Personatge i : personajes) {
                                        if (i.getNombre().equalsIgnoreCase(nombreMod)) {
                                            i.setTipo(tipoNuevo);
                                        }
                                    }
                                    break;
                            }
                        }while (opcion != 3);
                    }
                    else {
                        System.out.println("No existe un personaje con este nombre.");
                    }
                    break;
            }

        }
    }






    private static void crearPersonajeMethod() {
        String nombre = ask.askString("Dime el nombre del personaje que quieres crear: ");
        int nombreRepetidoCrear = comprobarPersonaje(nombre);
        if (nombreRepetidoCrear == 0) {
            String tipo = "";
            while (!tipo.equals("guerrero") && !tipo.equals("mago") && !tipo.equals("elfo") && !tipo.equals("enano")){
                tipo = ask.askString("Dime que tipo de personaje es " + nombre + " (guerrero, mago, elfo, enano): ");
                tipo = tipo.toLowerCase();
            }

            Personatge nuevoPersonaje = new Personatge(nombre, tipo);
            personajes.add(nuevoPersonaje);

//            for (Personatge i : personajes) {
//                System.out.println("nombre: " + i.getNombre() + " tipo: " + i.getTipo());
//            }

            System.out.println("Se ha creado un personaje de tipo " + tipo + " con " + nombre + " como nombre.");
        }else { System.out.println("Ya hay un personaje con ese nombre."); }
    }

    private static int comprobarPersonaje(String nombre) {
        int nombreRepetido = 0;
        for (Personatge i : personajes) {
            if (i.getNombre().equalsIgnoreCase(nombre)) {
                nombreRepetido ++;
            }
        }
        return nombreRepetido;
    }
}