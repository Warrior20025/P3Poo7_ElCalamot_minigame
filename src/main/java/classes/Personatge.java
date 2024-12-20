package classes;

public class Personatge {
    private String nombre;
    private String tipo;
    private int fuerza;
    private int agilidad;
    private int resistencia;
    private double vida;
    private int nivel;

    public int getAgilidad() {
        return agilidad;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    private double experiencia;


    public Personatge(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fuerza = 50;
        this.agilidad = 50;
        this.resistencia = 50;
        this.vida = 100;
        this.nivel = 0;
        this.experiencia = 0;

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

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }
}
