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
    private int ataque_guerrero;
    private int ataque_mago;
    private int ataque_elfo;
    private int ataque_NPC;
    private int potions;


    public Personatge(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fuerza = 50;
        this.agilidad = 50;
        this.resistencia = 50;
        this.vida = 100;
        this.nivel = 0;
        this.experiencia = 0;
        this.ataque_guerrero = 100;
        this.ataque_mago = 100;
        this.ataque_elfo = 100;
        this.ataque_NPC = 100;
        this.potions = 5;
    }

    public Personatge(String nombre, String tipo, int fuerza, int agilidad, int resistencia, int vida, int nivel, int experiencia, int ataque_guerrero, int ataque_mago, int ataque_elfo, int ataque_NPC, int potions) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.resistencia = resistencia;
        this.vida = vida;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.ataque_guerrero = ataque_guerrero;
        this.ataque_mago = ataque_mago;
        this.ataque_elfo = ataque_elfo;
        this.ataque_NPC = ataque_NPC;
        this.potions = potions;
    }

    //TIPOS ATAQUES
    public void ataque_guerrero(Personatge enemigo) {
        enemigo.recibirDaño(getAtaque_guerrero());
        System.out.println(nombre + " atacó a " + enemigo.getNombre() + " causando " + getAtaque_guerrero() + " de daño.");
    }

    public void ataque_mago(Personatge enemigo) {
        enemigo.recibirDaño(getAtaque_mago());
        System.out.println(nombre + " atacó a " + enemigo.getNombre() + " causando " + getAtaque_mago() + " de daño.");
    }

    public void ataque_elfo(Personatge enemigo) {
        enemigo.recibirDaño(getAtaque_elfo());
        System.out.println(nombre + " atacó a " + enemigo.getNombre() + " causando " + getAtaque_elfo() + " de daño.");
    }

    public void ataqueFuerte_guerrero(Personatge enemigo) {
        int dañoFuerte = getAtaque_guerrero() * 2;
        enemigo.recibirDaño(dañoFuerte);
        System.out.println(nombre + " usó Ataque Fuerte contra " + enemigo.getNombre() + " causando " + dañoFuerte + " de daño.");
    }

    public void ataqueFuerte_mago(Personatge enemigo) {
        int dañoFuerte = getAtaque_mago() * 2;
        enemigo.recibirDaño(dañoFuerte);
        System.out.println(nombre + " usó Ataque Fuerte contra " + enemigo.getNombre() + " causando " + dañoFuerte + " de daño.");
    }

    public void ataqueFuerte_elfo(Personatge enemigo) {
        int dañoFuerte = getAtaque_elfo() * 2;
        enemigo.recibirDaño(dañoFuerte);
        System.out.println(nombre + " usó Ataque Fuerte contra " + enemigo.getNombre() + " causando " + dañoFuerte + " de daño.");
    }


    //DAÑO
    public void recibirDaño(int daño) {
        if (getResistencia() < daño) {
            this.vida -= daño - getResistencia();
            System.out.println(nombre + " recibió " + daño + " de daño. Vida restante: " + vida);
        }
        else {
            System.out.println(nombre + " no recibió daño. Vida restante: " + vida);
        }
        if (vida < 0) {vida = 0;}

        if (vida == 0) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }


    //CURAR
    public void curar() {
        int curacion = 20;
        this.vida += curacion;
        System.out.println(nombre + " se curó y recuperó " + curacion + " de vida. Vida actual: " + vida);
    }


    //esta vivo?
    public boolean isAlive() {
        return vida > 0;
    }


    //getters i setters
    public int getPotions() {
        return potions;
    }

    public void setPotions(int potions) {
        this.potions = potions;
    }

    public int getAtaque_NPC() {
        return ataque_NPC;
    }

    public void setAtaque_NPC(int ataque_NPC) {
        this.ataque_NPC = ataque_NPC;
    }

    public int getAtaque_guerrero() {
        return ataque_guerrero;
    }

    public void setAtaque_guerrero(int ataque_guerrero) {
        this.ataque_guerrero = ataque_guerrero;
    }

    public int getAtaque_mago() {
        return ataque_mago;
    }

    public void setAtaque_mago(int ataque_mago) {
        this.ataque_mago = ataque_mago;
    }

    public int getAtaque_elfo() {
        return ataque_elfo;
    }

    public void setAtaque_elfo(int ataque_elfo) {
        this.ataque_elfo = ataque_elfo;
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
        int resultado = experiencia / 100;
        nivel = resultado;
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


    //MOSTRAR STATS
    public void displayAttributes() {
        System.out.println("Nombre: " + getNombre() + "  Tipo: " + getTipo() + "  Fuerza: "
            + getFuerza() + "  Agilidad: " + getAgilidad() + "  Resistencia: "
            + getResistencia() + "  Vida: " + getVida() + "  Nivel: " + getNivel()
            + "  Experiencia: " + getExperiencia() + " Pociones: " + getPotions() + "\n");
    }

    public void displayNPCAttributes() {
        System.out.println("Nombre: " + getNombre() + " Nivel: " + getNivel() + "  Fuerza: "
                + getFuerza() + "  Agilidad: " + getAgilidad() + "  Resistencia: "
                + getResistencia() + "  Vida: " + getVida() + "\n");
    }

}
