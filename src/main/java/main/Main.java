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
            System.out.println("\t\tMENÚ\n1. Crear personaje\n2. Modificar personaje\n3. Ranking\n4. Eliminar personatje\n5. Mejor personaje\n6. JUGAR\n7. SALIR");
            int opcion = AskData.askInt("Dime una opción: ", "Dime una opción correcta: ", 1, 7);
            System.out.println();
            switch (opcion) {
                case 1: //create character
                    createCharacter();
                    break;
                case 2: //modify character
                    modifyCharacter();
                    break;
                case 3: //ranking
                    rankingOrder();
                    break;
                case 4: //eliminate character
                    eliminateCharacter();
                    break;
                case 5: //better Character
                    betterCharacter();
                    break;
                case 6: //Game
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

    private static void createNPC() {   //funcion de crear NPC
        NPCs.add(new Personatge("Enemigo", "NPC", 50*(NPCs.size()+1), 50*(NPCs.size()+1), 50*(NPCs.size()+1), 75*(NPCs.size()+1), 1*(NPCs.size()+1), 1000*(NPCs.size()+1), 0, 0, 0, 50*(NPCs.size()+1), 0));
    }

    private static void showNPC() {     //display stats NPC
        for (Personatge character : NPCs) {
            character.displayNPCAttributes();
        }
        System.out.println();
    }

    private static void gameAtacks(int numAtaque) {   //funcion de ataques para diferenciar ataque normal del crítico con un random  y dependiendo del tipo de jugador
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

    private static void play() {        //juego
        if (personajes.isEmpty()) {
            System.out.println("No tienes ningún personaje creado.\n");
        }
        else {
            String characterName = AskData.askString("Dime el nombre del personaje con el que quieras jugar: ");    //pedimos personaje con el que jugar
            if (checkCharacterExists(characterName)) {
                boolean playMenu = true;
                int opcionPlayMenu = 0;
                while (playMenu) {      //menú de juego
                    System.out.println("\t\tMenú de Juego");
                    System.out.println("1. Misiones (aumenta solo un atributo del personaje)");
                    System.out.println("2. Batalla (aumenta todos los atributos del personaje y subes el nivel de experiencia en caso de ganar)");
                    System.out.println("3. Volver al menú de inicio");
                    opcionPlayMenu = AskData.askInt("Dime una opción: ", "Dime una opción correcta: ", 1, 3);
                    switch (opcionPlayMenu) {
                        case 1:     //caso de misiones
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
                        case 2:     //caso de batallas
                            System.out.println("HAS ENTRADO EN EL CAMPO DE BATALLA");
                            int nivelJuego = AskData.askInt("¿A qué nivel quieres jugar? (tienes desbloqueados " + NPCs.size() + " niveles): ", "No tienes ese nivel desbloqueado (no existen los niveles negativos)", 1, NPCs.size());
                            NPCCharacterCopy(nivelJuego); //copia de NPC en el index 0
                            playerCharacterCopy(characterName); //copia de jugador en el index 1
                            Random starter = new Random();
                            int start = starter.nextInt(20);    //usamos el random para decidir quien empieza atacando en la batalla
                            System.out.println("\t\tJUGANDO");
                            boolean juego = true;
                            CharactersLibrary displayCharacter = new CharactersLibrary();
                            String displayEnemy = displayCharacter.displayLibary();     //printea enemigo
                            String deadDisplay = displayCharacter.dead();   //crea variable de dead output
                            while (copias.get(0).isAlive() && copias.get(1).isAlive() && juego) {
                                if (start < 10) {       //empieza atacando el jugador con casos dependiendo del tipo
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
                                                gameAtacks(1);
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
                                                gameAtacks(2);
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
                                                gameAtacks(3);
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
                                else {      //empieza atacando el NPC y el jugador tiene casos dependiendo del tipo
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
                                                gameAtacks(1);
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
                                                gameAtacks(2);
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
                                                gameAtacks(3);
                                                break;
                                            case 2:
                                                copias.get(1).usarPocion();
                                                break;
                                        }
                                    }
                                }
                            }
                            if (!copias.get(1).isAlive()) {     //display de cuando muere el jugador
                                System.out.println("**HAS SIDO DERROTADO**");
                                System.out.println(deadDisplay);    //muestra dead output
                            }
                            else if (!copias.get(0).isAlive()){     //display de cuando se derrota al NPC
                                if (copias.get(0).getNivel() == NPCs.size() || copias.get(1).getNivel() <= copias.get(0).getNivel()) {
                                    System.out.println("**HAS DERROTADO AL ENEMIGO**\n");
                                    if (copias.get(0).getNivel() == NPCs.size()) {
                                        createNPC();
                                        System.out.println("Has desbloqueado el nivel " + NPCs.size() + "\n");
                                    }
                                    if (copias.get(1).getTipo().equalsIgnoreCase("guerrero")) {     //ifs de subir nivel dependiendo del tipo
                                        ImproveCharacterStats(characterName, 1);
                                    }
                                    else if (copias.get(1).getTipo().equalsIgnoreCase("mago")) {
                                        ImproveCharacterStats(characterName, 2);
                                    }
                                    else if (copias.get(1).getTipo().equalsIgnoreCase("elfo")) {
                                        ImproveCharacterStats(characterName, 3);
                                    }
                                }
                                else {      //para cuando ya habias desbloqueado el nivel
                                    System.out.println("**HAS DERROTADO AL ENEMIGO**\n");
                                    ImproveCharacterStats(characterName, 4);
                                }

                            }
                            copias.remove(0);
                            copias.remove(0);
                            break;
                        case 3:     //salir del menu de juego
                            playMenu = false;
                            break;
                    }
                }
            }
            else {
                System.out.println("No existe un personaje con este nombre.\n");
            }
        }
    }

    private static void ImproveCharacterStats(String characterName, int num) {      //funcion que muestra que se han augmentado las caractgeristicas de un jugador dependiendo del tipo o si ya tenia el nivel pasado
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

    private static void enemyAtack() {      //display del ataque de un enemigo
        System.out.println("El enemigo te lanza un ataque -->");
        copias.get(0).ataque_NPC(copias.get(1));
        System.out.println("\nEstadisticas restantes de " + copias.get(1).getNombre() + ":");
        copias.get(1).displayAttributes();
    }

    private static void NPCCharacterCopy(int nivelJuego) {      //esta funcion hace una copia del NPC con el nivel que pasemos
        Personatge copiaNPC = new Personatge();
        for (Personatge i : NPCs) {
            if (i.getNivel() == nivelJuego && i.getNombre().equalsIgnoreCase("enemigo")) {
                copyStats(i, copiaNPC);
                copias.add(copiaNPC);
            }
        }
    }

    private static void copyStats(Personatge i, Personatge copia) {      //copiar estadisticas de personatge
        copia.setNombre(i.getNombre());
        copia.setTipo(i.getTipo());
        copia.setFuerza(i.getFuerza());
        copia.setAgilidad(i.getAgilidad());
        copia.setResistencia(i.getResistencia());
        copia.setVida(i.getVida());
        copia.setNivel(i.getNivel());
        copia.setExperiencia(i.getExperiencia());
        copia.setAtaque_guerrero(i.getAtaque_guerrero());
        copia.setAtaque_elfo(i.getAtaque_elfo());
        copia.setAtaque_mago(i.getAtaque_mago());
        copia.setAtaque_NPC(i.getAtaque_NPC());
        copia.setPotions(i.getPotions());
    }

    private static void playerCharacterCopy(String characterName) {     //esta funcion hace una copia del jugador con el nombre que pasemos
        Personatge copiaJugador = new Personatge();
        copyStats(searchCharacter(characterName), copiaJugador);
        copias.add(copiaJugador);
    }

    private static void betterCharacter() {     //menu donde se muestra el mejor jugador basandose en el atributo preguntando el que quiere filtrar y teniendo uno por default
        if (personajes.isEmpty()) {System.out.println("No tienes ningun personaje.\n");}
        else {
            System.out.println("*PERSONAJE CON MAYOR NIVEL*");      //default
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

    private static void rankingOrder() {    //funcion para hacer servir el ranking preguntando el atributo para filtrar y poniendo uno por default, además de respuestas de error
        if (personajes.isEmpty()) {System.out.println("No tienes ningun personaje.\n");}
        else {
            System.out.println("*ORDENADO POR NIVEL*");     //orden por default
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

    private static void displayRankingOrderedBy(int attribute) {    //funcion para mostrar el ranking completo ordenado
        sortRankingBy(attribute);
        displayCharacterStats();
        System.out.println();
    }

    private static void displayBetterCharacter(int attribute) {     //funcion para mostrar el mejor personaje, primero ordena la lista con el atributo que toca y despues muestra solo el mejor de ese tipo
        sortRankingBy(attribute);
        displayBetterCharacterStats();
        System.out.println();
    }

    private static void sortRankingBy(int attribute) {      //ordenar la lista de personajes dependiendo del atributo
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

    private static void modifyCharacter() {      //modificar un personaje con opciones del tipo o el nombre para escoger
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
                        searchCharacter(characterName).setNombre(nombreNuevo);
                        break;
                    case 2:
                        System.out.println("\n");
                        System.out.println("\t\tMODIFICAR TIPO");
                        String tipoMostrar = searchCharacter(characterName).getTipo();
                        String tipoNuevo = "";
                        while (!tipoNuevo.equals("guerrero") && !tipoNuevo.equals("mago") && !tipoNuevo.equals("elfo") && !tipoNuevo.equals("enano")){
                            tipoNuevo = AskData.askString("Dime el tipo nuevo que quieres para tu personaje (actual : " + tipoMostrar + "):");
                            tipoNuevo = tipoNuevo.toLowerCase();
                            if (!tipoNuevo.equals("guerrero") && !tipoNuevo.equals("mago") && !tipoNuevo.equals("elfo") && !tipoNuevo.equals("enano")){
                                System.out.println("No existe ese tipo.");
                            }
                        }
                        searchCharacter(characterName).setTipo(tipoNuevo);
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

    private static void eliminateCharacter() {      //eliminar el personaje que queramos
        if (personajes.size() > 0) {
            String name = AskData.askString("Dime el nombre del personaje que quieres eliminar: ");
            if (checkCharacterExists(name)) {
                personajes.remove(searchCharacter(name));
                System.out.println("Se ha eliminado el personaje de tu colección.\n");
            } else {
                System.out.println("\nNo existe ese personaje.\n");
            }
        }
        else {
            System.out.println("No tienes personajes.\n");
        }
    }

    private static Personatge searchCharacter(String name) {    //buscar el personaje que queramos y devolver el objeto
        for (Personatge i : personajes) {
            if (i.getNombre().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return null;
    }

    private static void createCharacter() {     //funcion para crear un personaje nuevo
        String name = AskData.askString("Dime el nombre del personaje que quieres crear: ");
        if (!checkCharacterExists(name) && !name.equalsIgnoreCase("enemigo")) {     //condicion que mediante una funcion comprueva que no exista el personaje y que no se llame igual que los NPCs
            String tipo = "";
            while (!tipo.equalsIgnoreCase("guerrero") &&
                    !tipo.equalsIgnoreCase("mago") &&
                    !tipo.equalsIgnoreCase("elfo")){        //condicion para que introduzca el usuario una clase correcta
                tipo = AskData.askString("Dime que tipo de personaje es " + name + " (guerrero, mago, elfo): ");
                tipo = tipo.toLowerCase();  //lo pasamos a lower case para guardarlo igual
            }
            Personatge nuevoPersonaje = new Personatge(name, tipo);     //creamos y añadimos el personaje
            personajes.add(nuevoPersonaje);
            displayCharacterStats();
            System.out.println("\nSe ha creado un personaje de tipo " + tipo + " con " + name + " como nombre.\n");
        }else { System.out.println("\nYa hay un personaje con ese nombre.(No puedes crear un personaje con el nombre *enemigo*)\n"); }
    }

    private static void displayCharacterStats() {   //mostrar estadisticas de personaje
        for (Personatge character : personajes) {
            character.displayAttributes();
        }
    }

    private static void displayBetterCharacterStats() {     //mostramos las estadustucas del primer personaje de la lista
        int num = 0;
        for (Personatge character : personajes) {
            if (num == 0) {
                character.displayAttributes();
            }
            num ++;
        }
    }

    private static boolean checkCharacterExists(String nombre) {    //comprovar que existe el personaje
        for (Personatge i : personajes) {
            if (i.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
}
