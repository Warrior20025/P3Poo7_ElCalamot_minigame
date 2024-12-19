package main;


public class Main {

    private static AskData ask;

    public static void main(String[] args) {
        boolean engine = true;
        while (engine) {
            System.out.println("1. Crear personage\n2. Modificar personage\n3. JUGAR\n4. POWER OFF");
            int opcion = ask.askInt("Dime una opción: ", "Dime una opción correcta: ", 1, 4);

        }
    }
}