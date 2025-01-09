package classes;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;

public class CharactersLibrary {

    public static String displayLibary() {
        Random randomNumber = new Random();
        int random = randomNumber.nextInt(1, 5);
        switch (random) {
            case 1:
                System.out.println(dragon());
                break;
            case 2:
                System.out.println(evilElf());
                break;
            case 3:
                System.out.println(demon());
                break;
            case 4:
                System.out.println(evilWizard());
                break;
        }
        return null;
    }

    public static String dragon() {
        String dragonCharacter = "";
        dragonCharacter = dragonCharacter.concat("                   _______________");
        dragonCharacter = dragonCharacter.concat("\n              ,===:'.,            `-._");
        dragonCharacter = dragonCharacter.concat("\n                   `:.`---.__         `-._");
        dragonCharacter = dragonCharacter.concat("\n                     `:.     `--.         `.");
        dragonCharacter = dragonCharacter.concat("\n                       \\.        `.         `.");
        dragonCharacter = dragonCharacter.concat("\n               (,,(,    \\.         `.   ____,-`.,");
        dragonCharacter = dragonCharacter.concat("\n            (,'     `/   \\.   ,--.___`.'");
        dragonCharacter = dragonCharacter.concat("\n        ,  ,'  ,--.  `,   \\.;'         `");
        dragonCharacter = dragonCharacter.concat("\n         `{D, {    \\  :    \\;");
        dragonCharacter = dragonCharacter.concat("\n           V,,'    /  /    //");
        dragonCharacter = dragonCharacter.concat("\n           j;;    /  ,' ,-//.    ,---.      ,");
        dragonCharacter = dragonCharacter.concat("\n           \\;'   /  ,' /  _  \\  /  _  \\   ,/'");
        dragonCharacter = dragonCharacter.concat("\n                 \\   `'  / \\  `'  / \\  `.' /");
        dragonCharacter = dragonCharacter.concat("\n                  `.___,'   `.__,'   `.__,'" + "\n");
        return dragonCharacter;
    }
    public static String dead() {
        String deadOutput = "";
        deadOutput = deadOutput.concat("       **DEAD**         ");
        deadOutput = deadOutput.concat("\n      ~~~~~~~~~~~");
        deadOutput = deadOutput.concat("\n    /             \\ ");
        deadOutput = deadOutput.concat("\n   | )           ( |");
        deadOutput = deadOutput.concat("\n   \\  /C\\     /C\\  /");
        deadOutput = deadOutput.concat("\n   /  ~~~     ~~~  \\");
        deadOutput = deadOutput.concat("\n   \\ ___  .^,  ___ /");
        deadOutput = deadOutput.concat("\n    `|  _______  |'");
        deadOutput = deadOutput.concat("\n     |  HHHHHHH  |");
        deadOutput = deadOutput.concat("\n     \\          /");
        deadOutput = deadOutput.concat("\n       ~~~~^~~~~" + "\n");
        return deadOutput;
    }
    public static String evilElf() {
        String elfCharacter = "";
        elfCharacter = elfCharacter.concat("\n" +
                "       `_-@@@-_\n" +
                " |, _ -  -  -   ~-_--;\n" +
                "  |~ =  . _ .    =   |\n" +
                "  |  |   (       )  -\n" +
                "   -__\\   _    /,_--\n" +
                "        -_  _-~\n" +
                "        .-'--`-_\n" +
                "       ~/    .  |\n" +
                "        |     |~|\n" +
                "        |____(,,)\n" +
                "       /________\\\n" +
                "         |_|__|\n" +
                "       _~__~___\\\n" +
                "");
        return elfCharacter;
    }
    public static String demon() {
        String demonCharacter = "";
        demonCharacter = demonCharacter.concat("\n" +
                "                ,        ,\n" +
                "               /(        )`\n" +
                "               \\ \\___   / |\n" +
                "               /- _  `-/  '\n" +
                "              (/\\/ \\ \\   /\\\n" +
                "              / /   | `    \\\n" +
                "              O O   ) /    |\n" +
                "              `-^--'`<     '\n" +
                "             (_.)  _  )   /\n" +
                "              `.___/`    /\n" +
                "                `-----' /\n" +
                "   <----.     __ / __   \\\n" +
                "   <----|====O)))==) \\) /====\n" +
                "   <----'    `--' `.__,' \\\n" +
                "                |        |\n" +
                "                 \\       /\n" +
                "            ______( (_  / \\______\n" +
                "          ,'  ,-----'   |        \\\n" +
                "          `--{__________)        \\/   \n" +
                "\n");
        return demonCharacter;
    }

    public static String evilWizard() {
        String wizardCharacter = "";
        wizardCharacter = wizardCharacter.concat("\n" +
                "              _,._      \n" +
                "  .||,       /_ _\\\\     \n" +
                " \\.`',/      |'L'| |    \n" +
                " = ,. =      | -,| L    \n" +
                " / || \\    ,-'\\\"/,'`.   \n" +
                "   ||     ,'   `,,. `.  \n" +
                "   ,|____,' , ,;' \\| |  \n" +
                "  (3|\\    _/|/'   _| |  \n" +
                "   ||/,-''  | >-'' _,\\\\ \n" +
                "   ||'      ==\\ ,-'  ,' \n" +
                "   ||       |  V \\ ,|   \n" +
                "   ||       |    |` |   \n" +
                "   ||       |    |   \\  \n" +
                "   ||       |    \\    \\ \n" +
                "   ||       |     |    \\\n" +
                "   ||       |      \\_,-'\n" +
                "   ||       |___,,--\")_\\\n" +
                "   ||         |_|   ccc/\n" +
                "   ||        ccc/       \n" +
                "\n");
        return wizardCharacter;
    }
}
