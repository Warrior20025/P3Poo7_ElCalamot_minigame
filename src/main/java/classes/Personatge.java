package classes;

public class Personatge {
    private String nombre;
    private String tipo;
    private int fuerza;
    private int agilidad;
    private int resistencia;
    private int vida;
    private int nivel;
    private int experiencia;

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

    public Personatge(String nombre, String tipo, int fuerza, int agilidad, int resistencia, int vida, int nivel, int experiencia) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.resistencia = resistencia;
        this.vida = vida;
        this.nivel = nivel;
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

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
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

    public void displayAttributes() {
        System.out.println("Nombre: " + getNombre() + "  Tipo: " + getTipo() + "  Fuerza: "
            + getFuerza() + "  Agilidad: " + getAgilidad() + "  Resistencia: "
            + getResistencia() + "  Vida: " + getVida() + "  Nivel: " + getNivel()
            + "  Experiencia: " + getExperiencia() + "\n");
    }

}
