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

    public Personatge() {
        this.nombre = "";
        this.tipo = "";
        this.fuerza = 0;
        this.agilidad = 0;
        this.resistencia = 0;
        this.vida = 0;
        this.nivel = 0;
        this.experiencia = 0;
        this.ataque_guerrero = 0;
        this.ataque_mago = 0;
        this.ataque_elfo = 0;
        this.ataque_NPC = 0;
        this.potions = 0;
    }

    public Personatge(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fuerza = 50;
        this.agilidad = 50;
        this.resistencia = 50;
        this.vida = 100;
        this.nivel = 1;
        this.experiencia = 1000;
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

    //TIPOS ATAQUES con display de output de cada caso
    public void ataque_guerrero(Personatge enemigo) {
        if (getAtaque_guerrero() > enemigo.getResistencia()) {
            System.out.println(nombre + " atacó con un espadazo a " + enemigo.getNombre() + " causando " + (getAtaque_guerrero() - enemigo.getResistencia()) + " de daño.");
            enemigo.takeDamage(getAtaque_guerrero());
        }
        else {
            System.out.println(nombre + " atacó a " + enemigo.getNombre() + " causando 0 de daño. Resistencia del enemigo muy alta.");
        }
    }

    public void ataque_mago(Personatge enemigo) {
        if (getAtaque_mago() > enemigo.getResistencia()) {
            System.out.println(nombre + " lanzó un hechizo a " + enemigo.getNombre() + " causando " + (getAtaque_mago() - enemigo.getResistencia()) + " de daño.");
            enemigo.takeDamage(getAtaque_mago());
        }
        else {
            System.out.println(nombre + " atacó a " + enemigo.getNombre() + " causando 0 de daño. Resistencia del enemigo muy alta.");
        }
    }

    public void ataque_elfo(Personatge enemigo) {
        if (getAtaque_elfo() > enemigo.getResistencia()) {
            System.out.println(nombre + " lanzó una flecha a " + enemigo.getNombre() + " causando " + (getAtaque_elfo() - enemigo.getResistencia()) + " de daño.");
            enemigo.takeDamage(getAtaque_elfo());
        }
        else {
            System.out.println(nombre + " atacó a " + enemigo.getNombre() + " causando 0 de daño. Resistencia del enemigo muy alta.");
        }
    }

    public void ataque_NPC(Personatge player) {
        System.out.println("Te ataca el enemigo!");
        if (getAtaque_NPC() > player.getResistencia()) {
            System.out.println(nombre + " atacó a " + player.getNombre() + " causando " + (getAtaque_NPC() - player.getResistencia()) + " de daño.");
            player.takeDamage(getAtaque_NPC());
        }
        else {
            System.out.println(nombre + " atacó a " + player.getNombre() + " causando 0 de daño. Tu resistencia es mas alta que el daño que hace el enemigo.");
        }
    }

    public void ataqueFuerte_guerrero(Personatge enemigo) {
        System.out.println("Has dado golpe crítico!!");
        int dañoFuerte = getAtaque_guerrero() * 2;
        if (dañoFuerte > enemigo.getResistencia()) {
            System.out.println(nombre + " ha dado un espadazo crítico " + enemigo.getNombre() + " causando " + (dañoFuerte - enemigo.getResistencia()) + " de daño.");
            enemigo.takeDamage(dañoFuerte);
        }
        else {
            System.out.println(nombre + " atacó a " + enemigo.getNombre() + " causando 0 de daño. Resistencia del enemigo muy alta.");
        }

    }

    public void ataqueFuerte_mago(Personatge enemigo) {
        System.out.println("Has dado golpe crítico!!");
        int dañoFuerte = getAtaque_mago() * 2;
        if (dañoFuerte > enemigo.getResistencia()) {
            System.out.println(nombre + " ha dado un golpe crítico con este hechizo a " + enemigo.getNombre() + " causando " + (dañoFuerte - enemigo.getResistencia()) + " de daño.");
            enemigo.takeDamage(dañoFuerte);
        }
        else {
            System.out.println(nombre + " atacó a " + enemigo.getNombre() + " causando 0 de daño. Resistencia del enemigo muy alta.");
        }
    }

    public void ataqueFuerte_elfo(Personatge enemigo) {
        System.out.println("Has dado golpe crítico!!");
        int dañoFuerte = getAtaque_elfo() * 2;
        if (dañoFuerte > enemigo.getResistencia()) {
            System.out.println(nombre + " ha dado con la flecha en la cabeza a " + enemigo.getNombre() + " causando un golpe crítico de " + (dañoFuerte - enemigo.getResistencia()) + " de daño.");
            enemigo.takeDamage(dañoFuerte);
        }
        else {
            System.out.println(nombre + " atacó a " + enemigo.getNombre() + " causando 0 de daño. Resistencia del enemigo muy alta.");
        }
    }

    //IMPROVE STATS
    public void improveWarriorStats() {
        setFuerza(getFuerza()+125);
        setAgilidad(getAgilidad()+50);
        setVida(getVida()+85);
        setExperiencia(getExperiencia()+1000);
        setNivel(getNivel());
        setAtaque_guerrero(getAtaque_guerrero()+55);
        setPotions(getPotions()+1);
    }

    public void improveMageStats() {
        setFuerza(getFuerza()+105);
        setAgilidad(getAgilidad()+80);
        setVida(getVida()+111);
        setExperiencia(getExperiencia()+1000);
        setNivel(getNivel());
        setAtaque_mago(getAtaque_mago()+65);
        setPotions(getPotions()+2);
    }

    public void improveElfStats() {
        setFuerza(getFuerza()+105);
        setAgilidad(getAgilidad()+120);
        setVida(getVida()+85);
        setExperiencia(getExperiencia()+1000);
        setNivel(getNivel());
        setAtaque_elfo(getAtaque_elfo()+70);
        setPotions(getPotions()+1);
    }

    public void improveGlobalStats() {
        setFuerza(getFuerza()+25);
        setAgilidad(getAgilidad()+25);
        setResistencia(getResistencia()+5);
        setVida(getVida()+25);
        setExperiencia(getExperiencia()+100);
        setNivel(getNivel());
        setAtaque_guerrero(getAtaque_guerrero()+25);
        setAtaque_mago(getAtaque_mago()+25);
        setAtaque_elfo(getAtaque_elfo()+25);
    }

    //DAÑO
    public void takeDamage(int daño) {
        if (getResistencia() < daño) {
            this.vida -= daño - getResistencia();
            if (vida < 0) {vida = 0;}
            System.out.println(nombre + " recibió " + (daño - getResistencia()) + " de daño. Vida restante: " + vida);

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
    public void heal() {
        int curacion = 20;
        this.vida += curacion;
        System.out.println(nombre + " se curó y recuperó " + curacion + " de vida. Vida actual: " + vida);
    }

    public void usePotions() {
        System.out.println("Usas pocion de curación -->");
        int pocion = 100;
        this.vida += pocion;
        System.out.println(nombre + " se curó y recuperó " + pocion + " de vida. Vida actual: " + vida);
        potions --;
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

    public void setAtaque_guerrero(int ataque_guerrero) {
        this.ataque_guerrero = ataque_guerrero;
    }

    //getters de ataques con especificaciones
    public int getAtaque_guerrero() {
        ataque_guerrero = getFuerza() * 75 / 100 + getAgilidad() * 25 / 100;
        return ataque_guerrero;
    }

    public int getAtaque_mago() {
        ataque_mago = getFuerza() * 75 / 100 + getAgilidad() * 25 / 100;
        return ataque_mago;
    }

    public int getAtaque_elfo() {
        ataque_elfo = getFuerza() * 75 / 100 + getAgilidad() * 25 / 100;
        return ataque_elfo;
    }

    //------------------------------------------------

    public void setAtaque_mago(int ataque_mago) {
        this.ataque_mago = ataque_mago;
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

    public int getNivel() {     //cada nivel son 1000 de experiencia
        int resultado = experiencia / 1000;
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
        System.out.println("Nombre: " + getNombre() + " | Tipo: " + getTipo() + " | Fuerza: "
            + getFuerza() + " | Agilidad: " + getAgilidad() + " | Resistencia: "
            + getResistencia() + " | Vida: " + getVida() + " | Nivel: " + getNivel()
            + " | Experiencia: " + getExperiencia() + " | Pociones: " + getPotions() + "\n");
    }

    public void displayNPCAttributes() {
        System.out.println("Nombre: " + getNombre() + " | Nivel: " + getNivel() + " | Fuerza: "
                + getFuerza() + " | Agilidad: " + getAgilidad() + " | Resistencia: "
                + getResistencia() + " | Vida: " + getVida() + "\n");
    }

}
