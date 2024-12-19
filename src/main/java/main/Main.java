package main;


public class Main {
    private static AskData ask;
    public static void main(String[] args) {
        boolean engine = true;
        while (engine) {
            System.out.println("1. Crear personaje \n2.Modificar personaje \n3.Jugar \n4. POWER OFF");
            int opcion = ask.askInt("Dime una opción:","Dime una opción correcta",1,4);
        }

    }
}