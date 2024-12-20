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


//        Personatge personajenuevo = new Personatge("Manuel", "elfo");
//        personajenuevo.setNivel(12);
//        personajes.add(personajenuevo);
//        Personatge personajenuevo1 = new Personatge("Manuel Mengana", "elfo");
//        personajenuevo1.setNivel(15);
//        personajes.add(personajenuevo1);
//        Personatge personajenuevo2 = new Personatge("Manuel Turizo", "elfo");
//        personajenuevo2.setNivel(20);
//        personajes.add(personajenuevo2);





        while (engine) {
            System.out.println("1. Crear personaje\n2. Modificar personaje\n3. Ranking\n4. Eliminar personatje\n5. Mejor personaje\n6. JUGAR\n7. SALIR");
            int opcion = ask.askInt("Dime una opción: ", "Dime una opción correcta: ", 1, 7);
            switch (opcion) {
                case 1: //crear
                    crearPersonajeMethod();
                    break;
                case 2: //modificar
                    modificarPersonaje();
                    break;
                case 3: //ranking
                    if (personajes.isEmpty()) {
                        System.out.println("No hay personajes creados.");
                    }
                    else {
                        // Ordenar manualmente por nivel de mayor a menor usando bubble sort
                        for (int i = 0; i < personajes.size() - 1; i++) {
                            for (int j = 0; j < personajes.size() - 1 - i; j++) {
                                if (personajes.get(j).getNivel() < personajes.get(j + 1).getNivel()) {
                                    // Intercambiar elementos
                                    Personatge temp = personajes.get(j);
                                    personajes.set(j, personajes.get(j + 1));
                                    personajes.set(j + 1, temp);
                                }
                            }
                        }

                        System.out.println("Ordenado por nivel (descendente):");
                        mostrarPersonajes();
                    }


            }

        }
    }






















    private static void modificarPersonaje() {
        String nombreMod = ask.askString("Dime el nombre del personaje que quieres modificar: ");
        int nombreRepetidoMod = comprobarPersonaje(nombreMod);
        if (nombreRepetidoMod == 1) {
            System.out.println("\n");
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
                        break;
                    case 2:
                        System.out.println("\n");
                        System.out.println("\t\tMODIFICAR TIPO");
                        String tipoMostrar = "";
                        for (Personatge i : personajes) {
                            if (i.getNombre().equalsIgnoreCase(nombreMod)) {
                                tipoMostrar = i.getTipo();
                            }
                        }
                        String tipoNuevo = "";
                        while (!tipoNuevo.equals("guerrero") && !tipoNuevo.equals("mago") && !tipoNuevo.equals("elfo") && !tipoNuevo.equals("enano")){
                            tipoNuevo = ask.askString("Dime el tipo nuevo que quieres para tu personaje (actual : " + tipoMostrar + "):");
                            tipoNuevo = tipoNuevo.toLowerCase();
                        }
                        for (Personatge i : personajes) {
                            if (i.getNombre().equalsIgnoreCase(nombreMod)) {
                                i.setTipo(tipoNuevo);
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Has salido del menu de modificación.\n");
                        break;
                }
            }while (opcionMod != 3);
        }
        else {
            System.out.println("No existe un personaje con este nombre.");
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

            mostrarPersonajes();

            System.out.println("\nSe ha creado un personaje de tipo " + tipo + " con " + nombre + " como nombre.\n");
        }else { System.out.println("\nYa hay un personaje con ese nombre.\n"); }
    }



    private static void mostrarPersonajes() {
        for (Personatge i : personajes) {
            System.out.println("\nNombre: " + i.getNombre() + " \nTipo: " + i.getTipo() + " \nFuerza: "
                    + i.getFuerza() + " \nAgilidad: " + i.getAgilidad() + " \nResistencia: "
                    + i.getResistencia() + " \nVida: " + i.getVida() + " \nNivel: " + i.getNivel()
                    + " \nExperiencia: " + i.getExperiencia() + "\n");
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