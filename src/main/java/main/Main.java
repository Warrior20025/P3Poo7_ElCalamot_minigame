package main;
import classes.CharactersLibrary;
import classes.Personatge;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static ArrayList<Personatge> personajes;

    public static void main(String[] args) {
        personajes = new ArrayList<>();
        boolean engine = true;
        // cuando para las batallas el daño será la fuerza x 0.75 + agilidad x 0.25. Defensa será la resistencia que se restara al ataque del oponente.
        //en el combate se puede hacer un numero random en cada ataque y si cae en algun parametro que le pongamos acierta o falla el golpe,
        // dependiendo de la agilidad del oponente. por ejemplo un numero random y si es major al 50% de la agilidad del oponente le da sino falla.
        personajes.add(new Personatge("Eldelgas", "elfo", 100, 200, 120, 200, 0, 56));
        personajes.add(new Personatge("Zombier", "guerrero", 150, 100, 200, 200, 5, 567));
        personajes.add(new Personatge("Sathan", "mago", 10, 120, 100, 200, 1, 124));
        personajes.add(new Personatge("Gimli", "enano", 200, 50, 190, 200, 0, 20));

        while (engine) {
            System.out.println("1. Crear personaje\n2. Modificar personaje\n3. Ranking\n4. Eliminar personatje\n5. Mejor personaje\n6. JUGAR\n7. SALIR");
            int opcion = AskData.askInt("Dime una opción: ", "Dime una opción correcta: ", 1, 7);
            System.out.println();
            switch (opcion) {
                case 1: //crear
                    createCharacter();
                    break;
                case 2: //modificar
                    modificarPersonaje();
                    break;
                case 3: //ranking
                    rankingOrder();
                    break;
                case 4:  //eliminar personaje
                    eliminateCharacter();
                    break;
                case 5:  //mejor personaje
                    betterCharacter();
                    break;
                case 6:  //jugar
                    play();

                case 7:  //salir
                    engine = false;
                    System.out.println("Gracias por haber utilizado nuestro juego!!!");
                    break;
            }
        }




    }

    //Characters library ------ he pensado que solo deberiamos poner a los enemigos
    // porque sino mucho lio con esto para nada, ya que en verdad esto es trabajo de mas
    // he pensado que para las batallas deberiamos poner lineas rollo se ha hecho X daño al enemigo o el enemigo te ha hecho X daño, además
    // de que cuando se hace daño como he escrito arriba uede fallar a parte de que el daño que pone dependiendo de la resistencia
    // del enemigo no le quitara tanta vida
