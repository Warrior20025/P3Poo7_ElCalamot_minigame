package main;


import classes.Personatge;

public class Main {

    private static AskData ask;

    public static void main(String[] args) {
        boolean engine = true;
        while (engine) {
            System.out.println("1. Crear personaje\n2. Modificar personaje\n3. Ranking\n4. Eliminar personatje\n5. Mejor personaje\n6. JUGAR\n7. SALIR");
            int opcion = ask.askInt("Dime una opción: ", "Dime una opción correcta: ", 1, 7);
            switch (opcion) {
                case 1:
                    String nombre = ask.askString("Dime el nombre del personaje: ");
                    String tipo = ask.askString("Dime el tipo de " + nombre + ": ");
                    Personatge nuevoPersonage = new Personatge(nombre, tipo);
            }

        }
    }
}