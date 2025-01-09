package main;
import classes.Personatge;
import classes.CharactersLibrary;
import java.util.ArrayList;
import java.util.Random;
import static java.lang.Thread.sleep;

public class Main {
    private static ArrayList<Personatge> personajes;
    private static ArrayList<Personatge> NPCs;
    private static ArrayList<Personatge> copias;

    public static void main(String[] args) {
        personajes = new ArrayList<>();
        NPCs = new ArrayList<>();
        copias = new ArrayList<>();
        boolean engine = true;
        createNPC();

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
                case 4: //eliminar personaje
                    eliminateCharacter();
                    break;
                case 5: //better Character
                    betterCharacter();
                    break;
                case 6:
                    play();
                    break;
                case 7: //salir
                    engine = false;
                    System.out.print("Gracias por haber utilizado nuestro juego");
                    try {
                        Thread.sleep(500);
                        System.out.print("!");
                        Thread.sleep(500);
                        System.out.print("!");
                        Thread.sleep(500);
                        System.out.print("!");
                    } catch (InterruptedException e) {
                        System.out.println("");
                    }
                    break;
            }
        }
    }
//Characters library ------ he pensado que solo deberiamos poner a los enemigos
    // he pensado que para las batallas deberiamos poner lineas rollo se ha hecho X daño al enemigo o el enemigo te ha hecho X daño, además
    // de que cuando se hace daño como he escrito arriba puede fallar a parte de que el daño que pone dependiendo de la resistencia
    // del enemigo no le quitara tanta vida
