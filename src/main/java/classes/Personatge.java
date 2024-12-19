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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public double getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(double experiencia) {
        this.experiencia = experiencia;
    }
}
