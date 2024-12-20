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
                case 1:  //crear
                    crearPersonajeMethod();
                    break;
                case 2: //modificar
                    modificarPersonaje();
                    break;
                case 3: //ranking
                    if (personajes.isEmpty()) {
                        System.out.println("No hay personajes creados");
                    }
                    else {
                        for ( int i = 0; i < personajes.size(); i++) {
                            for (int j = i + 1; j < personajes.size(); j++) {
                                if (personajes.get(i).getNivel() < personajes.get(j).getNivel()) {
                                    Personatge temp = personajes.get(j);
                                    personajes.set(j, personajes.get(i));
                                    personajes.set(i, temp);
                                    System.out.println(personajes);

                                }
                            }

                        }
                    }

            }

        }
    }

    private static void modificarPersonaje() {
        String nombreMod = ask.askString("Dime el nombre del personaje que quieres modificar: ");
        int nombrerepetidoMod = comprobarPersonaje(nombreMod);
        if (nombrerepetidoMod == 1) {
            System.out.println("\n");
            System.out.println("\t\t Modificar personaje");
            int opcionMod;
            do {
                System.out.println("1. Modificar nombre\n2. Modificar tipo\n3. Salir");
                opcionMod = ask.askInt("Dime una opción: ", "Dime una opción correcta: ", 1, 3);
                switch (opcionMod) {
                    case 1:
                        System.out.println("\n");
                        System.out.println("\t\t MODIFICAR NOMBRE");
                        String nombreNuevo = ask.askString("Dime el nombre nuevo de tu personaje: ");
                        for (Personatge i : personajes) {
                            if (i.getNombre().equals(nombreMod)) {
                                i.setNombre(nombreNuevo);

                            }
                        }
                        break;

                    case 2:
                        System.out.println("\n");
                        System.out.println("\t\t MODIFICAR TIPO");
                        String tipoMostrar = "";
                        for (Personatge i : personajes) {
                            if (i.getNombre().equalsIgnoreCase(nombreMod)) {
                                tipoMostrar = i.getTipo();
                            }
                        }
                        String tipoNuevo = "";
                        while (!tipoNuevo.equals("guerrero") &&!tipoNuevo.equals("mago") &&!tipoNuevo.equals("elfo") &&!tipoNuevo.equals("enano")){
                            tipoNuevo = ask.askString("Dime el tipo nuevo que quieres para tu personaje (actual: " + tipoMostrar + "): ");
                            tipoNuevo = tipoNuevo.toLowerCase();

                        }


                        for (Personatge i : personajes) {
                            if (i.getNombre().equals(nombreMod)) {
                                i.setTipo(tipoNuevo);

                            }
                        }
                        break;

                    case 3:
                        System.out.println("Has salido del menú de modificación. \n");
                        break;

                }

            }while (opcionMod!= 3);

        }
        else{
            System.out.println("No existe un personaje con ese nombre.");
        }

    }


    private static void crearPersonajeMethod() {
        String nombre = ask.askString("Dime el nombre del personaje que quieres crear: ");
        int nombreRepetido = comprobarPersonaje(nombre);
        if (nombreRepetido == 0) {
            String tipo = "";
            while (!tipo.equals("guerrero") && !tipo.equals("mago") && !tipo.equals("elfo") && !tipo.equals("enano")){
                tipo = ask.askString("Dime que tipo de personaje es " + nombre + " (guerrero, mago, elfo, enano): ");
                tipo = tipo.toLowerCase();
            }

            Personatge nuevoPersonaje = new Personatge(nombre, tipo);
            personajes.add(nuevoPersonaje);

            mostrarPersonajes();

            System.out.println("\nSe ha creado un personaje de tipo " + tipo + " con " + nombre + " como nombre.\n");
        }else { System.out.println("\nYa hay un personaje con ese nombre.\n"); }

    }

    private static void mostrarPersonajes() {
        for (Personatge i : personajes) {
            System.out.println("\nNombre: " + i.getNombre() + " \nTipo: " + i.getTipo() +
                    " \nFuerza: " + i.getFuerza() + " \nAgilidad: " + i.getAgilidad() +
                    " \nResistencia: " + i.getResistencia() + " \nVida: " + i.getVida() +
                    " \nNivel: " + i.getNivel() + " \nExperiencia: " + i.getExperiencia() + "\n");
        }
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