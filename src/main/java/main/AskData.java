/*
 * Clase auxiliar para pedir datos al usuario
 */
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author mfontana
 */
public class AskData {

    // atributo para pedir datos al usuario
    private BufferedReader br;

    public AskData() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    // Método para pedir una cadena
    // Método que recibe un mensaje a mostrar al pedir el dato al usuario
    // devuelve un Strig con la respuesta
    public String askString(String msg) {
        System.out.println(msg);
        String answer = "";
        try {
            answer = br.readLine();
            while (answer.isEmpty()) {
                System.out.println("No puedes dejar la respuesta en blanco");
                answer = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Ha ocurrido un error inesperado.");
        }
        return answer;
    }

    // Método que recibe un mensaje a mostrar al pedir el dato al usuario
    // devuelve un número entero introducido por el usuario
    public int askInt(String msg) {
        int n = 0;
        boolean error = false;
        do {
            try {
                System.out.print(msg);
                n = Integer.parseInt(br.readLine());
                error = false;
            } catch (IOException ex) {
                System.out.println("Se ha producido un error no esperado!!");
                error = true; // Este no se dará nunca.
            } catch (NumberFormatException e) {
                System.out.println("Tienes que poner un número entero");
                error = true;
            }
        } while (error);
        return n;
    }
    
    // Método para pedir un entero con un min
    // Recibe Mensaje para mostrar al usuario
    // recibe mensaje de error al mostrar si el número no cumple mínimo
    // recibe un int como valor mínimo
    // devuelve un entero mayor o igual que el mínimo
    public int askInt(String msg, String errorMsg, int min) {
        int n = askInt(msg);
        while (n < min) {
            System.out.println(errorMsg);
            n = askInt(msg);
        }
        return n;
    }
    
    // Método análogo al anterior pero con min y max
    public int askInt(String msg, String errorMsg, int min, int max) {
        int n = askInt(msg);
        while (n < min || n > max) {
            System.out.println(errorMsg);
            n = askInt(msg);
        }
        return n;
    }

}