//    System.out.println("\t\t\tDRAGON");     //enemy
//    System.out.println(CharactersLibrary.dragon());
//    System.out.println("\t   DEAD OUTPUT");     //output para cuando se pierde y muere el personaje
//    System.out.println(CharactersLibrary.dead());
//    System.out.println("\t\t\tDEMON");      //enemy
//    System.out.println(CharactersLibrary.demon());
//    System.out.println("\t\t  ELF");        //player character
//    System.out.println(CharactersLibrary.elf());
//    System.out.println("\t\tWARRIOR");      //player character
//    System.out.println(CharactersLibrary.warrior());
//    System.out.println("\t\tENANO");        //player character
//    System.out.println(CharactersLibrary.enano());
//    System.out.println("\t\tWIZARD");       //player character
//    System.out.println(CharactersLibrary.wizard());

    private static void play() {
        if (personajes.isEmpty()) {
            System.out.println("No tienes ningún personaje creado.");
        }
        else {
            String characterName = AskData.askString("Dime el nombre del personaje con el que quieras jugar: ");
            if (checkCharacterExists(characterName)) {
                boolean playMenu = true;
                int opcionPlayMenu = 0 ;
                while (playMenu){
                    System.out.println("\t\t Menú de Juegos");
                    System.out.println("1. Misiones ( aumenta solo un atributo del personaje solo hay para aumentar de fuerza, agilidad o resistencia)");
                    System.out.println("2. Batalla (aumenta todos los atributos del personaje en caso de ganar también el nivel y experiencia)");
                    System.out.println("3. Salir");
                    opcionPlayMenu = AskData.askInt("Dime una opción: ", "Dime una opción correcta: ", 1, 3);
                    switch (opcionPlayMenu) {
                        case 1 :
                            int atributo = AskData.askInt("¿Qué atributo deseas aumentar? (1. Fuerza, 2. Agilidad, 3. Resistencia): ", "Dime una opcion correcta: " , 1,3);
                            Random numRandom = new Random();
                            int num1 = numRandom.nextInt(20);
                            int num2 = numRandom.nextInt(10);
                            int num3 = numRandom.nextInt(30);


                            switch (atributo) {
                                case 1:
                                    int respuesta1 = AskData.askInt("Resuelve esta operación: " + num3 + " * " + num2 + " * " + num1 + " : ");
                                    if (respuesta1 == num3 * num2 * num1) {
                                        System.out.println("Has acertado la operación correctamente. Aumentas tu fuerza en 5 puntos!!\n ");
                                        for (Personatge i : personajes) {
                                            if (i.getNombre().equalsIgnoreCase(characterName)) {
                                                i.setFuerza(i.getFuerza() + 5);
                                            }
                                        }

                                    }
                                    else {
                                        System.out.println("Incorrecto. Inténtalo en otra ocasión.\n");
                                    }
                                    break;

                                case 2:
                                    int respuesta2 = AskData.askInt("Resuelve esta operación: " + num1 + " + " + num3 + " * " + num2 + " : ");
                                    if (respuesta2 == num1 + num3 * num2) {
                                        System.out.println("Has acertado la operación correctamente. Aumentas tu agilidad en 5 puntos!!\n");
                                        for (Personatge i : personajes) {
                                            if (i.getNombre().equalsIgnoreCase(characterName)) {
                                                i.setAgilidad(i.getAgilidad() + 5);
                                            }
                                        }

                                    }
                                    else {
                                        System.out.println("Incorrecto. Inténtalo en otra ocasión.\n");

                                    }
                                    break;

                                case 3:
                                    int respuesta3 = AskData.askInt("Resuelve esta operación: " + num1 + " * " + num2 + " * " + num3 + " - " + num1 + " : ");
                                    if (respuesta3 == num1 * num2 * num3 - num1) {
                                        System.out.println("Has acertado la operación correctamente. Aumentas tu resistencia en 5 puntos!!\n ");
                                        for (Personatge i : personajes) {
                                            if (i.getNombre().equalsIgnoreCase(characterName)) {
                                                i.setResistencia(i.getResistencia() + 5);
                                            }
                                        }

                                    }
                                    else {
                                        System.out.println("Incorrecto. Inténtalo en otra ocasión.\n");
                                    }
                                    break;
                            }

                            break;

                        case 2 :
                            break;

                        case 3 :
                            playMenu = false;
                            break;
                    }



                }


            }
            else {
                System.out.println("No existe un personaje con ese nombre.");
            }


        }


    }
    private static void betterCharacter() {
        if (personajes.isEmpty()) {
            System.out.println("No tienes ningun personaje.");
        }
        else {
            System.out.println("*ORDENADO POR NIVEL*");
            displayBetterCharacter(6);
            int opcionRanking = 0;
            do {
                System.out.println("\n\t\tMAS OPCIONES");
                System.out.println("1.Ordenar por fuerza.\n2.Ordenar por agilidad." +
                        "\n3.Ordenar por resistencia.\n4.Ordenar por vida." +
                        "\n5.Ordenar por experiencia.\n6.Ordenar por nivel.\n7.Salir");
                opcionRanking = AskData.askInt("Dime una opción: ", "Dime una opción correcta: ", 1, 7);
                System.out.println();
                switch (opcionRanking) {
                    case 1:
                        System.out.println("Ordenado por Fuerza:");
                        displayBetterCharacter(1);
                        break;
                    case 2:
                        System.out.println("Ordenado por agilidad:");
                        displayBetterCharacter(2);
                        break;
                    case 3:
                        System.out.println("Ordenado por resistencia:");
                        displayBetterCharacter(3);
                        break;
                    case 4:
                        System.out.println("Ordenado por vida:");
                        displayBetterCharacter(4);
                        break;
                    case 5:
                        System.out.println("Ordenado por experiencia:");
                        displayBetterCharacter(5);
                        break;
                    case 6:
                        System.out.println("Ordenado por nivel:");
                        displayBetterCharacter(6);
                        break;
                }
            } while (opcionRanking != 7);

        }
    }

    private static void rankingOrder() {
        if (personajes.isEmpty()) {
            System.out.println("No  tienes ningun personaje.");
        }
        else {
            System.out.println("*ORDENADO POR NIVEL*");
            displayRankingOrderedBy(6);
            int opcionRanking = 0;
            do {
                System.out.println("\n\t\tMAS OPCIONES");
                System.out.println("1.Ordenar por fuerza.\n2.Ordenar por agilidad." +
                        "\n3.Ordenar por resistencia.\n4.Ordenar por vida." +
                        "\n5.Ordenar por experiencia.\n6.Ordenar por nivel.\n7.Salir");
                opcionRanking = AskData.askInt("Dime una opción: ", "Dime una opción correcta: ", 1, 7);
                System.out.println();
                switch (opcionRanking) {
                    case 1:
                        System.out.println("Ordenado por Fuerza:");
                        displayRankingOrderedBy(1);
                        break;
                    case 2:
                        System.out.println("Ordenado por agilidad:");
                        displayRankingOrderedBy(2);
                        break;
                    case 3:
                        System.out.println("Ordenado por resistencia:");
                        displayRankingOrderedBy(3);
                        break;
                    case 4:
                        System.out.println("Ordenado por vida:");
                        displayRankingOrderedBy(4);
                        break;
                    case 5:
                        System.out.println("Ordenado por experiencia:");
                        displayRankingOrderedBy(5);
                        break;
                    case 6:
                        System.out.println("Ordenado por nivel:");
                        displayRankingOrderedBy(6);
                        break;
                }
            }while (opcionRanking != 7);
        }
    }

    private static void displayRankingOrderedBy(int attribute) {
        sortRankingBy(attribute);
        displayCharacterStats();
        System.out.println();
    }

    private static void sortRankingBy(int attribute) {
        for (int i = 0; i < personajes.size() - 1; i++) {
            for (int j = 0; j < personajes.size() - 1 - i; j++) {
                int value1 = 0;
                int value2 = 0;
                switch (attribute) {
                    case 1:
                        value1 = personajes.get(j).getFuerza();
                        value2 = personajes.get(j + 1).getFuerza();
                        break;
                    case 2:
                        value1 = personajes.get(j).getAgilidad();
                        value2 = personajes.get(j + 1).getAgilidad();
                        break;
                    case 3:
                        value1 = personajes.get(j).getResistencia();
                        value2 = personajes.get(j + 1).getResistencia();
                        break;
                    case 4:
                        value1 = personajes.get(j).getVida();
                        value2 = personajes.get(j + 1).getVida();
                        break;
                    case 5:
                        value1 = personajes.get(j).getNivel();
                        value2 = personajes.get(j + 1).getNivel();
                        break;
                    case 6:
                        value1 = personajes.get(j).getNivel();
                        value2 = personajes.get(j + 1).getNivel();
                        break;
                    default:
                        value1 = personajes.get(j).getExperiencia();
                        value2 = personajes.get(j + 1).getExperiencia();
                        break;
                }
                if (value1 < value2) {      // Metodo comparativo de atributos
                    Personatge temp = personajes.get(j);
                    personajes.set(j, personajes.get(j + 1));
                    personajes.set(j + 1, temp);
                }
            }
        }
    }

    private static void modificarPersonaje() {
        String characterName = AskData.askString("Dime el nombre del personaje que quieres modificar: ");
        if (checkCharacterExists(characterName)) {
            System.out.println("\n");
            System.out.println("\t\tMODIFICAR PERSONAJE");
            int opcionMod;
            do {
                System.out.println("1. Modificar nombre\n2. Modificar tipo\n3. Salir");
                opcionMod = AskData.askInt("Dime una opción: ", "Dime una opción correcta: ", 1, 3);
                switch (opcionMod) {
                    case 1:
                        System.out.println("\n");
                        System.out.println("\t\tMODIFICAR NOMBRE");
                        String nombreNuevo = AskData.askString("Dime el nombre nuevo de tu personaje: ");
                        for (Personatge i : personajes) {
                            if (i.getNombre().equalsIgnoreCase(characterName)) {
                                i.setNombre(nombreNuevo);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("\n");
                        System.out.println("\t\tMODIFICAR TIPO");
                        String tipoMostrar = "";
                        for (Personatge i : personajes) {
                            if (i.getNombre().equalsIgnoreCase(characterName)) {
                                tipoMostrar = i.getTipo();
                            }
                        }
                        String tipoNuevo = "";
                        while (!tipoNuevo.equals("guerrero") && !tipoNuevo.equals("mago") && !tipoNuevo.equals("elfo") && !tipoNuevo.equals("enano")){
                            tipoNuevo = AskData.askString("Dime el tipo nuevo que quieres para tu personaje (actual : " + tipoMostrar + "):");
                            tipoNuevo = tipoNuevo.toLowerCase();
                        }
                        for (Personatge i : personajes) {
                            if (i.getNombre().equalsIgnoreCase(characterName)) {
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

    private static void eliminateCharacter() {
        String name = AskData.askString("Dime el nombre del personaje que quieres crear: ");
        if (checkCharacterExists(name)) {
            personajes.remove(name);
            System.out.println("Se ha eliminado el personaje de tu coleccion \n ");

        }
        else {
            System.out.println("\nNo existe ese personaje.\n");
        }
    }

    private static void createCharacter() {
        String name = AskData.askString("Dime el nombre del personaje que quieres crear: ");
        if (!checkCharacterExists(name)) {
            String tipo = "";
            while (!tipo.equalsIgnoreCase("guerrero") &&
                    !tipo.equalsIgnoreCase("mago") &&
                    !tipo.equalsIgnoreCase("elfo") &&
                    !tipo.equalsIgnoreCase("enano")){
                tipo = AskData.askString("Dime que tipo de personaje es " + name + " (guerrero, mago, elfo, enano): ");
                tipo = tipo.toLowerCase();
            }
            Personatge nuevoPersonaje = new Personatge(name, tipo);
            personajes.add(nuevoPersonaje);
            displayCharacterStats();
            System.out.println("\nSe ha creado un personaje de tipo " + tipo + " con " + name + " como nombre.\n");
        }else { System.out.println("\nYa hay un personaje con ese nombre.\n"); }
    }

    private static void displayCharacterStats() {
        for (Personatge character : personajes) {
            character.displayAttributes();
        }
    }

    private static boolean checkCharacterExists(String nombre) {
        for (Personatge i : personajes) {
            if (i.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    private static void displayBetterCharacterStats() {
        int num = 0;

        for (Personatge character : personajes) {
            if (num ==0 ) {
                character.displayAttributes();
            }
            num++;

        }
    }

    private static void displayBetterCharacter(int attribute) {
        sortRankingBy(attribute);
        displayBetterCharacterStats();
        System.out.println();
    }

}