//                    System.out.println("\t\t\tDRAGON");     //enemy
//                    System.out.println(CharactersLibrary.dragon());
//                    System.out.println("\t DEAD OUTPUT");   //output para cuando muere el personaje
//                    System.out.println(CharactersLibrary.dead());
//                    System.out.println("\t\t\tDEMON");      //enemy
//                    System.out.println(CharactersLibrary.demon());
//                    System.out.println("\t\t  ELF");        //player character / enemy
//                    System.out.println(CharactersLibrary.elf());
//                    System.out.println("\t\tWARRIOR");      //player character  ---  **este no lo pondria**
//                    System.out.println(CharactersLibrary.warrior());
//                    System.out.println("\t\tENANO");        //player character / enemy
//                    System.out.println(CharactersLibrary.enano());
//                    System.out.println("\t\tWIZARD");       //player character / enemy
//                    System.out.println(CharactersLibrary.wizard());

    private static void createNPC() {
        NPCs.add(new Personatge("Enemigo", "NPC", 50*(NPCs.size()+1), 50*(NPCs.size()+1), 50*(NPCs.size()+1), 75*(NPCs.size()+1), 1*(NPCs.size()+1), 1000*(NPCs.size()+1), 0, 0, 0, 50*(NPCs.size()+1), 0));
    }

    private static void showNPC() {
        for (Personatge character : NPCs) {
            character.displayNPCAttributes();
        }
        System.out.println();
    }

    private static void ataquesJuego(int numAtaque) {
        Random critico = new Random();
        int numcrit = critico.nextInt(10);
        System.out.println(numcrit);
        switch (numAtaque) {
            case 1:
                if (numcrit < 4) {
                    copias.get(1).ataqueFuerte_guerrero(copias.get(0));
                }
                else {
                    copias.get(1).ataque_guerrero(copias.get(0));
                }
                break;
            case 2:
                if (numcrit < 4) {
                    copias.get(1).ataqueFuerte_mago(copias.get(0));
                }
                else {
                    copias.get(1).ataque_mago(copias.get(0));
                }
                break;
            case 3:
                if (numcrit < 4) {
                    copias.get(1).ataqueFuerte_elfo(copias.get(0));
                }
                else {
                    copias.get(1).ataque_elfo(copias.get(0));
                }
        }
        copias.get(0).displayNPCAttributes();
    }

    private static void play() {
        if (personajes.isEmpty()) {
            System.out.println("No tienes ningún personaje creado.");
        }
        else {
            String characterName = AskData.askString("Dime el nombre del personaje con el que quieras jugar: ");
            if (checkCharacterExists(characterName)) {
                boolean playMenu = true;
                int opcionPlayMenu = 0;
                while (playMenu) {
                    System.out.println("\t\tMenú de Juego");
                    System.out.println("1. Misiones (aumenta solo un atributo del personaje)");
                    System.out.println("2. Batalla (aumenta todos los atributos del personaje y subes el nivel de experiencia en caso de ganar)");
                    System.out.println("3. Volver al menú de inicio");
                    opcionPlayMenu = AskData.askInt("Dime una opción: ", "Dime una opción correcta: ", 1, 3);
                    switch (opcionPlayMenu) {
                        case 1:
                            System.out.println("HAS ENTRADO EN EL CAMPO DE MISIONES");
                            int atributo = AskData.askInt("¿Que atributo desea augmentar? (1. fuerza, 2. agilidad, 3. resistencia): ", "¿Dime una opción correcta?", 1, 3);
                            Random numRandom = new Random();
                            int num1 = numRandom.nextInt(20);
                            int num2 = numRandom.nextInt(10);
                            int num3 = numRandom.nextInt(30);
                            switch (atributo) {
                                case 1:
                                    int respuesta1 = AskData.askInt("Resuelve esta operación: " + num3 + " * " + num2 + " * " + num1 + " : ");
                                    if (respuesta1 == num3 * num2 * num1) {
                                        System.out.println("Has acertado la operación correctamente, augmentas tu fuerza en 50 puntos!!\n");
                                        for (Personatge i : personajes) {
                                            if (i.getNombre().equalsIgnoreCase(characterName)) {
                                                i.setFuerza(i.getFuerza() + 50);
                                            }
                                        }
                                    }
                                    else {
                                        System.out.println("Incorrecto, intentalo en otra ocasión.\n");
                                    }
                                    break;
                                case 2:
                                    int respuesta2 = AskData.askInt("Resuelve esta operación: " + num1 + " + " + num3 + " * " + num2 + " : ");
                                    if (respuesta2 == num1 + num3 * num2) {
                                        System.out.println("Has acertado la operación correctamente, augmentas tu agilidad en 50 puntos!!\n");
                                        for (Personatge i : personajes) {
                                            if (i.getNombre().equalsIgnoreCase(characterName)) {
                                                i.setAgilidad(i.getAgilidad() + 50);
                                            }
                                        }
                                    }
                                    else {
                                        System.out.println("Incorrecto, intentalo en otra ocasión.\n");
                                    }
                                    break;
                                case 3:
                                    int respuesta3 = AskData.askInt("Resuelve esta operación: " + num1 + " * " + num2 + " * " + num3 + " - " + num1 + " : ");
                                    if (respuesta3 == num1 * num2 * num3 - num1) {
                                        System.out.println("Has acertado la operación correctamente, augmentas tu resistencia en 50 puntos!!\n");
                                        for (Personatge i : personajes) {
                                            if (i.getNombre().equalsIgnoreCase(characterName)) {
                                                i.setResistencia(i.getResistencia() + 50);
                                            }
                                        }
                                    }
                                    else {
                                        System.out.println("Incorrecto, intentalo en otra ocasión.\n");
                                    }
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("HAS ENTRADO EN EL CAMPO DE BATALLA");
                            int nivelJuego = AskData.askInt("¿A qué nivel quieres jugar? (tienes desbloqueados " + NPCs.size() + " niveles): ", "No tienes ese nivel desbloqueado (no existen los niveles negativos)", 1, NPCs.size());
                            NPCCharacterCopy(nivelJuego); //index 0
                            playerCharacterCopy(characterName); //index 1
                            nivelJuego--;
                            Random starter = new Random();
                            int start = starter.nextInt(20);
                            System.out.println("\t\tJUGANDO");
                            boolean juego = true;
                            CharactersLibrary displayCharacter = new CharactersLibrary();
                            String displayEnemy = displayCharacter.displayLibary();     //printea enemigo
                            String deadDisplay = displayCharacter.dead();   //crea variable de dead output
                            while (copias.get(0).isAlive() && copias.get(1).isAlive() && juego) {
                                if (start < 10) {
                                    if (copias.get(1).getTipo().equalsIgnoreCase("guerrero")) {
                                        int opcionAtacar = 10;
                                        while (opcionAtacar < 0 || opcionAtacar > 2) {
                                            System.out.println("Te toca atacar, opciones de ataque: \n0. Rendirse\n1. Espadazo sencillo\n2. Usar pocion de curación\n");
                                            opcionAtacar = AskData.askInt("Opcion: ", "Selecciona una opcion correcta.", 0, 2);
                                        }
                                        switch (opcionAtacar) {
                                            case 0:
                                                System.out.println("SALIENDO DE LA PARTIDA\n. . .");
                                                juego = false;
                                                break;
                                            case 1:
                                                ataquesJuego(1);
                                                break;
                                            case 2:
                                                copias.get(1).usarPocion();
                                                break;
                                        }
                                    }
                                    else if (copias.get(1).getTipo().equalsIgnoreCase("mago")) {
                                        int opcionAtacar = 10;
                                        while (opcionAtacar < 0 || opcionAtacar > 2) {
                                            System.out.println("Te toca atacar, opciones de ataque: \n0. Rendirse\n1. Hechizo sencillo\n2. Usar pocion de curación\n");
                                            opcionAtacar = AskData.askInt("Opcion: ", "Selecciona una opcion correcta.", 0, 2);
                                        }
                                        switch (opcionAtacar) {
                                            case 0:
                                                System.out.println("SALIENDO DE LA PARTIDA\n. . .");
                                                juego = false;
                                                break;
                                            case 1:
                                                ataquesJuego(2);
                                                break;
                                            case 2:
                                                copias.get(1).usarPocion();
                                                break;
                                        }

                                    }
                                    else if (copias.get(1).getTipo().equalsIgnoreCase("elfo")) {
                                        int opcionAtacar = 10;
                                        while (opcionAtacar < 0 || opcionAtacar > 2) {
                                            System.out.println("Te toca atacar, opciones de ataque: \n0. Rendirse\n1. Lanzar flecha\n2. Usar pocion de curación\n");
                                            opcionAtacar = AskData.askInt("Opcion: ", "Selecciona una opcion correcta.", 0, 2);
                                        }
                                        switch (opcionAtacar) {
                                            case 0:
                                                System.out.println("SALIENDO DE LA PARTIDA\n. . .");
                                                juego = false;
                                                break;
                                            case 1:
                                                ataquesJuego(3);
                                                break;
                                            case 2:
                                                copias.get(1).usarPocion();
                                                break;
                                        }
                                    }
                                    else {
                                        System.out.println("ERROR, REINICA EL JUEGO");
                                    }
                                    enemyAtack();
                                }
                                else {
                                    enemyAtack();
                                    if (copias.get(1).getTipo().equalsIgnoreCase("guerrero")) {
                                        int opcionAtacar = 10;
                                        while (opcionAtacar < 0 || opcionAtacar > 2) {
                                            System.out.println("Empieza atacando el enemigo, opciones de tu ataque: \n0. Rendirse\n1. Espadazo sencillo\n2. Usar pocion de curación\n");
                                            opcionAtacar = AskData.askInt("Opcion: ", "Selecciona una opcion correcta.", 0, 2);
                                        }
                                        switch (opcionAtacar) {
                                            case 0:
                                                System.out.println("SALIENDO DE LA PARTIDA\n. . .");
                                                juego = false;
                                                break;
                                            case 1:
                                                ataquesJuego(1);
                                                break;
                                            case 2:
                                                copias.get(1).usarPocion();
                                                break;
                                        }
                                    }
                                    else if (copias.get(1).getTipo().equalsIgnoreCase("mago")) {
                                        int opcionAtacar = 10;
                                        while (opcionAtacar < 0 || opcionAtacar > 2) {
                                            System.out.println("Empieza atacando el enemigo, opciones de tu ataque: \n0. Rendirse\n1. Hechizo sencillo\n2. Usar pocion de curación\n");
                                            opcionAtacar = AskData.askInt("Opcion: ", "Selecciona una opcion correcta.", 0, 2);
                                        }
                                        switch (opcionAtacar) {
                                            case 0:
                                                System.out.println("SALIENDO DE LA PARTIDA\n. . .");
                                                juego = false;
                                                break;
                                            case 1:
                                                ataquesJuego(2);
                                                break;
                                            case 2:
                                                copias.get(1).usarPocion();
                                                break;
                                        }

                                    }
                                    else if (copias.get(1).getTipo().equalsIgnoreCase("elfo")) {
                                        int opcionAtacar = 10;
                                        while (opcionAtacar < 0 || opcionAtacar > 2) {
                                            System.out.println("Empieza atacando el enemigo, opciones de tu ataque: \n0. Rendirse\n1. Lanzar flecha\n2. Usar pocion de curación\n");
                                            opcionAtacar = AskData.askInt("Opcion: ", "Selecciona una opcion correcta.", 0, 2);
                                        }
                                        switch (opcionAtacar) {
                                            case 0:
                                                System.out.println("SALIENDO DE LA PARTIDA\n. . .");
                                                juego = false;
                                                break;
                                            case 1:
                                                ataquesJuego(3);
                                                break;
                                            case 2:
                                                copias.get(1).usarPocion();
                                                break;
                                        }
                                    }
                                }
                            }
                            if (!copias.get(1).isAlive()) {
                                System.out.println("**HAS SIDO DERROTADO**");
                                System.out.println(deadDisplay);    //muestra dead output
                            }
                            else if (!copias.get(0).isAlive()){
                                if (copias.get(0).getNivel() == NPCs.size() || copias.get(1).getNivel() < copias.get(0).getNivel()) {
                                    System.out.println("**HAS DERROTADO AL ENEMIGO**\n");
                                    if (copias.get(0).getNivel() == NPCs.size()) {
                                        createNPC();
                                        System.out.println("Has desbloqueado el nivel " + NPCs.size() + "\n");
                                    }
                                    if (copias.get(1).getTipo().equalsIgnoreCase("guerrero")) {
                                        ImproveCharacterStats(characterName, 1);
                                    }
                                    else if (copias.get(1).getTipo().equalsIgnoreCase("mago")) {
                                        ImproveCharacterStats(characterName, 2);
                                    }
                                    else if (copias.get(1).getTipo().equalsIgnoreCase("elfo")) {
                                        ImproveCharacterStats(characterName, 3);
                                    }
                                }
                                else {
                                    System.out.println("**HAS DERROTADO AL ENEMIGO**\n");
                                    ImproveCharacterStats(characterName, 4);
                                }

                            }
                            copias.remove(0);
                            copias.remove(0);
                            break;
                        case 3:
                            playMenu = false;
                            break;
                    }
                }
            }
            else {
                System.out.println("No existe un personaje con este nombre.");
            }
        }
    }

    private static void ImproveCharacterStats(String characterName, int num) {
        for (Personatge i : personajes) {
            if (i.getNombre().equalsIgnoreCase(characterName)) {
                switch (num) {
                    case 1:
                        i.improveWarriorStats();
                        System.out.println("Has aumentado tus estadisticas de guerrero: ");
                        i.displayAttributes();
                        break;
                    case 2:
                        i.improveMageStats();
                        System.out.println("Has aumentado tus estadisticas de mago: ");
                        i.displayAttributes();
                        break;
                    case 3:
                        i.improveElfStats();
                        System.out.println("Has aumentado tus estadisticas de elfo: ");
                        i.displayAttributes();
                        break;
                    case 4:
                        i.improveGlobalStats();
                        System.out.println("Has aumentado tus estadisticas generales, ya que este nivel ya lo tenias desbloqueado: ");
                        i.displayAttributes();
                        break;
                }
            }
        }
    }

    private static void enemyAtack() {
        System.out.println("El enemigo te lanza un ataque -->");
        copias.get(0).ataque_NPC(copias.get(1));
        System.out.println("\nEstadisticas restantes de " + copias.get(1).getNombre() + ":");
        copias.get(1).displayAttributes();
    }

    private static void NPCCharacterCopy(int nivelJuego) {
        Personatge copiaNPC = new Personatge();
        for (Personatge i : NPCs) {
            if (i.getNivel() == nivelJuego && i.getNombre().equalsIgnoreCase("enemigo")) {
                copyStats(i, copiaNPC);
                copias.add(copiaNPC);
            }
        }
    }

    private static void copyStats(Personatge i, Personatge copiaNPC) {
        copiaNPC.setNombre(i.getNombre());
        copiaNPC.setTipo(i.getTipo());
        copiaNPC.setFuerza(i.getFuerza());
        copiaNPC.setAgilidad(i.getAgilidad());
        copiaNPC.setResistencia(i.getResistencia());
        copiaNPC.setVida(i.getVida());
        copiaNPC.setNivel(i.getNivel());
        copiaNPC.setExperiencia(i.getExperiencia());
        copiaNPC.setAtaque_guerrero(i.getAtaque_guerrero());
        copiaNPC.setAtaque_elfo(i.getAtaque_elfo());
        copiaNPC.setAtaque_mago(i.getAtaque_mago());
        copiaNPC.setAtaque_NPC(i.getAtaque_NPC());
        copiaNPC.setPotions(i.getPotions());
    }

    private static void playerCharacterCopy(String characterName) {
        Personatge copiaJugador = new Personatge();
        for (Personatge i : personajes) {
            if (i.getNombre().equalsIgnoreCase(characterName)) {
                copyStats(i, copiaJugador);
                copias.add(copiaJugador);
            }
        }
    }

    private static void betterCharacter() {
        if (personajes.isEmpty()) {System.out.println("No tienes ningun personaje.\n");}
        else {
            System.out.println("*PERSONAJE CON MAYOR NIVEL*");
            displayBetterCharacter(6);
            int opcionRanking = 0;
            do {
                System.out.println("\n\t\tMAS OPCIONES");
                System.out.println("1.Mayor fuerza.\n2.Mayor agilidad." +
                        "\n3.Mayor resistencia.\n4.Mas vida." +
                        "\n5.Mayor cantidad de experiencia.\n6.Mayor nivel.\n7.Salir");
                opcionRanking = AskData.askInt("Dime una opción: ", "Dime una opción correcta: ", 1, 7);
                System.out.println();
                switch (opcionRanking) {
                    case 1:
                        System.out.println("Mayor Fuerza:");
                        displayBetterCharacter(1);
                        break;
                    case 2:
                        System.out.println("Mayor agilidad:");
                        displayBetterCharacter(2);
                        break;
                    case 3:
                        System.out.println("Mayor resistencia:");
                        displayBetterCharacter(3);
                        break;
                    case 4:
                        System.out.println("Mas vida:");
                        displayBetterCharacter(4);
                        break;
                    case 5:
                        System.out.println("Mayor cantidad de experiencia:");
                        displayBetterCharacter(5);
                        break;
                    case 6:
                        System.out.println("Mayor nivel:");
                        displayBetterCharacter(6);
                        break;
                }
            }while (opcionRanking != 7);
        }
    }

    private static void rankingOrder() {
        if (personajes.isEmpty()) {System.out.println("No tienes ningun personaje.\n");}
        else {
            System.out.println("*ORDENADO POR NIVEL*");
            displayRankingOrderedBy(6);
            int opcionRanking = 0;
            do {
                System.out.println("\n\t\tOPCIONES DE RANKING");
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

    private static void displayBetterCharacter(int attribute) {
        sortRankingBy(attribute);
        displayBetterCharacterStats();
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
                        value1 = personajes.get(j).getExperiencia();
                        value2 = personajes.get(j + 1).getExperiencia();
                        break;
                    case 6:
                        value1 = personajes.get(j).getNivel();
                        value2 = personajes.get(j + 1).getNivel();
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
        if (personajes.size() > 0) {
            String characterName = AskData.askString("Dime el nombre del personaje que quieres modificar: ");
            if (checkCharacterExists(characterName)) {
                System.out.println("\n");
                System.out.println("\t\tMODIFICAR PERSONAJE");
                int opcionMod;
                System.out.println("1. Modificar nombre\n2. Modificar tipo\n3. Salir");
                opcionMod = AskData.askInt("Dime una opción: ", "Dime una opción correcta: ", 1, 3);
                switch (opcionMod) {
                    case 1:
                        System.out.println("\n");
                        System.out.println("\t\tMODIFICAR NOMBRE");
                        String nombreNuevo = AskData.askString("Dime el nombre nuevo de tu personaje: ");
                        buscarPersonaje(characterName).setNombre(nombreNuevo);
                        break;
                    case 2:
                        System.out.println("\n");
                        System.out.println("\t\tMODIFICAR TIPO");
                        String tipoMostrar = buscarPersonaje(characterName).getTipo();
                        String tipoNuevo = "";
                        while (!tipoNuevo.equals("guerrero") && !tipoNuevo.equals("mago") && !tipoNuevo.equals("elfo") && !tipoNuevo.equals("enano")){
                            tipoNuevo = AskData.askString("Dime el tipo nuevo que quieres para tu personaje (actual : " + tipoMostrar + "):");
                            tipoNuevo = tipoNuevo.toLowerCase();
                            if (!tipoNuevo.equals("guerrero") && !tipoNuevo.equals("mago") && !tipoNuevo.equals("elfo") && !tipoNuevo.equals("enano")){
                                System.out.println("No existe ese tipo.");
                            }
                        }
                        buscarPersonaje(characterName).setTipo(tipoNuevo);
                        break;
                    case 3:
                        System.out.println("Has salido del menu de modificación.\n");
                        break;
                }
            }
            else {
                System.out.println("No existe un personaje con este nombre.\n");
            }
        }
        else {
            System.out.println("No tienes personajes.\n");
        }
    }

    private static void eliminateCharacter() {
        String name = AskData.askString("Dime el nombre del personaje que quieres eliminar: ");
        if (checkCharacterExists(name)) {
            personajes.remove(buscarPersonaje(name));
            System.out.println("Se ha eliminado el personaje de tu colección.\n");
        }else { System.out.println("\nNo existe ese personaje.\n"); }
    }

    private static Personatge buscarPersonaje(String name) {
        for (Personatge i : personajes) {
            if (i.getNombre().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return null;
    }

    private static void createCharacter() {
        String name = AskData.askString("Dime el nombre del personaje que quieres crear: ");
        if (!checkCharacterExists(name) && !name.equalsIgnoreCase("enemigo")) {
            String tipo = "";
            while (!tipo.equalsIgnoreCase("guerrero") &&
                    !tipo.equalsIgnoreCase("mago") &&
                    !tipo.equalsIgnoreCase("elfo")){
                tipo = AskData.askString("Dime que tipo de personaje es " + name + " (guerrero, mago, elfo): ");
                tipo = tipo.toLowerCase();
            }
            Personatge nuevoPersonaje = new Personatge(name, tipo);
            personajes.add(nuevoPersonaje);
            displayCharacterStats();
            System.out.println("\nSe ha creado un personaje de tipo " + tipo + " con " + name + " como nombre.\n");
        }else { System.out.println("\nYa hay un personaje con ese nombre.(No puedes crear un personaje con el nombre *enemigo*)\n"); }
    }

    private static void displayCharacterStats() {
        for (Personatge character : personajes) {
            character.displayAttributes();
        }
    }

    private static void displayBetterCharacterStats() {
        int num = 0;
        for (Personatge character : personajes) {
            if (num == 0) {
                character.displayAttributes();
            }
            num ++;
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
}
