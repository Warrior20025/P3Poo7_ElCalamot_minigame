package classes;

public class Personatge {
    private String nombre;
    private String tipo;
    private int fuerza;
    private double vida;
    private int nivel;
    private double experiencia;

    public Personatge(String nombre, String tipo, int fuerza, double experiencia) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fuerza = fuerza;
        this.vida = 100;
        this.nivel = 0;
        this.experiencia = experiencia;
    }
}
